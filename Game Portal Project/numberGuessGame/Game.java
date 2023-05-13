import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;

public class Game {
    int numTries = 0;
    int min = 1;
    int max; 

    int guess = 0;
    Scanner sc= new Scanner(System.in);
    int number; 
    String response = "Y";


    Game(int difficulty) { // different levels of difficulty which determines the max (the min is predetermined)
        Random rand = new Random();
        switch (difficulty) {

            case 1: 
                this.max = 10;// the number just has to be 
                break;
            case 2: 
                this.max= 50;
                break;
            case 3: 
                this.max = 100; // most difficult 
                break;
            default: 
                this.max= 100;     
        }
        number = rand.nextInt(min,max + 1); 
        System.out.println( "I am thinking of a number from " + min + " to " + max + " can you guess it?");

        // create scanner object which read user input
        Scanner scanner = new Scanner(System.in);

        // Use the random generator to 3
        // pick a number between 0 and 99 (inclusive)
        int guess = -1;
        int count = 0;

        ArrayList <Integer> arraylist= new ArrayList();
    
         

        // Loop until the user has guessed the number
        while (guess != number) {



            // Read the users guess
            guess = errorCheck(scanner);
            count++;

            // Check if the guess is high, low or correct
            if (guess < 1) {
                System.out.println("Out of Bounds - Try again");

            } 
            
            else if ( arraylist.contains (guess) )
                System.out.println("You already guessed that try again");

            else if (guess < number) {

                // The guess is too low
                System.out.println("Too low, please try again");
                arraylist.add (guess);
                    

            } else if (guess > 100) {
                System.out.println("Out of Bounds - Try again");
            }

            else if (guess > number) {

                // The guess is too high
                System.out.println("Too high, please try again");
                arraylist.add (guess);

            }

            else {

                // Guess is correct !!
                System.out.println("Correct, the number was " + number + ". You needed " + count + " tries");
    

            }
        }
         }
        

    public static int errorCheck(Scanner sc) {
        if (sc.hasNextInt()) {
            return sc.nextInt();
            // if input is not a number
        } else {
            System.out.println("This is not a number. Discarding this input");
            sc.next(); // discarding the next input
            return errorCheck(sc);
        }

    }
}


