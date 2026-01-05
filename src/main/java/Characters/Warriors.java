package Characters;
import java.util.*;

import Characters.Items.*;
public class Warriors extends DefaultCharacter {
    private Weapon weapon;
    Scanner scnr;
    Map<Integer, Weapon> weaponMap=new HashMap<>();
    public Warriors(Random rand, String name, Scanner scnr) {
        super(rand, name);
        Axe axe=new Axe(rand);
        Dagger dagger=new Dagger(rand);
        Sword sword=new Sword(rand);
        weaponMap.put(1, axe);
        weaponMap.put(2, dagger);
        weaponMap.put(3, sword);
        hp=rand.nextInt(5,10);
        this.scnr=scnr;
        System.out.println("Please choose a weapon. Type (1-3) for any of the following choices."); 
        System.out.println("1. "+axe.toString());
        System.out.println("2. "+dagger.toString());
        System.out.println("3. "+sword.toString());
        boolean valid_weapon=false;
        while(!valid_weapon){
            try {
                int choice=scnr.nextInt();
                switch (choice) {
                    case 1 -> {
                        equipWeapon(axe);
                        valid_weapon=true;
                        break;
                    }
                    case 2 -> {
                        equipWeapon(dagger);
                        valid_weapon=true;
                        break;
                    }
                    case 3 -> {
                        equipWeapon(sword);
                        valid_weapon=true;
                        break;
                    }
                    default -> System.out.println("You put in a choice that was not allowed. Please type a number between 1-3.");
                }
            }   
            catch (InputMismatchException e) {
                System.out.println("You put in a choice that was not allowed. Please type a number between 1-3.");
                scnr.nextLine();
            }
        }
        System.out.println("For this battle your stats are: HP: "+getHp()+" Max damage from basic attack: "+getAttackPower());
    }
}