package edu.cscc.javaadventure;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LanternTest {

    private Lantern lantern;

    @BeforeEach
    public void setUp() {
        lantern = new Lantern();

    }
    @Test
     void initializationWithDefaultValues() {
        assertEquals(1.50, lantern.getWeight());
        assertEquals(false, lantern.isLit());
        assertEquals(false, lantern.isBroken());
    }
    @Test
    void light() {
        lantern.light();

        assertEquals(true, lantern.isLit());
    }
    @Test
    void getDescription() {
        assertFalse(lantern.isLit(), "A tarnished, old lantern that has seen better days. " + lantern.getDescription());

    }

    @Test
   void extinguish(){
        lantern.extinguish();

        assertEquals(false, lantern.isLit());
    }

   @Test
   void getLitDescription() {


       if(lantern.isLit() == true ) {
           assertEquals( lantern.getLitDescription(),"It glows softly.");

       } else {
           assertEquals(lantern.getLitDescription(), "It is unlit.");
       }
   }
   @Test
   void getWeight() {
       assertEquals(1.50, lantern.getWeight());
   }
   @Test
    void isBroken() {
       assertEquals(false, lantern.isBroken());
    }
    @Test
    void fix() {
        lantern.fix();
        assertEquals(false, lantern.isBroken());
    }
    @Test
    void makeBroken() {
        lantern.makeBroken();
        assertEquals(true, lantern.isBroken());
    }

    }

