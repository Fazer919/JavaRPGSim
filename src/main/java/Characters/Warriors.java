package Characters;
import java.util.Random;
public class Warriors extends DefaultCharacter {
    public Warriors(Random rand, String name) {
        super(rand, name);
        attackPower=rand.nextInt(1,5);
        hp=rand.nextInt(5,10);
        System.out.println("For this battle your stats are: HP: "+getHp()+" Max damage from basic attack: "+getAttackPower());
    }

    @Override
    public boolean HitsOrMiss() {
        super.HitsOrMiss();
        int chance=rand.nextInt(0,4);
        attackPower=rand.nextInt(1,5);
        if(chance!=3){
            return true;
        }
        else{
            return false;
        }
    }
}