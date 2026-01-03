import Characters.*;
import java.util.*;

public class App {
    public static void main(String[] args) throws Exception {
        Random rand=new Random();

        //When i get a chance switch this from a set name to a name given by the user
        String name="Albert";

        Goblin goblin = new Goblin(rand, "Goblin");
        Ogre ogre=new Ogre(rand, "Ogre");
        Warriors warrior=new Warriors(rand, name);

        while(!warrior.isDead()&&!goblin.isDead()) {
            if(warrior.attack(goblin)){
                System.out.println(warrior.getName()+" hit "+goblin.getName()+" for "+warrior.getAttackPower()+". "+goblin.getName()+" HP: "+goblin.getHp());
            }

            if(goblin.isDead()){
                goblin.printDeath(warrior);
                return;
            }

            if(goblin.attack(warrior)){
                System.out.println(goblin.getName()+" hit "+warrior.getName()+" for "+goblin.getAttackPower()+". "+warrior.getName()+" HP: "+warrior.getHp());
            }
            if(warrior.isDead()){
                warrior.printDeath(goblin);
                return;
            }
        }
    }
}
