package Characters;

import java.util.*;

import Characters.Items.Axe;
import Characters.Items.Dagger;
import Characters.Items.Sword;
import Characters.Items.Weapon;

public class Hero extends DefaultCharacter{
    Map<Integer, Weapon> weaponMap=new HashMap<>();
    public Hero(Random rand, String name, Scanner scnr){
        super(rand, name);
        Axe axe=new Axe(rand);
        Dagger dagger=new Dagger(rand);
        Sword sword=new Sword(rand);
        weaponMap.put(1, axe);
        weaponMap.put(2, dagger);
        weaponMap.put(3, sword);
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
                        weapon=axe;
                        valid_weapon=true;
                        break;
                    }
                    case 2 -> {
                        equipWeapon(dagger);
                        weapon=dagger;
                        valid_weapon=true;
                        break;
                    }
                    case 3 -> {
                        equipWeapon(sword);
                        weapon=sword;
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
    }
    public void heal(){
        int heal_value = rand.nextInt(minHp, maxHp + 1); // your original
        int actualHeal = (int)Math.min(heal_value, maxHp - hp);
        hp += actualHeal;
        System.out.println("You healed: " + actualHeal);
    }
}
