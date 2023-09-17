package edu.cscc.javaadventure;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class RoomTest {
    private JAObject jaObject;
    private HashMap<String, JAObject> rooms = new HashMap<String, JAObject>();
    private HashMap<String, JAObject> contents = new HashMap<>();

    @BeforeEach
    void setUp() {
        Room room1 = new Room("Room N", "room of North side directed ");
        Room room2 = new Room("Room S", "room of South side");
        Room room3 = new Room("Room E", "room of East side");
        Room room4 = new Room("Room W", "room of West side");
        Room room5 = new Room("Room Up", "room of Up side");
        Room room6 = new Room("Room Down", "room of Down side ");

        room1.connectRoom("NORTH", room2);
        room2.connectRoom("SOUTH", room1);
        room3.connectRoom("EAST", room4);
        room4.connectRoom("WEST", room3);
        room5.connectRoom("UP", room6);
        room6.connectRoom("DOWN", room5);
    }


    @Test
    void getName() {
        Room room1 = new Room("Room N", "room of North side directed ");
        assertEquals("Room N", room1.getName());
    }

    @Test
    void setName() {
        Room room1 = new Room("Room N", "room of North side directed ");
        room1.setName("Room N1");
        assertEquals("Room N1", room1.getName());
    }

    @Test
    void getDescription() {
        Room room1 = new Room("Room N", "room of North side directed ");
        assertEquals("room of North side directed ", room1.getDescription());
    }


    @Test
    void setDescription() {
        Room room1 = new Room("Room N", "room of North side directed ");
        room1.setDescription("Duplication of room of North side directed");
        assertEquals("Duplication of room of North side directed", room1.getDescription());
    }

    @Test
    void connectRoom() {
       // String direction = "NORTH";
        Room room1 = new Room("Room N", "room of North side directed ");
        Room room2 = new Room("Room S", "room of South side");
        room2.connectRoom("SOUTH", room1);


    }

    @Test
    void roomDisconnect() {
        Room room1 = new Room("Room N", "room of North side directed ");
        Room room2 = new Room("Room S", "room of South side");
        Room room3 = new Room("Room E", "room of East side");
        Room room4 = new Room("Room W", "room of West side");
        Room room5 = new Room("Room Up", "room of Up side");
        Room room6 = new Room("Room Down", "room of Down side ");

        room1.disconnectRoom("NORTH");
        room2.disconnectRoom("SOUTH");
        room3.disconnectRoom("EAST");
        room4.disconnectRoom("WEST");
        room5.disconnectRoom("UP");
        room6.disconnectRoom("DOWN");

    }

    @Test
    void getRoom() {
       Room room1 = new Room("Room N", "room of North side directed ");
       Room room2 = new Room("Room S", "room of South side");
        assertEquals(room1.connectRoom("NORTH", room2), room2.getRoom("NORTH"));

    }
    @Test
    void itCanHandleAddContent() {
        JAObject jaObject1 = new JAObject("Room N", "Awesome side of room table size ", 10.60 );
        JAObject jaObject2 = new JAObject("Room North Updated", "Awesome side of room TV size ", 65.60 );

        Room rooms = new Room("Northern Temple", "The Rich people lives here");
        rooms.addToContents(jaObject1);
        rooms.addToContents(jaObject2);
        HashMap<String, JAObject> contents1 = new HashMap<>();
        contents1.put("Room N", jaObject1);
        contents1.put("Room North Updated", jaObject2);

        assertTrue(jaObject1.getName().contains("Room N"));
        assertTrue(contents1.containsValue(jaObject1));
        assertEquals(2,contents1.size());

    }
    @Test
    public void itCanRemoveAMemberByName() {
        JAObject jaObject1 = new JAObject("Room N", "Awesome side of room table size ", 10.60 );
        Room rooms = new Room("Northern Temple", "The Rich people lives here");
        rooms.addToContents(jaObject1);
        HashMap<String, JAObject> contents1 = new HashMap<>();
        contents1.put("Room N", jaObject1);

        assertEquals(jaObject1,rooms.removeFromContents("Room N"));
        assertTrue(contents.isEmpty());
    }

    @Test
    void itCanHandleListOfContents() {
        JAObject jaObject1 = new JAObject("Room N", "Awesome side of room table size ", 10.60 );
        JAObject jaObject2 = new JAObject("Room North Updated", "Awesome side of room TV size ", 65.60 );

        Room rooms = new Room("Northern Temple", "The Rich people lives here");
        rooms.addToContents(jaObject1);
        rooms.addToContents(jaObject2);
        HashMap<String, JAObject> contents1 = new HashMap<>();
        contents1.put("Room N", jaObject1);
        contents1.put("Room North Updated", jaObject2);
        rooms.listContents();

        assertTrue(contents1.containsValue(jaObject1));
        assertEquals(2, contents1.size());

    }

    }

