package edu.cscc.javaadventure;

import java.util.ArrayList;
import java.util.List;

public class Backpack {
    private String name;
    private String description;
    private List<JAObject> contents;
    private double weight;


    public Backpack(String name, String description, List<JAObject> contents, double weight) {
        this.name = name;
        this.description = description;
        this.contents = contents;
        this.weight = weight;
    }

    public boolean addObject(JAObject object) {
        contents.add(object);
        return true;
    }


    public JAObject removeObject() {
        for (JAObject jaObject : contents) {
            if (name.equals(jaObject.getName())) {
                contents.remove(jaObject);
                return jaObject;
            }
        }
        return null;
    }

    public List<JAObject> getContents() {
        List<JAObject> contents = new ArrayList<JAObject>();
        contents.addAll(contents);
        return contents;
    }

    public double getWeight() {
        double totalWeight = this.weight;
        for (JAObject jaObject : contents) {
            totalWeight += jaObject.getWeight();
        }
        return totalWeight;
    }


}


