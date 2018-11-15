import java.util.ArrayList;
import java.util.Scanner;
import static java.lang.System.*;

public class GuessingGameBasic {
    private static int RandomNumber( int upper ) {
        int random;
        int lower = 1;
        random = lower + ( int )( Math.random() * ( upper - lower + 1 ) + lower );
        return random;
    }

    public static void main( String[] args ) {
        Scanner stdin = new Scanner( in );
        out.print("Guessing Game\n" +
                "1. Beginner Level (numbers between 1 and 10)\n" +
                "2. Intermediate Level (numbers between 1 and 100)\n" +
                "3. Advanced Level (numbers between 1 and 1,000)\n" +
                "4. Expert Level (numbers between 1 and 10,000)\n" +
                "Type the number corresponding to the level you want to play:");
        int difficultyChoice = stdin.nextInt();

        while ( difficultyChoice < 1 || difficultyChoice > 4 ) {
            out.println( "Please type in a number between 1 and 4: " );
            difficultyChoice = stdin.nextInt();
        }

        out.println( "Guess the number!!" );
        int random = 0;
        int limit = 0;
        switch ( difficultyChoice ) {
            case 1:
                //code for beginner
                limit = 10;
                random = RandomNumber( limit );
                break;
            case 2:
                //code for intermediate
                limit = 100;
                random = RandomNumber( limit );
                break;
            case 3:
                //code for advanced
                limit = 1000;
                random = RandomNumber( limit );
                break;
            case 4:
                //code for expert
                limit = 10000;
                random = RandomNumber( limit );
                break;
        }

        int userGuess = stdin.nextInt();
        int[] guesses = new int[limit];
        int tries = 0;
        if ( userGuess > limit ) {
            out.println( "That is not valid" );
            userGuess = stdin.nextInt();
        }
        while ( random != userGuess ) {
            if ( userGuess > limit ) {
                out.println( "That is not valid" );
                userGuess = stdin.nextInt();
            }
            guesses[tries] = userGuess;
            out.print( "Wrong!" );
            tries++;
            if ( random < userGuess ) {
                out.println( " Your number should be LOWER" );
            }
            if ( random > userGuess ) {
                out.println( " Your number should be HIGHER" );
            }
            userGuess = stdin.nextInt();
        }
        tries++;
        guesses[tries] = userGuess;

        out.println( "You guessed the correct number in " + tries + " tries." );
        String allGuesses = "";
        for ( int i : guesses ) {
            if ( i == 0 ) {
                continue;
            }
            allGuesses += i + ", ";
        }
        out.println( "Your tried numbers were " + allGuesses.substring( 0, allGuesses.length() - 2 ) + "." );
        out.println();
    }
}
