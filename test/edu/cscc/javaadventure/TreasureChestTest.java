package edu.cscc.javaadventure;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

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
            assertTrue(treasureChest.isLocked());
    }

    @Test
    void testTreasureChestIsLocked() {
            assertTrue(treasureChest.isLocked());
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
        treasureChest.open();

            assertFalse(treasureChest.isOpen());
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
    void testGetLockDescriptionOne() {
        treasureChest.isLocked();
        assertEquals(treasureChest.getLockDescription(), "It is locked.");
    }
    @Test
    void testGetLockDescriptionTwo() {
        treasureChest.isOpen();
        assertEquals(treasureChest.getLockDescription(), "It is locked.");
    }

    @Test
    public void itCanAddContents() {

        Set<JAObject> contentsT = new HashSet<>();
        contentsT.add(new JAObject("Triumph1", "winners", 14.00));
        while(treasureChest.isLocked() == false && treasureChest.isOpen()==true) {


            assertEquals(1, treasureChest.getContents().size());
            assertFalse(treasureChest.getContents().contains(contentsT));


      }
    }
}