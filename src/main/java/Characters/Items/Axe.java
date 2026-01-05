package Characters.Items;

import java.util.Random;

public class Axe extends Weapon{
    int minDamage;
    int maxDamage;
    Random rand;
    public Axe(Random rand){
        super("Axe", rand,1,10);
        this.rand =rand;
    }
    public String toString(){
        return "Axe stats: 1 minimum damage, 10 maximum damage. Has a 60% chance to hit";
    }

    @Override
    public boolean HitsOrMiss() {
        int chance=rand.nextInt(0,11);
        if(chance<6){
            return true;
        }
        else{
            return false;
        }
    }
}
