package Characters;
import java.util.*;
import Characters.Items.*;

public class DefaultCharacter{
    protected double hp;
    protected int maxHp=0;
    protected double attackPower;
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
        if(weapon==null){
            System.out.println("User has no weapon.");
            return false;
        }
        if(weapon.HitsOrMiss()){
            attackPower=weapon.rollDamage()*difficulty;
            target.takeDamage(attackPower);
            return true;
        }
        else{
            System.out.println(name+" missed.");
            return false;
        }
    }
    public double takeDamage(double dmg){
        return hp-=dmg;
    }
    public void equipWeapon(Weapon weapon){
        this.weapon=weapon;
        attackPower=weapon.getMaxDamage();
    }
    public double getAttackPower(){
        return attackPower;
    }

    public double getHp(){
        if(hp<=0){
            return 0;
        }
        else{
            return Math.max(hp, 0);
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
            System.out.printf("%s is at %.1f hp.%n", name, getHp());
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
