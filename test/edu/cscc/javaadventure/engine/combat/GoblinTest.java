package edu.cscc.javaadventure.engine.combat;

import edu.cscc.javaadventure.Character;
import edu.cscc.javaadventure.engine.InvalidRollException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GoblinTest {
    private Character character;
    private Spear spear;

    private CharacterCombatant characterCombatant;
    private Goblin goblin;
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
    void receiveDamage() {
        int initialHealth = goblin.getHealth();
        int damage = 5;
        goblin.receiveDamage(damage);
        int newHealth = goblin.getHealth();
        assertEquals(initialHealth-damage, newHealth);
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


}