package Model;

public class GrassMonster extends Monster {

    static int num = 1;

    public GrassMonster() {
        setMaxHealth(120);
        setHealth(120);
        setDamageRange(4);
        setDamageBase(4);
        setName("Grass Monster");
        setOriginalName("Grass Monster");
        num += 1;
    }

}
