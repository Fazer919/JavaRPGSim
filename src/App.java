import Characters.*;
import java.util.Random;
public class App {
    public static void main(String[] args) throws Exception {
        Random rand=new Random();
        int hpOfperson=rand.nextInt(10);
        int attackPower=rand.nextInt(5);
        String name="Albert";
        Goblin goblin = new Goblin(hpOfperson, attackPower, "Gerald");
        Ogre ogre=new Ogre(10, 5, name);
        Warriors warrior=new Warriors(hpOfperson, attackPower, name);
        int hpOfEnemy=warrior.attack(goblin);
        System.out.println(warrior.getName()+" hit "+goblin.getName()+" for "+attackPower+". "+goblin.getName()+" HP: "+hpOfEnemy);
        System.out.println(goblin.isDead());
    }
}
