package Characters;
public class DefaultCharacter {
    protected int hp;
    protected int attackPower;
    protected String name;

    public DefaultCharacter(int hp, int attackPower,String name) {
        this.name=name;
        this.attackPower=attackPower;
        this.hp=hp;
    }
    public int attack(DefaultCharacter target){
        int remainingHp=target.takeDamage(this.attackPower);
        if(remainingHp<=0){
            return 0;
        }
        else{
            return remainingHp;
        }
    }
    public int getAttackPower(){
        return attackPower;
    }
    public int takeDamage(int dmg){
        return hp-=dmg;
    }
    public String getName(){
        return name;
    }
    public String isDead(){
        if(hp<=0){
            return name+" is dead.";
        }
        else{
            return name+" is at "+hp+" hp.";
        }
    }
}
