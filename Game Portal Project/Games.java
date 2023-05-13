
import java.io.File;
import java.util.HashMap;
import java.util.Scanner;

public class Games {
    static String[] gameChoices = { "NumberGuessGame", "Buzzfeed Quiz" };
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        HashMap<Game, Integer> gameCounts = new HashMap<>();
        File highScoreFile = new File("Highscore.csv");

        while (true) {
            System.out.println("Which game would you like to play?");
            printGameChoices();
            Game selectedGame = getGameChoice();
            
            if (selectedGame != null) {
                System.out.println("You're playing " + selectedGame.getGameName());
                selectedGame.play();
                selectedGame.writeHighScore(highScoreFile);
                updateGameCount(gameCounts, selectedGame);
            } else {
                System.out.println("Invalid game choice. Please try again.");
            }
            
            System.out.println("Do you want to play another game? (Y/N)");
            String playAgain = sc.next();
            
            if (playAgain.equalsIgnoreCase("N")) {
                break;
            }
        }
    }

    public static void printGameChoices() {
        int n = 1;
        for (String s : gameChoices) {
            System.out.println("[" + (n++) + "]: " + s);
        }
    }

    public static Game getGameChoice() {
        int choice = ErrorCheck.getInt(sc);

        while (choice < 1 || choice > gameChoices.length) {
            System.out.println("Invalid choice. Please try again.");
            choice = ErrorCheck.getInt(sc);
        }

        String gameString = gameChoices[choice - 1];
        if (gameString.equals("NumberGuessGame")) {
            return new numberGuessGame ();
        } else if (gameString.equals("Buzzfeed Quiz")) {
            return new BuzzFeedQuiz();
        } else {
            return null;
        }
    }
    
    public static void updateGameCount(HashMap<Game, Integer> gameCounts, Game game) {
        gameCounts.put(game, gameCounts.getOrDefault(game, 0) + 1);
    }
}

class ErrorCheck {
    public static int getInt(Scanner sc) {
        if (sc.hasNextInt()) {
            return sc.nextInt();
        } else {
            System.out.println("This is not a number. Discarding this input.");
            sc.next();
            return getInt(sc);
        }
    }
}
 class numberGuessGame implements Game {
    // Implement the methods from the Game interface
    public String getGameName() {
        return "Number Guess Game";
    }
    
    public void play() {
        // Your game logic goes here
    }
    
    public void writeHighScore(File file) {
        // Write the high score to the specified file
    }

    @Override
    public String getScore() {
        throw new UnsupportedOperationException("Unimplemented method 'getScore'");
    }
}

class BuzzFeedQuiz implements Game {
    // Implement the methods from the Game interface
    public String getGameName() {
        return "Number Guess Game";
    }
    
    public void play() {
        // Your game logic goes here
    }
    
    public void writeHighScore(File file) {
        // Write the high score to the specified file
    }

    @Override
    public String getScore() {
    
        throw new UnsupportedOperationException("Unimplemented method 'getScore'");
    }
}
