package edu.cscc.javaadventure;

/**
 * Represents a lantern in a role-playing game.
 * The lantern can be lit or extinguished, broken or fixed.
 * It also has a weight and a description.
 */
public class Lantern {
    private boolean lit;
    private double weight;
    private boolean broken;

    /**
     * Constructs the lantern.
     * By default the lantern is unlit, unbroken, and has a weight of 1.50.
     */
    public Lantern() {
        weight = 1.50;
    }

    /**
     * Indicates of the lantern is lit or not.
     * @return true if lit, false otherwise.
     */
    public boolean isLit() {
        return lit;
    }

    /**
     * Lights the lantern.
     */
    public void light() {
        this.lit = true;
    }

    /**
     * Extinguishes the lantern.
     */
    public void extinguish() {
        this.lit = false;
    }

    /**
     * Get the description of the lantern. Indicates of the lantern is lit or not.
     * @return The lantern description depending on if it is lit or not.
     */
    public String getDescription() {
        return "A tarnished, old lantern that has seen better days. " + getLitDescription();
    }

    public String getLitDescription() {
        return !lit ? "It is unlit." : "It glows softly.";
    }

    /**
     * Gets the lantern's weight.
     * @return The weight of the lantern to a precision of 2 decimal places.
     */
    public double getWeight() {
        return weight;
    }

    /**
     * Indicates of the lantern is broken or not.
     * @return true if the lantern is broken, false otherwise.
     */
    public boolean isBroken() {
        return broken;
    }

    /**
     * Repairs the lantern.
     */
    public void fix() {
        this.broken = false;
    }

    /**
     * Breaks the lantern.
     * NOTE: "break" is a keyword in Java, so we can't call this method "break".
     */
    public void makeBroken() {
        this.broken = true;
    }
}
