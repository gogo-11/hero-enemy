package com.game.character;

import java.util.Random;

public abstract class Character {
    protected int health;
    protected int strength;
    protected int level;

    protected Character() {
    }

    protected Character(int health, int strength, int level) {
        this.health = health;
        this.strength = strength;
        this.level = level;
    }

    public void attack(Character opponent, int criticalThreshold) {
        Random rand1 = new Random();
        int criticalAttack = rand1.nextInt(11)+1;

        if(criticalAttack <= criticalThreshold){
            opponent.setHealth(opponent.getHealth()-(strength+3)); //критичен удар
        } else {
            opponent.setHealth(opponent.getHealth()-strength);
        }
    }

    public Character compareCharacter (Character character) {
        if(this.getStrength() > character.getStrength()){
            return this;
        } else if (this.getStrength() < character.getStrength()) {
            return character;
        } else {
            if(this.getHealth() > character.getHealth()) {
                return this;
            } else if (this.getHealth() < character.getHealth()) {
                return character;
            } else {
                return this;
            }
        }
    }

    public void displayCharacterStats() {
        System.out.println("HP: " +  health + ", strength: " + strength + ", at level " + level);
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getStrength() {
        return strength;
    }

    public int getLevel() {
        return level;
    }
}
