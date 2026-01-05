package Characters;
import java.util.Random;
import Characters.Items.*;

public class Assasin extends DefaultCharacter{
    public Assasin(Random rand, String name, float difficulty){
        super(rand, name);
        attackPower=rand.nextInt(1,5);
        hp=rand.nextInt(5,10);
        Sword s=new Sword(rand);
        equipWeapon(s);
    }
}
