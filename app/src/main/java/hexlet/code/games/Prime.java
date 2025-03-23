package hexlet.code.games;

import hexlet.code.Engine;
import java.util.Random;
public class Prime {
    public static void startGame(String name) {
        String questionText = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
        int correct = 0;
        Random randomOperand = new Random();
        Engine.showQuestionText(questionText);
        String rightAnswer = "";

        do {
            int randomNumber = randomOperand.nextInt(100);
            rightAnswer = getRightAnswer(randomNumber);

            String playerAnswer = Engine.askPlayerStringChoose(randomNumber);
            correct = Engine.checkAnswer(name, playerAnswer, rightAnswer, correct);

        } while (correct >= 0 && correct < 3);

        Engine.showResultGame((correct >= 3), name);

    }

    private static String getRightAnswer(int randomNumber) {
        String result = "";
        if (randomNumber < 2) {
            result = "no";
        } else {
            for (var i = 2; i <= randomNumber / 2; i++) {
                result = (randomNumber % i == 0) ? "no" : "yes";
            }
        }
        return result;
    }

}
