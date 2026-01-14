package Characters.Items;

import java.util.Random;

public class Axe extends Weapon{
    Random rand;
    public Axe(Random rand){
        super("Axe", rand,1,10,0.6);
        this.rand =rand;
    }
    public String toString(){
        return "Axe stats: 1 minimum damage, 10 maximum damage. Has a 60% chance to hit";
    }
}
