package edu.cscc.javaadventure;

public class Main {
    public static void main(String[] args) {
        System.out.println("The adventure begins!");

        Character character = new Character();
        character.setName("Gandalf");
        character.setDescription("The Gray Wizard");
        character.setHealth(100);

        String name = character.getName();
        String description = character.getDescription();
        Integer health = character.getHealth();

        System.out.println(name);
        System.out.println(description);
        System.out.println(health);



    }
}
