package hexlet.code;

import java.util.Scanner;
import java.util.Random;

class Even {
    public static void startGame() {
        String name = Cli.askName();
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");

        int correct = 0; // счетчик правильных ответов
        String playerChoose = ""; // ответ игрока
        Scanner console = new Scanner(System.in);
        Random random = new Random();
        int randomNumber = 0;  // случайное число от 0 до 99
        String rightAnswer = "";
        int win = 1;

        do {
            randomNumber = random.nextInt(100);
            System.out.println("Question: " + randomNumber);
            playerChoose = console.nextLine();
            rightAnswer = (randomNumber % 2 == 0) ? "yes" : "no";

            if (playerChoose.equals(rightAnswer)) {
                System.out.println("Correct!");
                correct += 1;
            } else {
                System.out.println(playerChoose + " is wrong answer ;(. Correct answer was " + rightAnswer + ".");
                correct = 0;
                win = 0;
                break;
            }
        } while (correct < 3);

        if (win == 1) {
            System.out.println("Congratulations, " + name + "!");
        } else {
            System.out.println("Let's try again, " + name + "!");
        }
    }
}
