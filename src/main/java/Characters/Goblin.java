package Characters;
import java.util.Random;

public class Goblin extends DefaultCharacter{
    public Goblin(Random rand, String name){
        super(rand, name);
        attackPower=rand.nextInt(1,5);
        hp=rand.nextInt(5,10);
    }

    /*@Override
    public boolean HitsOrMiss() {
        super.HitsOrMiss();
        attackPower=rand.nextInt();
        return true;
    }*/
}
