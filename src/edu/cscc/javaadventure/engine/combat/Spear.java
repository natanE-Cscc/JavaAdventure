package edu.cscc.javaadventure.engine.combat;

import edu.cscc.javaadventure.JAObject;
import edu.cscc.javaadventure.Weapon;

public class Spear extends JAObject implements Weapon {
    private boolean twoHanded;
    private int damage;



    public Spear() {
        super.name = "A crude spear";
        super.description= "It’s a pointy stick";
        this.damage = 3;
        this.twoHanded = false;


    }

    @Override
    protected void setupDescriptionModifiers() {
        // do nothing
    }

    @Override
    public Integer getDamage() {
        return this.damage;
    }

    @Override
    public Boolean getTwoHanded() {
        return this.twoHanded;
    }

    @Override
    public String getDescription() {
        return super.getDescription();
    }


}