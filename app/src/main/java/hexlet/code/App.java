package hexlet.code;

import java.util.Scanner;
class App {
    public static void main(String[] args) {
        //Cli.askName();
        System.out.println("Please enter the game number and press Enter.");
        String[] games = {"1 - Greet", "2 - Even", "3 - Exit"};
        for (var game: games) {
            System.out.println(game);
        }
        Scanner console = new Scanner(System.in);
        int playerChoose = console.nextInt();
        System.out.println("Your choice: " + playerChoose);

        if (playerChoose == 1) {
            Cli.askName();
        } else if (playerChoose == 2) {
            Even.startGame();
        }
    }
}
