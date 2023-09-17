package edu.cscc.javaadventure;

import java.util.HashMap;
import java.util.Set;

public class Room {
    private String name;
    private String description;

    private HashMap<String, Room> rooms = new HashMap<>();
    private HashMap<String, JAObject> contents = new HashMap<>();
    private JAObject jaObject;

    public Room(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public Object connectRoom(String direction, Room targetRoom) {
        if (direction.equals("NORTH") && targetRoom.equals("SOUTH")
                || direction.equals("EAST") && targetRoom.equals("WEST")
                || direction.equals("UP") && targetRoom.equals("DOWN")
                || direction.equals("SOUTH") && targetRoom.equals("NORTH")


        ) {
            rooms.put(direction, targetRoom);
    } else {
            System.out.println();
        }
        return null;
    }

    public void disconnectRoom(String direction) {
        switch (direction) {
            case "NORTH":
                rooms.remove("SOUTH");
                System.out.println("SOUTH direction removed");
                break;
            case "EAST":
                rooms.remove("WEST");
                System.out.println("WEST removed");
                break;
            case "UP":
                rooms.remove("DOWN");
                System.out.println("DOWN removed");
                break;
            case "SOUTH":
                rooms.remove("NORTH");
                System.out.println("NORTH removed");
                break;
            case "WEST":
                rooms.remove("EAST");
                System.out.println("EAST removed");
                break;
            case "DOWN":
                rooms.remove("UP");
                System.out.println("UP removed");
                break;
        }
    }

    public Room getRoom(String direction){
        return rooms.get(direction);
    }

    public void addToContents(JAObject jaObject) {
        contents.put(jaObject.getName(), jaObject);
    }

    public JAObject removeFromContents(String name) {
        return contents.remove(name);
    }

    public Set<String> listContents() {
        for(String content: contents.keySet()) {
            System.out.println("set of contents: " + content);
        }
        return null;
    }


    @Override
    public String toString() {
        return "Room{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", rooms=" + rooms +
                ", contents=" + contents +
                ", jaObject=" + jaObject +
                '}';
    }


}
