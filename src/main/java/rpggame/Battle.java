package rpggame;

import Characters.*;
import java.util.*;

public class Battle{
    Hero hero;
    ArrayList<Enemy> enemys;
    String playerDeath="/Audio/Nooo.m4a";
    String attack="/Audio/Damage.m4a";
    String enemyDeath="/Audio/golfclap.m4a";
    SoundManager sm=new SoundManager();
    boolean skipEnemyTurn=false;
    Scanner scnr;
    Random rand;
    public Battle(Hero hero, ArrayList<Enemy> enemy_group, Scanner scnr,Random rand) {
        this.hero=hero;
        this.enemys=enemy_group;
        this.scnr=scnr;
        this.rand=rand;
    }
    public void run(){
        spacer();
        System.out.println("==        NEW       FIGHT         ==");
        System.out.println("_______________________________________");
        while(!hero.isDead()&&!enemys.isEmpty()) {
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
                            spacer();
                            System.out.println("Choose which enemy you want to hit.");
                            int i;
                            for(i=0; i<enemys.size();i++){
                                System.out.println("Type "+i+" for: "+enemys.get(i)+". ");
                            }
                            //ATTACK FUNCTION AND CHECK IF IS ENEMY DEAD
                            while (true) { 
                                try {
                                    int choice_of_enemy=scnr.nextInt();
                                    if(choice_of_enemy>-1 && choice_of_enemy<i){
                                        DefaultCharacter enemy=enemys.get(choice_of_enemy);
                                        if (hero.attack(enemy)) {
                                            System.out.printf("%s rolled %.1f! %s HP: %.1f", 
                                            hero.getName(), 
                                            hero.getAttackPower(), 
                                            enemy.getName(), 
                                            enemy.getHp());
                                            sm.play(attack);
                                            //Checker if the enemy is dead
                                            System.out.println();
                                            if(enemy.isDead()){
                                                enemy.printDeath(hero);
                                                enemys.remove(choice_of_enemy);
                                                sm.play(enemyDeath);
                                                skipEnemyTurn=true;
                                            }
                                        }
                                        repeater=false;
                                        break;
                                    }
                                    else{
                                        System.out.println("You put in an invalid enemy. Please choose again from the list.");
                                        spacer();
                                    }
                                } 
                                catch (InputMismatchException e) {
                                    System.out.println("You put in an invalid enemy. Please choose again from the list.");
                                    spacer();
                                }   
                            }
                            break;
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
            if(!skipEnemyTurn){
                for(Enemy attacker: enemys){
                    if(attacker.attack(hero)){
                        sm.play(attack);
                        System.out.printf("%s rolled %.1f! %s HP: %.1f", 
                        attacker.getName(), 
                        attacker.getAttackPower(), 
                        hero.getName(), 
                        hero.getHp());
                        System.out.println();
                    }
                    if(hero.isDead()){
                        hero.printDeath(attacker);
                        sm.play(playerDeath);
                        break;
                    }
                }
            }
            System.out.println();
            System.out.println("_______________________________________");
        }
    }
    public void spacer(){
        for(int i=0; i<2; i++){
            System.out.println();
        }
    }
}