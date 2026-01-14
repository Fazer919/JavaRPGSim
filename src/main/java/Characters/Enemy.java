package Characters;

import java.util.Random;

public class Enemy extends DefaultCharacter{
    float damageMultiplier;
    public Enemy(Random rand, String name) {
        super(rand, name);
        damageMultiplier=0.4f;
    }
}
