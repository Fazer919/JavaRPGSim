package Characters;
import java.util.*;
import Characters.Items.*;

public class Goblin extends DefaultCharacter{
    public Goblin(Random rand, String name, float difficulty){
        super(rand, name);
        int minHp=5;
        int maxHp=10;
        hp=rand.nextInt(minHp,maxHp)*difficulty;
        Dagger d=new Dagger(rand);
        equipWeapon(d);
    }
}
