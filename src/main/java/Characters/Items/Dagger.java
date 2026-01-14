package Characters.Items;

import java.util.Random;

public class Dagger extends Weapon{
    Random rand;
    public Dagger(Random rand){
        super("Dagger", rand ,3,5, 0.75);
        this.rand=rand;
    }
    public String toString(){
        return "Dagger stats: 3 minimum damage,5 maximum damage. Has a 75% chance to hit";
    }
}