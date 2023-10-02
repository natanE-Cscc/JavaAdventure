package edu.cscc.javaadventure.engine.combat;

import edu.cscc.javaadventure.Character;
import edu.cscc.javaadventure.Weapon;
import edu.cscc.javaadventure.engine.InvalidRollException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GoblinTest {
    private Character character;
    private Spear spear;

    private CharacterCombatant characterCombatant;
    private Goblin goblin;

    private Combatant combatant;
    private Weapon weapon;

    @BeforeEach
    public void setUp() {
        character = new Character("goWinner");
        character.setHealth(10);
        character.setDexterity(16);
        character.setStrength(16);
        //characterCombatant = new CharacterCombatant(character);
        goblin = new Goblin();

    }

    @Test
    void testGoblinReceiveDamage() {
        int initialHealth = goblin.getHealth();
        int damage = 5;
        goblin.receiveDamage(damage);
        int newHealth = goblin.getHealth();
        assertEquals(initialHealth - damage, newHealth);

    }

    @Test
    void canGetGoblinName() {
        assertEquals("Goblin", goblin.getName());
    }

    @Test
    void isActiveGoblinCombatant() {
        if (goblin.getHealth() > 0) {

            assertTrue(goblin.isActiveCombatant());
        }
    }

    @Test
    void testCharacterCombatAttackWhileDefeatedOne() throws IllegalStateException, InvalidRollException, OpponentIncapacitatedException {
        if (!goblin.isActiveCombatant()) {
            int roll2 = 0;
            String result = goblin.attack(roll2, combatant);
            assertTrue(result.contains("Invalid roll is not in the given limit"));
        }
    }

    @Test
    void testCharacterCombatAttackWhileDefeatedTwo() throws IllegalStateException, InvalidRollException, OpponentIncapacitatedException {
        if (!goblin.isActiveCombatant()) {
            int roll45 = 0;
            String result = goblin.attack(roll45, combatant);
            assertTrue(result.contains("Cannot attack while defeated"));
        }
    }

    @Test
    public void calculateInitiativeUpperCheck() throws InvalidRollException {
        int roll = 12;
        assertThrows(InvalidRollException.class, () -> {
            goblin.calculateInitiative(roll);
        });

    }

    @Test
    public void calculateBelowInitiativeCheck() throws OpponentIncapacitatedException, InvalidRollException {
        int roll = 0;
        assertThrows(InvalidRollException.class, () -> {
            goblin.calculateInitiative(roll);
        });


    }

    @Test
    public void calculateEqualInitiativeEqualOneCheck() throws OpponentIncapacitatedException, InvalidRollException {
        int roll = 1;
        goblin.calculateInitiative(roll);
        assertEquals(goblin.getInitiative(), 1);


    }

    @Test
    void testGoblinAttackFailure() throws OpponentIncapacitatedException, InvalidRollException {
        int roll = 0;
        assertThrows(InvalidRollException.class, () -> {
            goblin.attack(roll, combatant);
        });

    }

    @Test
    void testGoblinAttackFailureTwo() throws OpponentIncapacitatedException, InvalidRollException {
        int roll = 23;
        assertThrows(InvalidRollException.class, () -> {
            goblin.attack(roll, combatant);
        });
    }

    @Test
    public void testGoblinAttackSuccessOne() throws OpponentIncapacitatedException, InvalidRollException {
        int roll = 23;
        goblin.getArmorClass();
        assertThrows(InvalidRollException.class, () -> {
            goblin.attack(roll, combatant);
        });


    }

    @Test
    public void testGoblinAttackFSuccessTwo() throws OpponentIncapacitatedException, InvalidRollException {
        int roll = 0;
        goblin.getArmorClass();
        assertThrows(InvalidRollException.class, () -> {
            goblin.attack(roll, combatant);
        });


    }

    @Test
    void testGoblinEquipWeaponTwo() throws UnableToWieldWeaponException {
        if (goblin.getWeapon().equals(spear)) {
            Weapon weapon3 = goblin.getWeapon();
            assertThrows(UnableToWieldWeaponException.class, () -> goblin.equipWeapon(weapon3), "Goblins cannot use other weapon");
            //assertEquals("Goblins cannot use other weapon", exceptionE.getMessage());
        }
    }

    @Test
    void testGoblinAttackWhileDefeatedTwo() throws IllegalStateException, InvalidRollException, OpponentIncapacitatedException {
        if (!goblin.isActiveCombatant()) {
            int roll3 = 5;
            String result = goblin.attack(roll3, combatant);
            assertTrue(result.contains("Cannot attack while defeated"));
        }
    }

    @Test
    void testGoblinCombatTarget() throws OpponentIncapacitatedException {
        if (!goblin.isActiveCombatant()) {
            int rollAdd = 6;
            combatant.getArmorClass();
            OpponentIncapacitatedException goblinsCannotUseOtherWeapon = assertThrows(OpponentIncapacitatedException.class, () -> goblin.attack(rollAdd, combatant));
            assertEquals("Target combatant is not active", goblinsCannotUseOtherWeapon.getMessage());
        }
    }

    @Test
    void testGoblinCombatTargetTwo() throws OpponentIncapacitatedException, InvalidRollException {
        int roll = 7;
        if (roll >= goblin.getArmorClass()) {
            String result2 = goblin.attack(roll, combatant);
            assertTrue(result2.contains("points of damage"));
            assertEquals(true, roll > goblin.getHealth());
        }
    }

    @Test
    void testGoblinAttacks() throws InvalidRollException, OpponentIncapacitatedException {
        int rollGob = 16;
        goblin.attack(rollGob, goblin);
        assertTrue(rollGob > goblin.getHealth());

    }

    @Test
    void testGoblinMisses() throws InvalidRollException, OpponentIncapacitatedException {
        int rollGob1 = 2;
        goblin.attack(rollGob1, goblin);
        assertTrue(rollGob1 < goblin.getHealth());

    }

    @Test
    void testEquipWeaponGoblinScenarios() throws UnableToWieldWeaponException {
        this.weapon = new Spear();
        goblin.equipWeapon(weapon);
        assertFalse(goblin.getWeapon().equals(spear));

    }
}
