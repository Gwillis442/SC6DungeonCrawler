/*
Sprites: These are very low priority. If anyone comes across some "Slash" or "Magic strike"
image or sprite, try to save it as we may use it in animations.
 */
public class Battle {

    Enemy opponent;

    public void battleStart( int enemyDam){
        boolean fight = true;

        while(fight) {
            playerAttack(); //This needs to assigned to a button in javafx
            //methods are called for testing

            if(Main.character.playHP == 0 && opponent.HP == 0){
                fight = endBattle();
            }

            enemyAttack();

            if(Main.character.playHP == 0 && opponent.HP == 0){
                fight = endBattle();
            }


        }
    }

    public void enemyAttack(){
        int[] damArray = opponent.calDamage();
        Main.character.changeHP(damArray[0]);

    }

    public void playerAttack(){
        int[] damArray = Main.character.calDamage();

        for(int n = 0; n != damArray.length; n++ ){
            opponent.changeHP(damArray[n]); //Needs to update health observer/ health bar
        }

    }

    public boolean endBattle() {
    if(Main.character.playHP == 0){
        return false;
        }else if(opponent.HP == 0){
        return false;
        }else {
        System.out.println("Error endBattle() was incorrectly called.");
        return false;
    }

    }
}
