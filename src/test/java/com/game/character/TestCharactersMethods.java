package com.game.character;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class TestCharactersMethods {
    private Hero hero;
    private Enemy enemy;

    @BeforeEach
    void setUp() {
        hero = new Hero("Dancho");
        enemy = new Enemy();
    }

    @Test
    @DisplayName("Correct hero strength generating check")
    void heroStrengthCheck() {
        int minStrength = 5;
        int maxStrength = 10;
        int heroStrength = hero.heroStrength();
        assertTrue( (minStrength < heroStrength) || (maxStrength > heroStrength), "некоректна стойност");
    }

    @Test
    void testAvoidMethod() {
        int heroExperienceBefore = hero.getExperience();
        hero.setHealth(hero.getHealth()-20);
        hero.avoid();
        assertTrue(hero.getExperience() == heroExperienceBefore-10,"пропускането на враг не функционира правилно");
        assertTrue(hero.getHealth() == (hero.getLevel() * Hero.MAX_HEALTH_BASE),"пропускането на враг не функционира правилно");
    }

    @Test
    void enemyAttackMethodCheck() {
        int heroHealthPoints = hero.getHealth();
        enemy.attack(hero);
        assertTrue(hero.getHealth() < heroHealthPoints, "атаката на врага не функционира правилно");
    }
}

