package hexlet.code.games;

//import java.util.Scanner;
import java.util.Random;
import hexlet.code.Engine;

public class Even {
    public static void startGame(String name) {
        String questionText = "Answer 'yes' if the number is even, otherwise answer 'no'.";
        int correct = 0; // счетчик правильных ответов
        Random random = new Random();
        boolean win = false;

        Engine.showQuestionText(questionText);

        do {
            int randomNumber = random.nextInt(100);
            String rightAnswer = (randomNumber % 2 == 0) ? "yes" : "no";
            Engine.showQuestion(randomNumber);
            String playerAnswer = Engine.askPlayerStringChoose();

            if (playerAnswer == rightAnswer) {
                win = true;
                correct = Engine.showResultAnswer(true, correct, playerAnswer, rightAnswer);
            } else {
                win = false;
                correct = Engine.showResultAnswer(false, correct, playerAnswer, rightAnswer);
                break;
            }
        } while (correct < 3);

        Engine.showResultGame(win, name);

    }
}
