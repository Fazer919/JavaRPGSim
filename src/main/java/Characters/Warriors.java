package Characters;
import java.util.*;
public class Warriors extends DefaultCharacter {
    public Warriors(Random rand, String name) {
        super(rand, name);
        attackPower=rand.nextInt(1,5);
        hp=rand.nextInt(5,10);
    }

    @Override
    public boolean HitsOrMiss() {
        super.HitsOrMiss();
        int chance=rand.nextInt(0,3);
        attackPower=rand.nextInt(1,5);
        if(chance!=2){
            return true;
        }
        else{
            return false;
        }
    }
}