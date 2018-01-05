package Model;

public class WaterMonster extends Monster {

    static int num = 1;

    public WaterMonster(){
        setMaxHealth(100);
        setHealth(100);
        setDamageRange(4);
        setDamageBase(6);
        setName("Water Monster");
        setOriginalName("Water Monster");
        num += 1;
    }

}
