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

        Character gandalf = party.findMember(wizard.getName());
        System.out.println("Found: " + gandalf.getName());
        party.removeMember(gandalf.getName());

        System.out.println("Party size: " + party.size());


        List<JAObject> contents = new ArrayList<JAObject>();
        System.out.println("Party size: " + party.size());
        for (Character character : members) {
            System.out.println(character.getName());
        }


//        JAObject jaObject = new JAObject("princess", "descriptions", 10.06);
//        HashSet<JAObject> contentsT = new HashSet<>();
//        contentsT.add(new JAObject("princess", "descriptions", 10.06));
//        contentsT.add(new JAObject("King", "descriptions2", 30.35));
//        contentsT.add(new JAObject("Rocky", "descriptions43", 60.60));
//        Iterator<JAObject> iterator = contentsT.iterator();
//        while (iterator.hasNext()) {
//            System.out.println(iterator.next().getName());
//        }
////
//       TreasureChest treasureChest = new TreasureChest("Lead");
//
//        treasureChest.addObject("Lead" );
////
//        HashSet<JAObject> contentsT = new HashSet<>();
//
//
//        JAObject jaObject1 = new JAObject("princess", "descriptions", 10.06);
//        JAObject jaObject2 = new JAObject("Manchester", "descriptions", 10.06);
//        JAObject jaObject3= new JAObject("Arsenal", "descriptions", 10.06);
//        JAObject jaObject4 = new JAObject("Barca", "descriptions", 10.06);
//        contentsT.add(jaObject1);
//        contentsT.add(jaObject2);
//        contentsT.add(jaObject3);
//        contentsT.add(jaObject4);
//        treasureChest.addObject(jaObject1);
//        treasureChest.addObject(jaObject2);
//        treasureChest.addObject(jaObject3);
//        treasureChest.addObject(jaObject4);

     //   System.out.println("this of the value of boolean result " + result);



//        JAObject testRemove = treasureChest.removeObject("princess");
//        Iterator<JAObject> iterator1 = contentsT.iterator();
//        while (iterator1.hasNext()) {
//            System.out.println(iterator1.next().getName());
//        }

//        List<JAObject> contents = new ArrayList<JAObject>();
//        contents.add(jaObject1);
//        contents.add(jaObject2);
//        contents.add(jaObject3);
//        contents.add(jaObject4);
////        for (Character character : members) {
////            System.out.println(character.getName());
////        }
//        Backpack backpack = new Backpack("stringtest", "StringForedes" ,contents, 34.23 );
//        System.out.println(backpack.removeObject("stringtest"));
    }
}
