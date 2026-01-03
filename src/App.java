import Characters.*;
import java.util.*;

public class App {
    public static void main(String[] args) throws Exception {
        Random rand=new Random();

        //When i get a chance switch this from a set name to a name given by the user
        String name="Albert";
        boolean repeat=true;
        Scanner scnr=new Scanner(System.in);
        while(repeat==true){
            Goblin goblin = new Goblin(rand, "Goblin");
            Ogre ogre=new Ogre(rand, "Ogre");
            Warriors warrior=new Warriors(rand, name);
            for(int i=0; i<5;i++){
                System.out.println();
            }
            System.out.println("==        NEW       FIGHT         ==");
            while(!warrior.isDead()&&!goblin.isDead()) {
                if(warrior.attack(goblin)){
                    System.out.println(warrior.getName()+" hit "+goblin.getName()+" for "+warrior.getAttackPower()+". "+goblin.getName()+" HP: "+goblin.getHp());
                }

                if(goblin.isDead()){
                    goblin.printDeath(warrior);
                    break;
                }

                if(goblin.attack(warrior)){
                    System.out.println(goblin.getName()+" hit "+warrior.getName()+" for "+goblin.getAttackPower()+". "+warrior.getName()+" HP: "+warrior.getHp());
                }
                if(warrior.isDead()){
                    warrior.printDeath(goblin);
                    break;
                }
            }
            System.out.println(" Do you want to fight again? (Y/N)");
            String restarter=scnr.next();
            if(!(restarter.charAt(0)=='Y')){
                repeat=false;
            }
        }
    }
}
