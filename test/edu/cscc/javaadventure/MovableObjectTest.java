package edu.cscc.javaadventure;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MovableObjectTest {

    @BeforeEach
    public void setUp() {
        //comment this
        MovableObject movableObject = new MovableObjectImpl();

    }
    @Test
    void getRoom() {
        MovableObject movableObject = new MovableObjectImpl();
        Room room = new Room("SOUTH", "Southern Room ");
        movableObject.setRoom(room);
        assertEquals(room, movableObject.getRoom());
    }

    @Test
    void setRoom() {
        MovableObject movableObject = new MovableObjectImpl();
        Room room = new Room("NORTH", "Northern room ");
        movableObject.setRoom(room);
        assertEquals(room, movableObject.getRoom());

    }

    @Test
    void move() {
        MovableObject movableObject = new MovableObjectImpl();
        Room currentRoom = new Room("NORTH", "Northern Room ");
        Room newRoom = new Room("SOUTH", "Southern Room ");
        movableObject.setRoom(newRoom);
        newRoom.connectRoom("NORTH", currentRoom);
        movableObject.move(Direction.NORTH);
        assertEquals(currentRoom.getName(), movableObject.getRoom().getName());

    }
}