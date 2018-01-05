package Model;

/**
 * Model.Monster Abstract Class
 *
 * @author Jai Aggarwal
 */

public abstract class Monster {

    public int exp = 0;

    public int expNeeded = 10;

    public int level = 1;

    private int health;

    private int maxHealth;

    int x = 3;

    int y = 10;

    private String name;

    private String originalName;

    private int damageRange;

    private int damageBase;

    private boolean alive = true;

    private int expWorth = 12;

    void attack(Monster opponent) {
        int damage = (int) (Math.random() * (damageRange)) + damageBase;
        opponent.takeDamage(damage);
        System.out.println(opponent.getName() + " took " + damage + " damage!");
        if (opponent.getHealth() <= 0) {
            System.out.println(opponent.getName() + " has fainted!");
            opponent.setAlive(false);
        }
    }

    void move(String dir){
        switch(dir) {
            case "up":
                y += 1;
                break;
            case "down":
                y -= 1;
                break;
            case "left":
                x -= 1;
                break;
            case "right":
                x += 1;
        }
        }

    void levelUp(int expGain){
        exp += expGain;
        System.out.println(this.name + " gained " + expGain + " experience points!");
        if (this.exp >= this.expNeeded){
            this.level += 1;
            this.exp -= this.expNeeded;
            this.expNeeded = (int) (this.expNeeded * 1.1 + 1);
            this.damageBase += 1;
            this.maxHealth = (int) (this.maxHealth * 1.1 + 1);
            this.health = maxHealth;
            System.out.println(this.name + " is now level " + this.level + "!");
        }


    };

    public int getHealth(){
        return this.health;
    }

    public void setHealth(int newHealth){
        this.health = newHealth;
    }

    public void setMaxHealth(int newHealth){
        this.maxHealth = newHealth;
    }

    public void takeDamage(int damage){
        this.health -= damage;
    }

    public void setDamageRange(int damageRange){
        this.damageRange = damageRange;
    }

    public void setDamageBase(int damageBase){
        this.damageBase = damageBase;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public boolean getAlive(){
        return this.alive;
    }

    public void setAlive(boolean live){
        this.alive = live;
    }

    public int getExpWorth(){
        return this.expWorth;
    }

    public int getX(){ return this.x;}

    public int getY(){ return this.y;}

    public void setX(int newX){ x = newX;}

    public void setY(int newY){ y = newY;}

    public String getOriginalName(){
        return originalName;
    }

    public void setOriginalName(String originalName){
        this.originalName = originalName;
    }







}
