package edu.cscc.javaadventure;

import java.util.*;

/**
 * Represents a party of adventures in the JavaAdventure game.
 * Party can add, remove, find, and get members, as well as determining the size
 * of the party. Party members must have unique names.
 */
public class Party {
    private HashMap<String, Character> members;
    private AddPartyMemberEventHandler addPartyMemberEventHandler;
    private RemovePartyMemberEventHandler removePartyMemberEventHandler;

    public Party() {
        members = new HashMap<>();
    }

    /**
     * Adds a character as a member.
     * Character will not be added if it is not unique.
     * @param character
     */
    public void addMember(Character character) {
        members.put(character.getName(), character);
        addPartyMemberEventHandler.onEvent(character);
    }

    public void onAddPartyMember(AddPartyMemberEventHandler addPartyMemberEventHandler) {
        this.addPartyMemberEventHandler = addPartyMemberEventHandler;
    }

    /**
     * Removes a member by name.
     * @param name The name of the member.
     * @return The removed member, or null if they are not in the party.
     */
    public Character removeMember(String name) {
        Character removed = members.remove(name);
        if (removed != null) {
            removePartyMemberEventHandler.onEvent(removed);
        }

        return removed;
    }

    public void onRemovePartyMember(RemovePartyMemberEventHandler removePartyMemberEventHandler) {
        this.removePartyMemberEventHandler = removePartyMemberEventHandler;
    }

    /**
     * Returns the count of party members.
     * @return The number of members in the party.
     */
    public int size() {
        return members.size();
    }

    /**
     * Find a member by name.
     * @param name The name of the member to find.
     * @return The found member, or null if they could not be found.
     */
    public Character findMember(String name) {
        return members.get(name);
    }

    /**
     * Get the members of the party as a list.
     * @return A List of Characters who are members of the party.
     */
    public List<Character> getMembers() {
        ArrayList<Character> characters = new ArrayList<>();
        characters.addAll(members.values());

        return characters;
    }
}
