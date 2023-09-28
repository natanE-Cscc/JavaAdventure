package edu.cscc.javaadventure.engine.combat;

import edu.cscc.javaadventure.Character;
import edu.cscc.javaadventure.JAObject;
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

        characterCombatant = new CharacterCombatant(character);
        //characterCombatant.getWeapon();



        goblin = new Goblin();
    }

    @Test
    void receiveDamage() {
        int initialHealth = character.getHealth();
        int damage = 5;
        characterCombatant.receiveDamage(damage);
        int newHealth = character.getHealth();
        assertEquals(initialHealth-damage, newHealth);
    }

    @Test
    void isActiveCombatant() {
        int initialGoblinHealth = goblin.getHealth();
        int roll = 16;

        String result = characterCombatant.attack(roll, goblin);

        assertTrue(result.contains("deals"));
        assertTrue(goblin.getHealth() < initialGoblinHealth);

    }
    @Test
    void isNotActiveCombatant() {
        int roll = 5;

        String result = characterCombatant.attack(roll, goblin);
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
    void testGoblinReceiveDamage() {
        int initialHealth = goblin.getHealth();
        int damage = 5;
        goblin.receiveDamage(damage);
        int newHealth = goblin.getHealth();
        assertEquals(initialHealth-damage, newHealth);

    }
    @Test
    void testGoblinAttackSuccess() throws OpponentIncapacitatedException, InvalidRollException {
        int initialCharacterHealth = character.getHealth();
        int roll = 15;

        String result = goblin.attack(roll, characterCombatant);
        assertTrue(result.contains("deals"));
        assertTrue(character.getHealth() < initialCharacterHealth);
    }
    @Test
    void testGoblinAttackFailure() throws OpponentIncapacitatedException, InvalidRollException {
        int roll = 5;

        String result = goblin.attack(roll, characterCombatant);
        assertTrue(result.contains("misses"));
    }
    @Test
    void testGoblinAttackWhileDefeated() {
        goblin.receiveDamage(goblin.getHealth());
        assertThrows(IllegalStateException.class, () -> goblin.attack(16, characterCombatant));;
    }
    @Test
    void canGetName() {
        assertEquals("Winner", character.getName());
    }

    @Test
    void canGetWeapon() {

        assertEquals(character.getStrength(), 10);
    }

}