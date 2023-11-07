package hexlet.code;

import hexlet.code.games.FirstGame;
import hexlet.code.games.SecondGame;
import hexlet.code.games.ThirdGame;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter the game number and press Enter.");
        System.out.println("1 - Greet");
        System.out.println("2 - Even");
        System.out.println("3 - Calc");
        System.out.println("4 - GCD");
        System.out.println("0 - Exit");
        System.out.print("Your choice: ");

        int gameNumber = scanner.nextInt();

        switch (gameNumber) {
            case 0:
                System.out.println("Goodbye!");
                break;
            case 1:
                Cli.greeting();
                break;
            case 2:
                Engine.runGame(new FirstGame());
                break;
            case 3:
                Engine.runGame(new SecondGame());
                break;
            case 4:
                Engine.runGame(new ThirdGame());
                break;

            default:
                System.out.println("Wrong choice");
                break;
        }
    }
}
