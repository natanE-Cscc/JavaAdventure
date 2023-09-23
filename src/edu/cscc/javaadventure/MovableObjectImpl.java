package edu.cscc.javaadventure;

public class MovableObjectImpl extends MovableObject {
    public MovableObjectImpl() {
    }

    @Override
    protected void setupDescriptionModifiers() {
        //Not used

    }

    public MovableObjectImpl(String name, String description, Double weight) {
        super(name, description, weight);
    }
}
