package com.game.demo;

import com.game.battle.BattleHelper;
import com.game.character.*;

import java.util.Random;

public class DemoFight {
    private static final int CRIT_THRESHOLD_ENEMY = 1;
    private static final int CRIT_THRESHOLD_HERO = 3;

    public static void main(String[] args) {

        Hero hero = new Hero("Arnold Schwarzenegger");
        Hero hero2 = new Hero();
        Hero heroStronger = (Hero) hero.compareCharacter(hero2);
        Enemy enemy2 = new Enemy();

        System.out.print("Hero is: ");
        heroStronger.displayCharacterStats();
        int heroWins = 0;
        int roundsToPlay = 5;

        int i = 0;
        while(i < roundsToPlay){
            Random r1 = new Random();
            int enemyLevelRand;
            int enemyHealthRand = (r1.nextInt(101)+100)*heroStronger.getLevel();
            int enemyStrengthRand = (r1.nextInt( 6)+3) + (int) (0.1 * heroStronger.getStrength());

            if(heroStronger.getLevel() != 1) {
                enemyLevelRand = r1.nextInt(heroStronger.getLevel()+1)+1;
            } else {
                enemyLevelRand = 1;
                }

            Enemy enemy = new Enemy(enemyHealthRand,enemyStrengthRand, enemyLevelRand);
            Enemy enemyStronger = (Enemy) enemy.compareCharacter(enemy2);

            System.out.println("\n\n");
            heroStronger.displayCharacterStats();
            enemyStronger.displayCharacterStats();

            int enemyStats = enemyStronger.getHealth() + enemyStronger.getStrength();
            int heroStats = 130 * heroStronger.getLevel();

            if(enemyStats > heroStats){
                heroStronger.avoid();
            } else {
                int attackCount = enemyStronger.getHealth()+heroStronger.getHealth(); // от колко атаки максимум ще се състои рунда
                System.out.println("attack count " + attackCount);
                boolean coinHeadsTails = r1.nextBoolean(); // false - ези, true - тура

                String attackMassage = (coinHeadsTails ? "Hero attacks first" : "Enemy attacks first");
                System.out.println(attackMassage);

                for (int j = 0; j < attackCount; j++) {
                    if(!coinHeadsTails) {
                        heroStronger.attack(enemyStronger, CRIT_THRESHOLD_HERO);
                        enemyStronger.attack(heroStronger, CRIT_THRESHOLD_ENEMY);
                    } else {
                        enemyStronger.attack(heroStronger, CRIT_THRESHOLD_ENEMY);
                        heroStronger.attack(enemyStronger, CRIT_THRESHOLD_HERO);
                    }
                    BattleHelper.battleOutcome(heroStronger, enemyStronger);

                    if(BattleHelper.cycleEnd) {
                        heroWins = heroWins + 1;
                        i++;
                        break;
                    }
                }
            }
        }

        if(heroWins >= roundsToPlay) {
            System.out.println("\nYour hero won!");
            heroStronger.displayCharacterStats();
        } else {
            System.out.println("\nYour hero lost!");
        }
    }
}