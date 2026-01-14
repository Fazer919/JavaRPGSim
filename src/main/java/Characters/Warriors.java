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
    }
}