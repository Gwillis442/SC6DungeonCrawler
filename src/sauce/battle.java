/*
Sprites: These are very low priority. If anyone comes across some "Slash" or "Magic strike"
image or sprite, try to save it as we may use it in animations.
 */

import java.util.TimerTask;

public class battle {


    static entEnemy opponent = dungeon.lvl0E; //sets opponent to a level 0 enemy
    private static controllerBattle battleControl;

    static int damTaken = 0;
    public static  int turnCount = 0;

    static boolean doTurn = true;

    public static void setApp(controllerBattle battleControl){
        /*This method sets the app variable to appDungGame application so the window can be changed.
        And sets invControl to the inventoryScreen.fxml controller, so it can be altered from this controller.*/

        battle.battleControl = battleControl;
    }

static TimerTask emAtkTask;
    public static void enemyAttack() {
        int[] damArray = opponent.calDamage();
        System.out.println(doTurn);

        emAtkTask = new TimerTask() {
            @Override
            public void run() {
                Main.character.changeHP(-damArray[0]);
                damTaken = (int)(damArray[0]/(Main.character.eqItemArmor.armorPT*0.1));

                battleControl.updateBattleText(2, "Enemy", damTaken);
                //System.out.println("Health: " + Main.character.playHP);
                battleControl.updateText();
                battleControl.updatePlayerBars();
                doTurn = true;
                if (Main.character.playHP == 0) {
                    endBattle();
                }
                Main.timer.purge();
            }
        };
        Main.timeDelay(emAtkTask, 1000);


    }

    public static void playerAttack(){


        if(doTurn) { //doTurn check is to stop being able to spam buttons over and over
            doTurn = false;
            turnCount += 1;
            battleControl.updateBattleText(7, turnCount);

            int[] damArray = Main.character.calDamage();

            for (int n = 0; n < damArray.length; n++) {
                opponent.changeHP(-damArray[n]); //Needs to update health observer/ health bar
                battleControl.updateBattleText(1, damArray[n]);
                battleControl.updatePlayerBars();
                //System.out.println("play loop");
            }

            //System.out.println("Enemy Health: " + opponent.HP);

            if (opponent.HP == 0) {
                endBattle();
            } else {
                enemyAttack();
            }
        }
        battleControl.updateEnemyBars();
        battleControl.updateText();
    }

    public static void playerSpecialAttack(){
        if(doTurn == true) { //doTurn check is to stop being able to spam buttons over and over
            doTurn = false;
            turnCount += 1;
            battleControl.updateBattleText(7, turnCount);


            int[] damArray = Main.character.calSpecialDamage();

            for (int n = 0; n < damArray.length; n++) {

                opponent.changeHP(-damArray[n]); //Needs to update health observer/ health bar
                battleControl.updateBattleText(1, damArray[n]);
                battleControl.updatePlayerBars();
            }

            //System.out.println("Enemy Health: " + opponent.HP);

            if (opponent.HP == 0) {
                endBattle();
            } else {
                enemyAttack();
            }
        }
        battleControl.updateEnemyBars();
        battleControl.updateText();
    }



    public static void endBattle() {
        turnCount = 0;
        doTurn = true;
        Main.character.playMP = 100;
    if(Main.character.playHP == 0){
        System.out.println("You died.");
        opponent.HP = opponent.maxHP;
        battleControl.endBattle();
        }else if(opponent.HP == 0){
        System.out.println("Enemy died.");

        opponent.addLoot();

        battleControl.endBattle();
        }else {
        System.out.println("Error endBattle() was incorrectly called.");

    }


    }
}
