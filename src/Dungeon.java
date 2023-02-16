public class Dungeon {
    //This whole class may be deleted depending on how Java FX is going to be built.



    //The following code may be moved to a new class or deleted.
    //All values in the "create" methods will be changed in accordance to balancing
    public void createWeapons(Player player){
        if (player.playClass == "mage"){
            Weapon lvl0W = new Weapon(20,30,"staff");
            Weapon lvl1W = new Weapon(30,40,"staff");
            Weapon lvl2W = new Weapon(40,50,"staff");
            Weapon lvl3W = new Weapon(50,60,"staff");
            Weapon lvl4W = new Weapon(60,70,"staff");
        } else if (player.playClass == "warrior"){
            Weapon lvl0W = new Weapon(10,20,"sword");
            Weapon lvl1W = new Weapon(20,30,"sword");
            Weapon lvl2W = new Weapon(30,40,"sword");
            Weapon lvl3W = new Weapon(40,50,"sword");
            Weapon lvl4W = new Weapon(50,60,"sword");
        }else if (player.playClass == "rogue"){
            Weapon lvl0W = new Weapon(5,10,"daggers");
            Weapon lvl1W = new Weapon(10,15,"daggers");
            Weapon lvl2W = new Weapon(15,20,"daggers");
            Weapon lvl3W = new Weapon(20,25,"daggers");
            Weapon lvl4W = new Weapon(25,30,"daggers");
        }else {
            System.out.println("playClass not set to correct value.");
        }
    }

    public void createArmor(Player player){
        if (player.playClass == "mage"){
            Armor lvl0A = new Armor(25, "robe");
            Armor lvl1A = new Armor(35, "robe");
            Armor lvl2A = new Armor(45, "robe");
            Armor lvl3A = new Armor(55, "robe");
            Armor lvl4A = new Armor(65, "robe");
        } else if (player.playClass == "warrior"){
            Armor lvl0A = new Armor(50, "light");
            Armor lvl1A = new Armor(60, "light");
            Armor lvl2A = new Armor(70, "light");
            Armor lvl3A = new Armor(80, "light");
            Armor lvl4A = new Armor(90, "light");
        }else if (player.playClass == "rogue"){
            Armor lvl0A = new Armor(80, "heavy");
            Armor lvl1A = new Armor(90, "heavy");
            Armor lvl2A = new Armor(100, "heavy");
            Armor lvl3A = new Armor(110, "heavy");
            Armor lvl4A = new Armor(120, "heavy");
        }else {
            System.out.println("playClass not set to correct value.");
        }
    }

    public void createEnemies(){
        Enemy lvl0E = new Enemy(200,10,30);
        Enemy lvl1E = new Enemy(300,20,30);
        Enemy lvl2E = new Enemy(400,30,40);
        Enemy lvl3E = new Enemy(500,40,50);
        Enemy lvl4E = new Enemy(600,50,60);
    }

    public void createBoss(){
        Boss badMan = new Boss(1000, 100, 200);
    }

}
