package Model;

public class Battle {

    public static void battle(Monster first, Monster second){
        boolean nextTurn = first.getAlive();
        while (nextTurn){
            first.attack(second);
            nextTurn = second.getAlive();
            Monster temp = first;
            first = second;
            second = temp;
        }
        System.out.println(second.getName() + " has " + second.getHealth() + " health left!");
        second.levelUp(first.getExpWorth());
    }

    private void expBoost(Monster winner, Monster loser){
        winner.levelUp(loser.getExpWorth());
    }

}
