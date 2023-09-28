package edu.cscc.javaadventure.engine.combat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SpearTest {
    private Spear spear;

    @BeforeEach
    void setUp() {
        spear = new Spear();
    }


    @Test
    void canGetDamage() {
        assertEquals(3, spear.getDamage());
    }

    @Test
    void canGetTwoHanded() {
        assertFalse(spear.getTwoHanded());
    }
    @Test
    void canGetDescription() {
        assertEquals("It’s a pointy stick", spear.getDescription());
    }
}
