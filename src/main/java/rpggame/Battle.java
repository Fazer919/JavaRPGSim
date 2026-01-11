package rpggame;

import Characters.*;
import java.util.*;

public class Battle{
    Hero hero;
    ArrayList<DefaultCharacter> enemys;
    String playerDeath="/Audio/Nooo.m4a";
    String attack="/Audio/Damage.m4a";
    String enemyDeath="/Audio/golfclap.m4a";
    SoundManager sm=new SoundManager();
    boolean playerAttacked=false;
    DefaultCharacter enemy=null;
    int specific_enemy;
    Scanner scnr;
    Random rand;
    public Battle(Hero hero, ArrayList<DefaultCharacter> enemy_group, Scanner scnr,Random rand) {
        this.hero=hero;
        this.enemys=enemy_group;
        this.enemy=enemy_group.get(1);
        this.scnr=scnr;
        this.rand=rand;
    }
    public void run(){
        System.out.println("==        NEW       FIGHT         ==");
        System.out.println("_______________________________________");
        while(!hero.isDead()&&!enemys.isEmpty()) {
            for(int i=0; i<5;i++){
                System.out.println();
            }
            for(int i=0;i<3;i++){
                System.out.println();
            }
            boolean repeater=true;
            while (repeater) {
                System.out.println("1. Attack");
                System.out.println("2. Heal");
                System.out.println("3. Quit battle");
                System.out.println("4. Character Stats"); 
                try {
                    int choice=scnr.nextInt();
                    switch (choice) {

                        //Attack and choosing a person to attack
                        case 1 -> {
                            System.out.println("Choose which enemy you want to hit.");
                            int i;
                            for(i=0; i<enemys.size()-1;i++){
                                System.out.println("Type "+i+" for: "+enemys.get(i)+". ");
                            }
                            while (true) { 
                                try {
                                    int choice_of_enemy=scnr.nextInt();
                                    if(choice_of_enemy>-1 && choice_of_enemy<i){
                                        enemy=enemys.get(choice_of_enemy);
                                        specific_enemy=choice_of_enemy;
                                        break;
                                    }
                                    else{
                                        System.out.println("You put in an invalid enemy. Please choose again from the list.");
                                    }
                                } 
                                catch (InputMismatchException e) {
                                    System.out.println("You put in an invalid enemy. Please choose again from the list.");
                                }   
                            }
                            playerAttacked=true;
                            if (hero.attack(enemy)) {
                                System.out.println(hero.getName()+" rolled "+hero.getAttackPower()+"! "+enemy.getName()+" HP: "+enemy.getHp());
                                sm.play(attack);
                                repeater=false;
                                break;
                            } else {
                                repeater=false;
                                break;
                            }
                        }

                        //Choice of Healing
                        case 2 -> {
                            repeater=false;
                            System.out.println("You take a moment to heal...");
                            System.out.println("Enemies seize the opportunity!");
                            hero.heal();
                            break;
                        }

                        //Quit the battle
                        case 3 -> {
                            enemys.clear();
                            repeater=false;
                            break;
                        }

                        //Stats of characters
                        case 4 ->{
                            hero.Stats();
                        }
                        default -> System.out.println("You put in a choice that was not allowed. Please type a number between 1-4.");
                    }
                }   
                catch (InputMismatchException e) {
                    System.out.println("You put in a choice that was not allowed. Please type a number between 1-4.");
                    scnr.nextLine();
                }
            }
            if(enemys.isEmpty()){
                break;
            }

            if(enemy.isDead()&&enemy!=null&&playerAttacked){
                enemy.printDeath(hero);
                enemys.remove(specific_enemy);
                sm.play(enemyDeath);
                playerAttacked=false;
            }
            else{
                int random_enemy=rand.nextInt(enemys.size());
                DefaultCharacter attacker=enemys.get(random_enemy);
                if(attacker.attack(hero)){
                    sm.play(attack);
                    System.out.println(attacker.getName()+" rolled "+attacker.getAttackPower()+"! "+hero.getName()+" HP: "+hero.getHp());
                }
                if(hero.isDead()){
                    hero.printDeath(attacker);
                    sm.play(playerDeath);
                    break;
                }
            }
            System.out.println();
            System.out.println("_______________________________________");
        }
    }
}