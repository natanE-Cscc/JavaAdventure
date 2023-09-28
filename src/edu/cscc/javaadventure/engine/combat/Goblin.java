package edu.cscc.javaadventure.engine.combat;
import edu.cscc.javaadventure.MovableObject;
import edu.cscc.javaadventure.Weapon;
import edu.cscc.javaadventure.engine.InvalidRollException;
import edu.cscc.javaadventure.engine.combat.Combatant;
import edu.cscc.javaadventure.engine.combat.OpponentIncapacitatedException;
import edu.cscc.javaadventure.engine.combat.Spear;
import edu.cscc.javaadventure.engine.combat.UnableToWieldWeaponException;

public class Goblin extends MovableObject implements Combatant {
    private int initiative;
    private int armorClass;
    private int health = 10;
    private Weapon weapon;
    private int damage;
    private Spear spear = new Spear();


    public Goblin() {
        super("Goblin", "A green-skinned humanoid with an evil gleam in their eyes ", null);
        initiative = 1;
        armorClass = 8;
        damage = 3;



    }

    @Override
    protected void setupDescriptionModifiers() {

    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Integer getHealth() {
        return this.health;
    }

    @Override
    public int getInitiative() {
        return this.initiative;
    }

    @Override
    public void calculateInitiative(int roll) throws InvalidRollException {
        if (roll < 1 || roll > 10) {
            throw new InvalidRollException("Invalid roll value");

        }
        initiative = Math.max(1, roll);
    }

    @Override
    public Integer getArmorClass() {
        return armorClass;
    }

    @Override
    public void receiveDamage(int damage) {
        if (damage < 0) {
            throw new IllegalArgumentException("Damage cannot be less than zero");
        }
        health -= damage;
        if (health < 0) {
            health = 0;
        }
    }

    @Override
    public boolean isActiveCombatant() {
        return health > 0;
    }

    @Override
    public String attack(int roll, Combatant target) throws OpponentIncapacitatedException, InvalidRollException {
        if (roll < 1 || roll > 20) {
            throw new InvalidRollException ("Invalid roll is not in the given limit");
        }
        if (!isActiveCombatant()) {
            throw new IllegalStateException("Cannot attack while defeated");
        }
        if (!target.isActiveCombatant()) {
            throw new OpponentIncapacitatedException(" Target combatant is not active");
        }

        int armorClass = target.getArmorClass();
        //int totalAttackRoll = roll;

        if (roll >= armorClass) {
            target.receiveDamage(damage);
            return this.getName() + "attacks " + target.getName() + " and deals " + damage + " points of damage.";
        } else {
            return this.getName() + " attacks " + target.getName() + "with " + this.getWeapon().getName() + "and misses!";
        }
    }

    @Override
    public void equipWeapon(Weapon weapon) throws UnableToWieldWeaponException {
        if(!this.getWeapon().equals(spear)) {
            throw new UnableToWieldWeaponException("Goblins cannot use other weapon");
        }
    }
    @Override
    public Weapon getWeapon() {
        return this.spear;

    }
    @Override
    public int compareTo(Combatant combatant)  {
        return 0;
    }
}






