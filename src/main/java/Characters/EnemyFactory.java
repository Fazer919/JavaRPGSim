package Characters;

import java.util.*;

public class EnemyFactory{

    public static ArrayList<DefaultCharacter> getrandomEnemy(Random rand, Scanner scnr){
        float difficulty=1;
        ArrayList<DefaultCharacter> group_of_enemies=new ArrayList<>();
        System.out.println("What is the difficulty you want for this run. Please type (1-3) for each one: ");
        System.out.println("1) Easy");
        System.out.println("2) Normal");
        System.out.println("3) Hard");
        int amount_of_enemies=10;
        boolean valid_difficulty=false;
        while(!valid_difficulty){
            try {
                int choice=scnr.nextInt();
                switch (choice) {
                    case 1 -> {
                        valid_difficulty=true;
                        difficulty=(float)0.8;
                    }
                    case 2 -> {
                        valid_difficulty=true;
                        difficulty=1;
                    }
                    case 3 -> {
                        valid_difficulty=true;
                        difficulty=(float)1.3;
                    }
                    default -> System.out.println("You put in a choice that was not allowed. Please type a number between 1-3.");
                }
            }   
            catch (InputMismatchException e) {
                System.out.println("You put in a choice that was not allowed. Please type a number between 1-3.");
                scnr.nextLine();
            }
        }
        int count_of_enemies=3;
        while(amount_of_enemies>-1){
            int choice=rand.nextInt(1,count_of_enemies+1);
            switch (choice) {
                case 1 ->{
                    Goblin goblin=new Goblin(rand, "Goblin", difficulty);
                    group_of_enemies.add(goblin);
                    amount_of_enemies--;
                }
                case 2->{
                    Ogre ogre=new Ogre(rand, "Ogre" , difficulty);
                    group_of_enemies.add(ogre);
                    amount_of_enemies--;
                }
                default->{
                    Assasin assasin=new Assasin(rand, "Assasin", difficulty);
                    group_of_enemies.add(assasin);
                    amount_of_enemies--;
                }
            }
        }
        return group_of_enemies;
    }
}
