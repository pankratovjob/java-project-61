package hexlet.code;

import java.util.Scanner;
import hexlet.code.games.Calc;
import hexlet.code.games.Even;
class App {
    public static void main(String[] args) {
        System.out.println("Please enter the game number and press Enter.");
        String[] games = {"1 - Greet", "2 - Even", "3 - Calc", "0 - Exit"};
        for (var game: games) {
            System.out.println(game);
        }
        Scanner console = new Scanner(System.in);
        int playerChoose = console.nextInt();
        System.out.println("Your choice: " + playerChoose);

        if (playerChoose == 1) {
            Engine.askName();
        } else if (playerChoose == 2) {
            Even.startGame();
        } else if (playerChoose == 3) {
            Calc.startGame();
        }
    }
}
