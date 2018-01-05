package Model;

public class FireMonster extends Monster {

    private static int num = 1;

    public FireMonster(){
        setMaxHealth(80);
        setHealth(80);
        setDamageRange(4);
        setDamageBase(8);
        setName("Fire Monster");
        setOriginalName("Fire Monster");
        num += 1;

    }

}

