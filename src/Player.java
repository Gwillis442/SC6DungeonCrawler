/*
Sprites: At least one small sprite for each player class.(Mage, Rogue, and Warrior)
 */
public class Player implements Entity{

    int playHP;
    int playMP = 100;
    int armorPT;
    Weapon eqWeapon;
    Armor eqArmor;//For now, there will only be one equipable armor piece. Rather than a "Helmet","Gauntlet","Shield" etc...
    String playClass = "default";//Other Player classes are yet to be created. So this is just a placeholder.
    int spriteNum;//Just a placeholder for now as we do not yet know assigning sprites to entities will work.

    @Override
    public void changeHP(int change) {

        double bla = change/(0.2*armorPT);
        playHP = playHP + (int)(bla);
    }

    @Override
    public int[] calDamage() {

        if (eqWeapon.weaponType == "sword"){
            return calSwordAtk();
        } else if (eqWeapon.weaponType == "daggers") {
            return calDaggerAtk();
        } else if (eqWeapon.weaponType == "staff") {
            return calMagicAtk();
        }else {
            int[] errorArray = new int[1];
            errorArray[0] = 555;
            return errorArray;
        }

    }
    //---------------------Equip Items Methods--------------------
    public void equipArmor(Armor N){
        eqArmor = N;
    }
    public void equipWeapon(Weapon N){
        eqWeapon = N;
    }
    //--------------------Determine attack strength Methods--------------------
    public int[] calSwordAtk(){
        int[] endDam = new int[1];
        endDam[0] = eqWeapon.calItemDamage();
        return endDam;
    }
    public int[] calDaggerAtk(){
        int[] endDam = new int[2];
        endDam[0] = eqWeapon.calItemDamage();
        endDam[1] = eqWeapon.calItemDamage();
        return endDam;
    }
    public int[] calMagicAtk(){//If player MP is not sufficient, attack damage will be reduced to 40%.
        int[] endDam = new int[1];
        if (playMP >= 10){
            endDam[0] = eqWeapon.calItemDamage();
            playMP = playMP - 10;
        } else  {
            endDam[0] = (int)((eqWeapon.calItemDamage())*0.4);
        }
        return endDam;
    }
    //--------------------X--------------------



}
