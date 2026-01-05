package Characters.Items;
import java.util.Random;

import Characters.*;

public class Weapon extends Item{
    private int maxDamage;
    private int minDamage;
    private Random rand;
    public Weapon(String name, Random rand, int minDamage, int maxDamage){
        super(name);
        this.rand=rand;
        this.minDamage=minDamage;
        this.maxDamage=maxDamage;
    }

    public int rollDamage(){
        return rand.nextInt(minDamage, maxDamage+1);
    }

    public boolean HitsOrMiss(){
        int chance=rand.nextInt(0,2);
        if(chance==1){
            return true;
        }
        else{
            return false;
        }
    }
    public int getMaxDamage(){
        return maxDamage;
    }
}
