package Characters;
import java.util.*;
import Characters.Items.*;

public class DefaultCharacter{
    protected float hp;
    protected int maxHp=0;
    protected int attackPower;
    protected String name;
    protected int minHp;
    Random rand;
    Weapon weapon;
    float difficulty=1;

    public DefaultCharacter(Random rand, String name) {
        this.rand=rand;
        this.name=name;
    }

    public boolean attack(DefaultCharacter target){
        if(weapon.HitsOrMiss()){
            attackPower=weapon.rollDamage();
            int scaled=(int)(attackPower*difficulty);
            attackPower=scaled;
            target.takeDamage(attackPower);
            return true;
        }
        else{
            System.out.println(name+" missed.");
            return false;
        }
    }
    public float takeDamage(int dmg){
        return hp-=dmg;
    }
    public void equipWeapon(Weapon weapon){
        this.weapon=weapon;
        attackPower=weapon.getMaxDamage();
    }
    public int getAttackPower(){
        return attackPower;
    }

    public float getHp(){
        if(hp<=0){
            return 0;
        }
        else{
            return hp;
        }
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
    public void Stats(){
        System.out.println("Name of Character: "+name);
        System.out.println("Remaining Health: "+getHp()+"/"+maxHp);
        System.out.println(weapon.toString());
    }
    @Override
    public String toString() {
        return String.format("%s | HP: %.1f", getName(), getHp());
    }
}
