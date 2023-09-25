package com.game.character;

import java.util.Random;

public class Hero  {
    public static final int MAX_HEALTH_BASE = 100;
    public static final int ENERGY_OVERFLOW = 20;
    public static final int HEALTH_INCREASE = 50;
    public static final int VICTORY_EXPERIENCE_BONUS = 50;

    private String name;
    private int health;
    private int strength;
    private int experience;
	private int level;

    public Hero() {
        this.name = "Default name";
        this.health = MAX_HEALTH_BASE;
        this.strength = 7;
        this.experience = 0; //начални точки опит
        this.level = 1;
    }
    public Hero(String name) {
        this.name = name;
        this.health = MAX_HEALTH_BASE;
        this.strength = heroStrength();
        this.experience = 0; //начални точки опит
        this.level = 1;
    }

	public void attack(Enemy enemy) {
        Random rand1 = new Random();
        int criticalAttack = rand1.nextInt(11)+1;

        if (criticalAttack <= 3){
            enemy.setHealth(enemy.getHealth()-(this.strength+3)); //критичен удар
        } else {
            enemy.setHealth(enemy.getHealth()-this.strength);
        }
    }

    public void avoid() {
        System.out.println("\nEnemy avoided!");
        experience = experience - 10;
        int healthIncreaseCheck = MAX_HEALTH_BASE * level - 50;

        if (health > healthIncreaseCheck){
            health = MAX_HEALTH_BASE * level;
        } else {
            health = level + HEALTH_INCREASE;
        }
    }

    public void restoreHealthAfterWin(Enemy enemy) {
        Random r1 = new Random();
        int boostHP = r1.nextInt(10)+1;

        if (boostHP <= 3) {
            health = (level * MAX_HEALTH_BASE) + ENERGY_OVERFLOW;
        } else {
            health = level * MAX_HEALTH_BASE;
        }
        experience += enemy.getLevel() * VICTORY_EXPERIENCE_BONUS;
    }

    public void levelUp(){
        Random r1 = new Random();
        int strengthLevelU = r1.nextInt(3)+3;

        if(experience >= level* MAX_HEALTH_BASE) {
            health = health + (HEALTH_INCREASE * level);
            strength = strength + (strengthLevelU * level);
            level = level + 1;
            experience = 0;
        }
    }

    public Hero compareHero (Hero hero2) {
        if(this.getStrength() > hero2.getStrength()){
            return this;
        } else if (this.getStrength() < this.getStrength()) {
            return hero2;
        } else {
            if(this.getHealth() > hero2.getHealth()) {
                return this;
            } else if (this.getHealth() < hero2.getHealth()) {
                return hero2;
            } else {
                return this;
            }
        }
    }

    public void displayHeroStats() {
        System.out.println(name + ", HP: " +  health + ", strength: " + strength + ", experience " + experience + ", at level " + level);
    }

    public int heroStrength() {
        Random r1 = new Random();
        int heroStrength = r1.nextInt(5)+5;
        return heroStrength;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getStrength() {
        return strength;
    }

    public int getExperience() {
        return experience;
    }

    public int getLevel() {
        return level;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
