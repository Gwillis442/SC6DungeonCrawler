public class EntityDecorator implements Entity{
    int HP;
    int[] entDamRange = new int[2];
    int spriteNum;//Just a placeholder for now as we do not yet know assigning sprites to entities will work.

    @Override
    public void changeHP(int change) {
        HP = HP + change;
        /*
        if(HP < 0){
            HP = 0;
        }
        */

    }

    @Override
    public int[] calDamage() { //Contents may be moved to Enemy.java and Boss.java
        int[] endDam = new int[1];
        endDam[0] = Main.ranCal(entDamRange[0],entDamRange[1]);
        return(endDam);
    }


}
