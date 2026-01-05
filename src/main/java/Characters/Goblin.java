package Characters;
import java.util.Random;
import Characters.Items.*;

public class Goblin extends DefaultCharacter{
    public Goblin(Random rand, String name, float difficulty){
        super(rand, name);
        hp=rand.nextInt(5,10)*difficulty;
        Dagger d=new Dagger(rand);
        equipWeapon(d);
    }
}
