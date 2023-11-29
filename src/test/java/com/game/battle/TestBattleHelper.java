package com.game.battle;

import com.game.character.Enemy;
import com.game.character.Hero;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.game.battle.BattleHelper.battleOutcome;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestBattleHelper {
    private Hero hero;
    private Enemy enemy;

    @BeforeEach
    void setUp() {
        hero = new Hero("Dancho");
        enemy = new Enemy();
    }

    @Test
    void testBattleOutcome () {
        int attackCount = enemy.getHealth()+hero.getHealth();
        for (int i = 0; i < attackCount; i++) {
            hero.attack(enemy, 3);
            enemy.attack(hero, 1);
            battleOutcome(hero,enemy);

            if(BattleHelper.cycleEnd) {
                break;
            }
        }
        assertTrue((enemy.getHealth()<=0)||(hero.getHealth()<=0), "Battle outcome method does not work properly as health levels are not correct");
    }
}
