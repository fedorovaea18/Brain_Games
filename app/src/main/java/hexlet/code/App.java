package hexlet.code;

import hexlet.code.games.EvenGame;
import hexlet.code.games.CalcGame;
import hexlet.code.games.GcdGame;
import hexlet.code.games.ProgressionGame;
import hexlet.code.games.PrimeGame;

import java.util.Scanner;

public class App {
    private static final int GREET = 1;
    private static final int EVEN_GAME = 2;
    private static final int CALC_GAME = 3;
    private static final int GCD_GAME = 4;
    private static final int PROGRESSION_GAME = 5;
    private static final int PRIME_GAME = 6;
    private static final int EXIT = 0;
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter the game number and press Enter.");
        System.out.println("1 - Greet");
        System.out.println("2 - Even");
        System.out.println("3 - Calc");
        System.out.println("4 - GCD");
        System.out.println("5 - Progression");
        System.out.println("6 - Prime");
        System.out.println("0 - Exit");
        System.out.print("Your choice: ");

        int gameNumber = scanner.nextInt();

        switch (gameNumber) {
            case EXIT:
                System.out.println("Goodbye!");
                break;
            case GREET:
                Cli.greeting();
                break;
            case EVEN_GAME:
                EvenGame.play();
                break;
            case CALC_GAME:
                CalcGame.play();
                break;
            case GCD_GAME:
                GcdGame.play();
                break;
            case PROGRESSION_GAME:
                ProgressionGame.play();
                break;
            case PRIME_GAME:
                PrimeGame.play();
                break;
            default:
                System.out.println("Wrong choice");
                break;
        }
    }
}
