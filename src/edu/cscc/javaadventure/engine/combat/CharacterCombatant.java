package edu.cscc.javaadventure.engine.combat;

import edu.cscc.javaadventure.Character;
import edu.cscc.javaadventure.Sword;
import edu.cscc.javaadventure.Weapon;
import edu.cscc.javaadventure.engine.InvalidRollException;

public class CharacterCombatant implements Combatant{
    private Character character;
    private Weapon currentWeapon;
    private Combatant combatant;
    private int initiative;
    private int baseArmorClassBonus;


    public CharacterCombatant (Character character) {
        this.character= character;
        this.currentWeapon= new Sword();
        this.baseArmorClassBonus = 10;
    }

    public void setInitiative(int initiative) {
        this.initiative = initiative;
    }

    @Override
    public void receiveDamage(int damage) {

        character.setHealth(character.getHealth() - damage);
        //int damageReceived = combatant.getHealth() - damage;
    }

    @Override
    public boolean isActiveCombatant() {
        return character.getHealth() > 0;
    }

    @Override
    public String getName() {
        return this.character.getName();
    }

    @Override
    public Weapon getWeapon() {
        return currentWeapon;
    }

    @Override
    public int getInitiative() {
        return this.combatant.getInitiative();
    }

    @Override
    public Integer getArmorClass() {
        return this.baseArmorClassBonus + calculateDexterityBonus();
    }

    @Override
    public Integer getHealth() {
        return this.combatant.getHealth();
    }


    @Override
    public void equipWeapon(Weapon weapon) {
        try {
            if(weapon != null) {
                if(weapon.getTwoHanded() && getStrength() < 15) {
                    throw new UnableToWieldWeaponException("Character does not have enough weapon");
                }
                currentWeapon = weapon;
            }
        } catch (UnableToWieldWeaponException e) {
            System.err.println("Unable to equip weapon: " + e.getMessage());
        }
    }


    @Override
    public String attack(int roll, Combatant target) {
        try {
            if (roll < 1 || roll > 20) {
                throw new InvalidRollException("Invalid roll");
            }
            if (!isActiveCombatant()) {
                throw new IllegalStateException("Defeated  could not attack");
            }
            if (!target.isActiveCombatant()) {
                throw new OpponentIncapacitatedException("Target combatant is not active ");
            }

            int dexterityBonus = calculateDexterityBonus();
            int armorClass = target.getArmorClass();
            int totalAttackRoll = roll + dexterityBonus;

            if (totalAttackRoll >= armorClass) {
                int damage = calculateDamage();
                target.receiveDamage(damage);
                return character.getName() + "attacks " + target.getName() + "with" + currentWeapon.getName() + "and deals" + currentWeapon.getDamage();
            } else {
                return character.getName() + "attack " + target.getName() + "with" + currentWeapon.getName() + "and misses!";
            }
        } catch (InvalidRollException e) {
            System.err.println("Invalid roll :" + e.getMessage());
            return "Invalid roll";
        } catch (IllegalStateException e) {
            System.err.println("Illegal state: " + e.getMessage());
            return "cannot attack while defeated ";

        }catch(OpponentIncapacitatedException e) {
            System.err.println("Opponent incapacitated " + e.getMessage());
            return "Target combatant is not active ";
        }

    }

    @Override
    public void calculateInitiative(int roll) throws InvalidRollException {
        if(roll < 1 || roll >10 ) {
            throw new InvalidRollException("Invalid roll range");
        }
        if(getInitiative()<1 ) {
            this.initiative =1;
        } else {
            this.initiative = roll;

        }

    }


    public int getStrength() {
        return 0;
    }

    public int calculateDexterityBonus() {
        int dexterityBonus = 0;
        if(character.getDexterity() >= 15 && character.getDexterity() <= 18) {
            dexterityBonus = character.getDexterity() - 14;
        }
        return dexterityBonus;
    }

    public int calculateDamage() {
        int weaponDamage = currentWeapon.getDamage();
        int strengthBonus = calculateStrengthBonus();
        return weaponDamage + strengthBonus;
    }

    public int calculateStrengthBonus() {
        int strength = getStrength();
        int strengthBonus = 0;
        if(strength >= 15 && strength <= 18) {
            strengthBonus = strength -14;

        }
        return strengthBonus;
    }


    @Override
    public int compareTo(Combatant combatant) {
        return 0;
    }
}

