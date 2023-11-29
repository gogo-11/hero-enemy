package com.game.character;

public class Enemy extends Character{

    public Enemy() {
        this.health = 150;
        this.strength = 4;
        this.level = 1;
    }
    public Enemy (int health, int strength, int level){
        super(health, strength, level);
    }

    @Override
    public void displayCharacterStats() {
        System.out.print("Enemy, ");
        super.displayCharacterStats();
    }

    public int getHealth() {
        return health;
    }

    public int getStrength() {
        return strength;
    }

    public int getLevel() {
        return level;
    }

    public void setHealth(int health) {
        this.health = health;
    }
}
