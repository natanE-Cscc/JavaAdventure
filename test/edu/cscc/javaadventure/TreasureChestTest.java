package edu.cscc.javaadventure;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TreasureChestTest {

    private TreasureChest treasureChest;

    @BeforeEach
    public void setUp() {
        treasureChest = new TreasureChest();

    }

    @Test
    void initializationWithDefaultValues() {
        assertEquals(10.00, treasureChest.getWeight());
        assertTrue(treasureChest.isLocked());
    }

    @Test
    void isOpen() {
        treasureChest.open();
        if (treasureChest.isOpen()) {
            assertFalse(treasureChest.isLocked());
        } else {
            assertTrue(treasureChest.isLocked());
        }
    }

    @Test
    void isLocked() {
        if (treasureChest.isLocked()) {
            assertTrue(treasureChest.isLocked());
        } else {
            assertFalse(treasureChest.isLocked());
        }
    }

    @Test
    void lock() {
        treasureChest.lock();
        treasureChest.close();
        assertTrue(treasureChest.isLocked());
    }

    @Test
    void unlock() {
        treasureChest.unlock();
        assertFalse(treasureChest.isLocked());
    }

    @Test
    void open() {


        if (treasureChest.isLocked()) {
            assertFalse(treasureChest.open());
        } else {
            treasureChest.open();
            assertTrue(treasureChest.open());
            assertTrue(treasureChest.isOpen());
        }
    }
    @Test
    void closed() {
        treasureChest.close();
        assertFalse(treasureChest.isOpen());
    }
    @Test
    void getDescription() {
        assertEquals(treasureChest.getDescription(), "A sturdy iron chest. " + treasureChest.getLockDescription());
    }
   @Test
    void getLockDescription() {


        if(treasureChest.isLocked() ) {
            assertEquals( treasureChest.getLockDescription(),"It is locked.");

        } else {
            assertEquals(treasureChest.getLockDescription(),"It is unlocked.");
        }
    }

}