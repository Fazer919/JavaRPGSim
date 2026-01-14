package Characters.Items;

import java.util.Random;

public class Sword extends Weapon{

    public Sword(Random rand){
        super("Sword", rand, 2,7, 0.5);
    }
    public String toString(){
        return "Sword stats: 2 as minimum damage and 6 as maximum damage. Has a 50% chance to hit";
    }
}
