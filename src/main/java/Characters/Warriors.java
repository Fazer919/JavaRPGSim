package Characters;
import java.util.*;

public class Warriors extends Hero {
    Scanner scnr;
    int minHp;
    public Warriors(Random rand, String name, Scanner scnr) {
        super(rand, name, scnr);
        this.maxHp=10;
        this.minHp=5;
        hp=rand.nextInt(minHp,maxHp+1);
        this.scnr=scnr;
        System.out.println("For this battle your stats are: HP: "+getHp()+" Max damage from basic attack: "+getAttackPower());
    }
}