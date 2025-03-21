package hexlet.code.games;

import java.util.Scanner;
import java.util.Random;
import hexlet.code.Engine;

public class Even {
    public static void startGame() {
        String name = Engine.askName();
        String questionText = "Answer 'yes' if the number is even, otherwise answer 'no'.";
        int correct = 0; // счетчик правильных ответов
        Scanner console = new Scanner(System.in);
        Random random = new Random();

        do {
            int randomNumber = random.nextInt(100);
            String rightAnswer = (randomNumber % 2 == 0) ? "yes" : "no";
            Engine.showQuestion(randomNumber, questionText);
            String playerAnswer = console.nextLine();

            if (playerAnswer.equals(rightAnswer)) {
                correct = Engine.showResultAnswer(true, correct, playerAnswer, rightAnswer);
            } else {
                correct = Engine.showResultAnswer(false, correct, playerAnswer, rightAnswer);
                break;
            }
        } while (correct < 3);

        Engine.showResultGame(true, name);

    }
}
