package rpggame;

import java.util.Random;
import java.util.Scanner;

import Characters.Goblin;
import Characters.Ogre;
import Characters.Warriors;
import javafx.application.Platform;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

public class App{
    public static void main(String[] args) throws Exception {
        Random rand=new Random();
        Platform.startup(() -> {});

        Media media = new Media(App.class.getResource("/Audio/Nooo.m4a").toExternalForm());
        //
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        
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
                    //Seek must go in front of the play command as it ensures the mediaPlayer is ready for another round to play the recording again
                    mediaPlayer.seek(Duration.ZERO);
                    mediaPlayer.play();
                    // Optional: wait until the audio finishes before continuing
                    Object lock = new Object();
                    /*mediaPlayer.setOnEndOfMedia(() -> {
                        synchronized(lock) {
                            lock.notify();
                        }
                    });*/
                    synchronized(lock) {
                        mediaPlayer.seek(Duration.ZERO); // pause loop until clip finishes
                    }
                    break;
                }
            }
            String check="Do you want to fight again? (Y/N)";
            System.out.println();
            for(char ch: check.toCharArray()){
                System.out.print(ch);
                System.out.flush();
                Thread.sleep(100);
            }
            System.out.println();
            String restarter=scnr.next();
            if(!(restarter.charAt(0)=='Y')){
                repeat=false;
            }
        }
    }
}
