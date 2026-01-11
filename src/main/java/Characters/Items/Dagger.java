package Characters.Items;

import java.util.Random;

public class Dagger extends Weapon{
    Random rand;
    public Dagger(Random rand){
        super("Dagger", rand ,3,5);
        this.rand=rand;
    }
    public String toString(){
        return "Dagger stats: 3 minimum damage,5 maximum damage. Has a 75% chance to hit";
    }

    @Override
    public boolean HitsOrMiss() {
        int chance=rand.nextInt(0,4);
        if(chance<3){
            return true;
        }
        else{
            return false;
        }
    }
    
}