package edu.cscc.javaadventure.engine;

import edu.cscc.javaadventure.Party;
import edu.cscc.javaadventure.Character;
import edu.cscc.javaadventure.JAObject;
import edu.cscc.javaadventure.MovableObject;

import edu.cscc.javaadventure.Room;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;


import static org.junit.jupiter.api.Assertions.*;

class GameStateTest {
    private GameState gameState;
    private Party party;
    private boolean isPlaying;
    private Room currentRoom;

    private Character character;
    private JAObject jaObject;
    private MovableObject movableObject;

    @BeforeEach
    void setUp() {
        character = new Character("Best Player");
        party = new Party();
        party.addMember(character);
        isPlaying =true;
        currentRoom = new Room("battle ground ", "Fighting room ");
        gameState = new GameState(party, currentRoom, isPlaying);


    }

    @Test
    void getParty() {
        assertEquals(party, gameState.getParty());
    }

    @Test
    void getCurrentRoom() {
        assertEquals(currentRoom, gameState.getCurrentRoom());
    }

    @Test
    void isPlaying() {
        assertEquals(true, gameState.isPlaying());
    }

    @Test
    void getCurrentDescription() {
        Room roomOne = new Room("battle ground ", "Fighting room ");
        roomOne.connectRoom("down", roomOne);
        Party partyOne = new Party();
        partyOne.addMember(character);

        List<Character> memberLists = partyOne.getMembers();
        String currentDescription = roomOne.getDescription();

        String testDescriptionOne = memberLists
                .stream()
                .map(currentMembers -> currentMembers.getName().concat( " is standing here."))
                .reduce(currentDescription, (memberDescription, actionDescription)
                        ->memberDescription + actionDescription );

        assertEquals(testDescriptionOne, gameState.getCurrentDescription());
    }

}