package com.game.battle;

import com.game.character.Enemy;
import com.game.character.Hero;

public class BattleHelper {
    public static boolean cycleEnd = false;

    public static boolean battleOutcome(Hero heroStronger, Enemy enemyStronger) {
        cycleEnd = false;
        if(heroStronger.getHealth() <= 0){
            System.out.println("Your hero died! :(\n GAME OVER...");
            System.exit(-1);
        } else if(enemyStronger.getHealth() <= 0) {
            System.out.println("\nYou won against the enemy ");
            heroStronger.restoreHealthAfterWin(enemyStronger);
            heroStronger.levelUp();
            cycleEnd = true;
        }
        return cycleEnd;
    }
}
