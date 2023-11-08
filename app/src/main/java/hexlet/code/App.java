package hexlet.code;

import hexlet.code.games.FirstGame;
import hexlet.code.games.SecondGame;
import hexlet.code.games.ThirdGame;
import hexlet.code.games.FourthGame;
import hexlet.code.games.FifthGame;

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
                Engine.runGame(new FirstGame());
                break;
            case CALC_GAME:
                Engine.runGame(new SecondGame());
                break;
            case GCD_GAME:
                Engine.runGame(new ThirdGame());
                break;
            case PROGRESSION_GAME:
                Engine.runGame(new FourthGame());
                break;
            case PRIME_GAME:
                Engine.runGame(new FifthGame());
                break;
            default:
                System.out.println("Wrong choice");
                break;
        }
    }
}
