package edu.cscc.javaadventure;

import edu.cscc.javaadventure.engine.GameEngine;
import edu.cscc.javaadventure.engine.GameState;
import edu.cscc.javaadventure.engine.combat.Goblin;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("The adventure begins!");

        Character wizard = new Character("Gandalf");
        Character fighter = new Character("Gimli");
        Character ringBearer = new Character("Frodo");

        Party party = new Party();
        party.onAddPartyMember(character -> System.out.println(character.getName() + " has been added."));
        party.onRemovePartyMember(character -> System.out.println(character.getName() + " has been removed."));
        party.onMemberTake((memberName, target) -> {
            Character character = party.findMember(memberName);
            character.getBackpack().addObject(target);
            System.out.println(character.getName() + " added " + target.getName() + " to their backpack.");
        });

        Scanner scanner = new Scanner(System.in);
        boolean done = false;
        do {
            System.out.println("Choose your party members.");
            System.out.println("Who would you like to add?");
            System.out.println("1. " + wizard.getName());
            System.out.println("2. " + fighter.getName());
            System.out.println("3. " + ringBearer.getName());
            System.out.println("4. Done");
            System.out.print(" (Choices are 1, 2, 3, 4): ");
            String choice = scanner.nextLine();
            switch(choice) {
                case "1":
                    party.addMember(wizard);
                    break;
                case "2":
                    party.addMember(fighter);
                    break;
                case "3":
                    party.addMember(ringBearer);
                    break;
                case "4":
                    done = true;
                    break;
                default:
                    done = true;
                    party.addMember(wizard);
                    party.addMember(fighter);
                    party.addMember(ringBearer);
            }
        } while(!done);

        System.out.println("Party size: " + party.size());
        List<Character> members = party.getMembers();
        members.stream().map(character -> character.getName()).forEach(System.out::println);

        BasicObject someGold = new BasicObject("Some gold", "shiny gold coins", 0.5);
        party.memberTake(ringBearer.getName(), someGold);

        List<BasicObject> objects = Arrays.asList(
                new BasicObject("The One Ring", "A heavy gold ring", 0.5),
                new BasicObject("Lambas Bread", "Elven bread. Good for eating on the go.", 0.1),
                new BasicObject("Cookware", "Some pots and pans for cooking", 2.0)
                );
        objects.forEach((object) -> party.memberTake("Frodo", object));
        System.out.println("Searching for The One Ring");
        ringBearer.getBackpack()
                .getContents()
                .stream()
                .filter(object -> object.name.equals("The One Ring"))
                .findFirst()
                .ifPresent(found -> System.out.println("Found: " + found.getName()));
        System.out.println("Party size: " + party.size());

        Room room = new Room("A dark room.", "You are likely to be eaten by a grue.");

        try {
            TreasureChest treasureChest = new TreasureChest();
            treasureChest.unlock();
            treasureChest.open();
            treasureChest.addObject(new BasicObject("gold", "a big pile of gold", 1.0));
            treasureChest.lock();
            room.addToContents(treasureChest);
        } catch (ChestAlreadyOpenException e) {
            e.printStackTrace();
        } catch (ChestLockedException e) {
            e.printStackTrace();
        }
        room.addToContents(new Goblin());
        Room hallway = new Room("hallway", "A cobweb strewn hallway.");
        hallway.addToContents(new Lantern());
        room.connectRoom(Room.SOUTH, hallway);
        GameState gameState = new GameState(party, room, true);
        Scanner scannerTwo = new Scanner(System.in);
        while(gameState.isPlaying()) {
            System.out.println(gameState.getCurrentDescription());
            gameState = GameEngine.tick(gameState, () -> {
                System.out.print("Command: ");
                return scannerTwo.nextLine();
            }, (message) -> {
                System.out.println(message);
            });
        }

        System.out.println("Goodbye.");
    }
}
