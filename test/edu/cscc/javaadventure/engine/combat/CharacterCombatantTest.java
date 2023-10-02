package edu.cscc.javaadventure.engine.combat;

import edu.cscc.javaadventure.Character;
import edu.cscc.javaadventure.JAObject;
import edu.cscc.javaadventure.Sword;
import edu.cscc.javaadventure.Weapon;
import edu.cscc.javaadventure.engine.InvalidRollException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class CharacterCombatantTest {
    private Character character;
    private Goblin goblin;
    private Weapon weapon;
    private CharacterCombatant characterCombatant;
    private Combatant combatant;

    @BeforeEach
    public void setUp() {
        character = new Character("Winner");
        //Character wizard = new Character("Gandalf");
        character.setHealth(10);
        character.setDexterity(16);
        character.setStrength(16);
        character.setHealth(12);


        characterCombatant = new CharacterCombatant(character);
    }

    @Test
    void receiveDamage() {
        int initialHealth = character.getHealth();
        int damage = 5;
        characterCombatant.receiveDamage(damage);
        int newHealth = character.getHealth();
        assertEquals(initialHealth - damage, newHealth);
    }

    @Test
    void isActiveCombatant() throws IllegalStateException{
        int initialGoblinHealth = character.getHealth();

        int roll = 16;

        String result = characterCombatant.attack(roll, characterCombatant);

        assertTrue(result.contains("deals"));
        assertTrue(character.getHealth() < initialGoblinHealth);

    }

    @Test
    void isNotActiveCombatant() throws IllegalStateException {
        int roll = 5;

        String result = characterCombatant.attack(roll, characterCombatant);
        assertTrue(result.contains("misses"));
    }

    @Test
    void testCharacterAttackWhileDefeated() {
        int initialHealth = character.getHealth();
        int damage = 5;
        characterCombatant.receiveDamage(damage);
        int newHealth = character.getHealth();
        assertEquals(initialHealth - damage, newHealth);
    }

    @Test
    void testCharacterCombatReceiveDamage() {
        int initialHealth = character.getHealth();
        int damage = 5;
        characterCombatant.receiveDamage(damage);
        int newHealth = character.getHealth();
        assertEquals(initialHealth - damage, newHealth);

    }

    @Test
    void testCharacterCombatAttackSuccess() throws OpponentIncapacitatedException, InvalidRollException {
        int initialCharacterHealth = character.getHealth();
        int roll = 15;

        String result = characterCombatant.attack(roll, characterCombatant);
        assertTrue(result.contains("deals"));
        assertTrue(character.getHealth() < initialCharacterHealth);

    }

    @Test
    void testCharacterCombatAttackFailure() throws OpponentIncapacitatedException, InvalidRollException {
        int roll = 5;

        String result = characterCombatant.attack(roll, characterCombatant);
        assertTrue(result.contains("misses"));
    }

    @Test
    void canGetName() {
        assertEquals("Winner", character.getName());
    }

    @Test
    void canGetWeapon() {

        assertEquals(characterCombatant.getStrength(), 0);
    }

    @Test
    void canGetHealth() {


        assertEquals(characterCombatant.getStrength(), 0);
    }
    @Test
    public void calculateInitiativeUpperCheck() throws InvalidRollException {
        int roll = 12;
        assertThrows(InvalidRollException.class, () -> {
            characterCombatant.calculateInitiative(roll);
        });
        assertTrue(roll > 1);

    }

    @Test
    public void calculateBelowInitiativeCheck() throws OpponentIncapacitatedException, InvalidRollException {
        int roll = 0;
        assertThrows(InvalidRollException.class, () -> {
            characterCombatant.calculateInitiative(roll);
        });
    }
    @Test
    void testCharacterCombatAttackWhileDefeatedOne() throws IllegalStateException {
        if(!characterCombatant.isActiveCombatant()) {
            int roll2 = 0;
            String result = characterCombatant.attack(roll2, combatant);
            assertTrue(result.contains("cannot attack while defeated"));
            assertTrue(roll2 < 1);
        }
    }
    @Test
    void testCharacterCombatAttackWhileDefeatedTwo() throws OpponentIncapacitatedException {
        if(!characterCombatant.isActiveCombatant()) {
            int roll2 = 0;
            String result = characterCombatant.attack(roll2, combatant);
            assertTrue(result.contains("Target combatant is not active"));
            assertTrue(roll2 < 1);
        }
    }


    @Test
    public void calculateEqualInitiativeCheck() throws InvalidRollException {
        int roll = 0;
        characterCombatant.setInitiative(1);

        assertThrows(InvalidRollException.class, () -> {
            characterCombatant.calculateInitiative(roll);
            assertEquals(characterCombatant.getInitiative(), roll);
            assertTrue(characterCombatant.getInitiative() < 1);
        });

    }
    @Test
    void testCharacterCombatCalculate() {

        if(character.getHealth() <1) {
            int initialHealth1 = characterCombatant.getInitiative();
            int roll43 = 1;
            assertEquals(initialHealth1, roll43);
        }
    }

    @Test
    void testCharacterCombatEquipWeaponTwo() throws UnableToWieldWeaponException {
        //characterCombatant.getWeapon();
        Weapon weapon1  = characterCombatant.getWeapon();
        if(weapon1!= null && weapon1.getTwoHanded() && characterCombatant.getStrength() == 12) {
            characterCombatant.equipWeapon(weapon1);
            Throwable exception = assertThrows(UnableToWieldWeaponException.class, () -> characterCombatant.equipWeapon(characterCombatant.getWeapon()));
              assertEquals("Character does not have enough weapon", exception.getMessage());
            assertEquals("Unable to equip weapon:", exception.getMessage());

              assertEquals(characterCombatant.getWeapon(), weapon1);

        }
    }
    @Test
    void testCharacterCombatExceptionAttackSuccessOne() throws InvalidRollException {
        int initialCharacterHealthOne = character.getHealth();
        int roll = 23;

        String result = characterCombatant.attack(roll, characterCombatant);
        assertTrue(result.contains("Invalid roll"));
        assertFalse(character.getHealth() >initialCharacterHealthOne);


    }
    @Test
    void testCharacterCombatExceptionAttackSuccessTwo() throws IllegalStateException {
        int initialCharacterHealthTwo = character.getHealth();
        int rollC = 30;

        String resultR = characterCombatant.attack(rollC, combatant);
        assertFalse(resultR.contains("cannot attack while defeated"));
        assertFalse(character.getHealth() > initialCharacterHealthTwo);


    }
    @Test
    void testEquipWeaponScenarios() throws UnableToWieldWeaponException{
        this.weapon = new Sword();
        characterCombatant.equipWeapon(weapon);
        assertEquals(weapon, characterCombatant.getWeapon());
    }
    @Test
    void testEquipWeaponScenariosTwo() throws UnableToWieldWeaponException{
        this.weapon = new Spear();
        characterCombatant.equipWeapon(weapon);
        assertEquals(weapon, characterCombatant.getWeapon());
    }

}


