// Abstract superclass for all characters
abstract class Character {
    int health;
    int damage;
    int mana;
    int stamina;
    String name;

    // Constructor
    public Character(int health, int damage, int mana, int stamina, String name) {
        this.health = health;
        this.damage = damage;
        this.mana = mana;
        this.stamina = stamina;
        this.name = name;
    }

    // Attack method
    public void attack(Character target) {
        target.takeDamage(this.damage);
    }

    // Take damage method
    public void takeDamage(int damage) {
        this.health -= damage;
    }

    // Special attack method
    public abstract void specialAttack(Character target);
}

// Subclass for the mage character
class Mage extends Character {
    // Constructor
    public Mage(int health, int damage, int mana, int stamina, String name) {
        super(health, damage, mana, stamina, name);
    }

    // Special attack method
    public void specialAttack(Character target) {
        if (this.mana >= 50) {
            System.out.println(this.name + " casts Fireball!");
            target.takeDamage(this.damage * 2);
            this.mana -= 25;
        } else {
            System.out.println(this.name + " does not have enough mana to cast Fireball!");
        }
    }
}

// Subclass for the rogue character
class Rogue extends Character {
    // Constructor
    public Rogue(int health, int damage, int mana, int stamina, String name) {
        super(health, damage, mana, stamina, name);
    }

    // Special attack method
    public void specialAttack(Character target) {
        if (this.stamina >= 25) {
            System.out.println(this.name + " uses Fast Flurry!");
            target.takeDamage((int) Math.round(this.damage * 1.25));
            this.stamina -= 25;
        } else {
            System.out.println(this.name + " does not have enough stamina to use Fast Flurry!");
        }
    }

    // Override attack method to add speed
    public void attack(Character target) {
        if (this.stamina >= 30) {
            target.takeDamage(this.damage * 3);
            this.stamina -= 30;
        } else {
            System.out.println(this.name + " does not have enough stamina to use a triple attack!");
        }
    }
}

// Subclass for the warrior character
class Warrior extends Character {
    boolean canAttack = true;

    // Constructor
    public Warrior(int health, int damage, int mana, int stamina, String name) {
        super(health, damage, mana, stamina, name);
    }

    // Special attack method
    public void specialAttack(Character target) {
        if (this.stamina >= 50) {
            System.out.println(this.name + " performs Super Swing!");
            target.takeDamage(this.damage * 4);
            this.stamina -= 50;
        } else {
            System.out.println(this.name + " does not have enough stamina to perform Super Swing!");
        }
    }

    // Turn method
    public void turn() {
        this.canAttack = true;
    }
}
/*In this updated design, the Character class now has an additional attribute, stamina, which is used by the Rogue and
Warrior subclasses to execute their special attacks. The Rogue subclass now checks if they have enough stamina to use
their special attack, and if so, executes the appropriate damage calculation on the target and reduces their stamina
by 25. The overridden attack method of the Rogue subclass now costs 30 stamina to perform a triple attack.
The Warrior subclass now checks if they have enough stamina to perform their special attack, and if so, executes the
appropriate damage calculation on the target and reduces their stamina by 50.
 The use of stamina instead of mana for the Rogue and Warrior subclasses demonstrates the flexibility of inheritance
 and abstraction. By keeping the mana attribute in the Character superclass, we can still use it for the Mage subclass,
 while introducing a new attribute for the Rogue and Warrior subclasses that makes sense for those characters.
 Additionally, the use of an orange color to represent the stamina bar is simply a matter of updating the game's UI,
 and does not require any changes to the underlying code.
 Overall, this updated design further emphasizes the unique strengths and weaknesses of each character,
 and provides a more engaging gameplay experience by introducing a new resource that players must manage in order to use their special attacks.
 */
