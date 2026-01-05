package rpggame;

import Characters.*;
import java.util.*;

public class Battle{
    DefaultCharacter hero;
    DefaultCharacter enemy;
    String playerDeath="/Audio/Nooo.m4a";
    String attack="/Audio/Damage.m4a";
    String enemyDeath="/Audio/golfclap.m4a";
    Scanner scnr;
    Random rand;
    public Battle(DefaultCharacter hero, DefaultCharacter enemy, Scanner scnr,Random rand) {
        this.hero=hero;
        this.enemy=enemy;
        this.scnr=scnr;
        this.rand=rand;
    }
    public void run(){
        SoundManager sm=new SoundManager();
        for(int i=0; i<5;i++){
            System.out.println();
        }
        boolean battler=true;
        System.out.println("==        NEW       FIGHT         ==");
        System.out.println("_______________________________________");
        while(!hero.isDead()&&!enemy.isDead()&&battler) {
            for(int i=0;i<3;i++){
                System.out.println();
            }
            boolean repeater=true;
            boolean checker=false;
            while (repeater) {
                System.out.println("1. Attack");
                System.out.println("2. Check Hp");
                System.out.println("3. Skip Turn");
                System.out.println("4. Quit battle"); 
                try {
                    int choice=scnr.nextInt();
                    switch (choice) {
                        case 1 -> {
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
                        case 2 -> {
                                System.out.println("HP of "+hero.getName()+": "+hero.getHp());
                                System.out.println("HP of "+enemy.getName()+": "+enemy.getHp());
                                repeater=false;
                                checker=true;
                                break;
                        }
                        case 3 -> {
                            repeater=false;
                            break;
                        }
                        case 4 -> {
                                battler=false;
                                checker=true;
                                repeater=false;
                            break;
                        }
                        default -> System.out.println("You put in a choice that was not allowed. Please type a number between 1-4.");
                    }
                }   
                catch (InputMismatchException e) {
                    System.out.println("You put in a choice that was not allowed. Please type a number between 1-4.");
                    scnr.nextLine();
                }
            }
            if(enemy.isDead()){
                enemy.printDeath(hero);
                sm.play(enemyDeath);
                break;
            }            
            if(!checker){
                if(enemy.attack(hero)){
                sm.play(attack);
                System.out.println(enemy.getName()+" rolled "+enemy.getAttackPower()+"! "+hero.getName()+" HP: "+hero.getHp());
                }
            }
            if(hero.isDead()){
                hero.printDeath(enemy);
                sm.play(playerDeath);
                break;
            }
        }
    }
}