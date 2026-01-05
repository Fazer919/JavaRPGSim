package Characters;
import java.util.*;
import Characters.Items.*;
public class Ogre extends DefaultCharacter{
    public Ogre(Random rand, String name, float difficulty) {
        super(rand, name);
        hp=rand.nextInt(10,20)*difficulty;
        Axe axe=new Axe(rand);
        equipWeapon(axe);
    }
}
