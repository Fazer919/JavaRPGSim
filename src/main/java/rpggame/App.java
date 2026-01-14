package rpggame;

import java.util.*;

import Characters.*;
import javafx.application.Platform;

public class App{
    public static void main(String[] args) throws Exception {
        Random rand=new Random();
        Platform.startup(() -> {});

        //Naming the player and dealing with edge cases that the player might do
        boolean repeat=true;
        Scanner scnr=new Scanner(System.in);
        System.out.print("Give me your characters name: ");
        String name=scnr.nextLine();
        boolean namer=false;
        if (name.isEmpty()) {
            System.out.println("You typed in a wrong name. Please type in another name or the name Albert will be given to you.");
            name=scnr.nextLine();
            namer=true;   
        }
        for(int i=0;i<name.length();i++){
            if (!Character.isLetter(name.charAt(i))) {
            System.out.println("You typed in a wrong name. Please type in another name or the name Albert will be given to you.");
            name=scnr.nextLine();
            namer=true;
            break;
            }
        }
        if(name.isEmpty()&&namer==true){
            name="Albert";
        }
        for(int i=0;i<name.length();i++){
            if (!Character.isLetter(name.charAt(i))) {
                name="Albert";
                break;
            }
        }

        //Battle loop
        while(repeat==true){
            EnemyFactory ef=new EnemyFactory();
            ArrayList enemy=ef.getrandomEnemy(rand, scnr);
            System.out.println();
            System.out.println();
            Warriors warrior=new Warriors(rand, name, scnr);
            Battle b=new Battle(warrior, enemy,scnr,rand);
            b.run();
            //Check if user wants to repeat the game
            String check="Do you want to fight again? (Y/N)";
            System.out.println();
            for(char ch: check.toCharArray()){
                System.out.print(ch);
                System.out.flush();
                Thread.sleep(100);
            }
            System.out.println();
            String restarter=scnr.next();
            String input=restarter.trim();
            if (!input.equalsIgnoreCase("yes")&&!input.equalsIgnoreCase("y")) {
                repeat = false;
            }
        }
    }
}