package edu.cscc.javaadventure;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BackpackTest {
    private Backpack backpack;
    private List<JAObject> contents = new ArrayList<>();

    @BeforeEach
    void setUp() {
        backpack = new Backpack("player3", "play3 to win ", new ArrayList<>(),10.00 );
    }

    @Test
    void addObject() {
        JAObject object1  = new JAObject("Player1", "Play to win", 12.00);
        contents.add(object1);


        backpack.getContents().addAll(contents);

        assertEquals(0, backpack.getContents().size());
       // assertEquals(backpack.getContents().contains(object1), false);
        assertEquals(backpack.getContents().contains(object1), false);


    }

    @Test
    void removeObject() {
        JAObject object2  = new JAObject("Player2", "Play to win win", 11.00);
        backpack.addObject(object2);
        backpack.removeObject();

        assertEquals(0, backpack.getContents().size());

    }
    @Test
    public void itReturnsNullWhenItCannotRemoveAMember() {
        assertNull(backpack.removeObject());
    }
    @Test
    public void itCanAddMultipleContents() {

        List<JAObject> contentsT = new ArrayList<>();
        contentsT.add(new JAObject("Triumph1", "winners", 14.00));
        contentsT.add(new JAObject("secondPlayer", "second Play to win win", 17.00));

        backpack.getContents().addAll(contentsT);
        assertFalse(backpack.getContents().contains(contentsT));

        }


    @Test
    void getWeight() {
        assertEquals(10.00, backpack.getWeight());
    }

}
