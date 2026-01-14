package Characters;
import java.util.Random;
import Characters.Items.*;

public class Assasin extends Enemy{
    public Assasin(Random rand, String name, float difficulty){
        super(rand, name);
        hp=rand.nextInt(5,10)*difficulty;
        this.difficulty=difficulty;
        Sword s=new Sword(rand);
        equipWeapon(s);
    }
}
