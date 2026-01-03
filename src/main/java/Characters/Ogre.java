package Characters;
import java.util.*;
public class Ogre extends DefaultCharacter{
    public Ogre(Random rand, String name) {
        super(rand, name);
        attackPower=rand.nextInt(5,10);
        hp=rand.nextInt(10,20);
    }
}
