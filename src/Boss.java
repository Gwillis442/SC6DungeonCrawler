/*
Sprites: At least one Smallish sprite that looks like a dungeon boss. (It doesn't
actually matter what it looks like just make sure it's slightly bigger than regular enemies.)
 */
public class Boss extends EntityDecorator {
    //May be deleted based on how Enemy.java ends up.

    public Boss (int health, int damMin, int damMax){
        this.HP = health;
        this.entDamRange[0] = damMin;
        this.entDamRange[1] = damMax;
    }

    @Override
    public int[] calDamage() {
        int[] endDam = new int[1];
        endDam[0] = Main.ranCal(entDamRange[0],entDamRange[1]);
        return(endDam);
    }}
