package edu.cscc.javaadventure;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("The adventure begins!");

        Character wizard = new Character("Gandalf");
        Character fighter = new Character("Gimli");
        Character ringBearer = new Character("Frodo");

        Party party = new Party();
        party.addMember(wizard);
        party.addMember(fighter);
        party.addMember(ringBearer);


        List<Character> members = party.getMembers();
        System.out.println("Party size: " + party.size());
        for (Character character : members) {
            System.out.println(character.getName());
        }

    }
}
