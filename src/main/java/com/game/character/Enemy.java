package com.game.character;

import java.util.Random;

public class Enemy{

    private int health;
    private int strength;
    private int level;

    public Enemy() {
        this.health = 150;
        this.strength = 4;
        this.level = 1;
    }
    public Enemy (int health, int strength, int level){
        this.health = health;
        this.strength = strength;
        this.level = level;
    }

    public void attack(Hero hero) {
        Random rand1 = new Random();
        int criticalAttack = rand1.nextInt(11)+1;

        if(criticalAttack == 1){
            hero.setHealth(hero.getHealth()-(strength+3)); //критичен удар
        } else {
            hero.setHealth(hero.getHealth()-strength);
        }
    }

    public Enemy compareEnemy (Enemy enemy2) {
        if(this.getStrength() > enemy2.getStrength()){
            return this;
        } else if (this.getStrength() < this.getStrength()) {
            return enemy2;
        } else {
            if(this.getHealth() > enemy2.getHealth()) {
                return this;
            } else if (this.getHealth() < enemy2.getHealth()) {
                return enemy2;
            } else {
                return this;
            }
        }
    }
    public void displayEnemyStats() {
        System.out.println("Enemy, HP: " +  health + ", strength: " + strength + ", at level " + level);
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
