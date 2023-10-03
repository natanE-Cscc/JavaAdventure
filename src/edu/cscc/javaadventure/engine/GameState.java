package edu.cscc.javaadventure.engine;

import edu.cscc.javaadventure.Party;
import edu.cscc.javaadventure.Room;

/**
 * This class represents the state of the game from one tick to the next.
 * A new game state will be generated on every tick.
 */
public class GameState {

    //TODO Complete this method per the requirements.
    final Party party;

    final Room currentRoom;

    final boolean isPlaying;

    public GameState(Party party, Room currentRoom, boolean isPlaying) {
        this.party = party;
        this.currentRoom = currentRoom;
        this.isPlaying = isPlaying;
    }

    public Party getParty() {
        return party;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public boolean isPlaying() {
        return isPlaying;
    }



    /**
     * Build the description of the game in its current state
     * for the user.
     * @return The description of the game in its current state.
     */
    public String getCurrentDescription() {
        //TODO Complete this method per the requirements.

        String currentDescription = currentRoom.getDescription();

        String membersList = party.getMembers()
                .stream()
                .map(currentMembers -> currentMembers.getName().concat( " is standing here."))
                .reduce(currentDescription, (memberDescription, actionDescription)
                        ->memberDescription + actionDescription );

        System.out.println(currentDescription);
        return membersList;


    }

    }

