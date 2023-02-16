// May be changed to a class depending on how we want to inherit into Player, Enemy, and Boss.
public interface Entity {

        void changeHP(int change);

       int[] calDamage();//Parameters deleted as they were not needed.
}
