package Characters;
import java.util.*;
public class DefaultCharacter {
    protected int hp;
    protected int attackPower;
    protected String name;
    Random rand;

    public DefaultCharacter(Random rand, String name) {
        this.rand=rand;
        this.name=name;
    }

    public boolean attack(DefaultCharacter target){
        if(HitsOrMiss()){
            target.takeDamage(this.attackPower);
            return true;
        }
        else{
            System.out.println(name+" missed.");
            return false;
        }
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
    public int takeDamage(int dmg){
        return hp-=dmg;
    }


    public int getHp(){
        if(hp<=0){
            return 0;
        }
        else{
            return hp;
        }
    }
    public int getAttackPower(){
        return attackPower;
    }
    public String getName(){
        return name;
    }

    //Checks and returns a string if the person is dead
    public void printDeath(DefaultCharacter opponent){
        if(isDead()){
            System.out.print(name+" is dead. "+opponent.getName()+" wins.");
        }
        else{
            System.out.print(name+" is at "+hp+" hp.");
        }
    }
    public boolean isDead(){
        if(hp<=0){
            return true;
        }
        else{
            return false;
        }
    }
}
