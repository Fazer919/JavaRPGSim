package Characters.Items;
import java.util.Random;

import Characters.*;

public class Weapon extends Item{
    private int maxDamage;
    private int minDamage;
    private Random rand;
    double hitChance;
    public Weapon(String name, Random rand, int minDamage, int maxDamage, double hitChance){
        super(name);
        this.rand=rand;
        this.minDamage=minDamage;
        this.maxDamage=maxDamage;
        this.hitChance=hitChance;
    }

    public double rollDamage(){
        return rand.nextDouble(minDamage, maxDamage+1);
    }
    public boolean HitsOrMiss(){
        double chance=rand.nextDouble();
        if(chance<hitChance){
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
