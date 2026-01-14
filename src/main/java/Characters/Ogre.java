package Characters;
import java.util.*;
import Characters.Items.*;

public class Ogre extends Enemy{
    public Ogre(Random rand, String name, float difficulty) {
        super(rand, name);
        int minHp=10;
        int maxHp=20;
        hp=rand.nextInt(minHp,maxHp)*difficulty;
        this.difficulty=difficulty;
        Axe axe=new Axe(rand);
        equipWeapon(axe);
    }
}
