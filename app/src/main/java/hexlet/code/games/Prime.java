package hexlet.code.games;

import hexlet.code.Engine;
import java.util.Random;
public class Prime {
    public static void startGame(String namePlayer) {
        String questionText = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
        int correctAnswerCount = 0;
        Random randomOperand = new Random();
        Engine.showQuestionText(questionText);
        String rightAnswer = "";

        do {
            int randomNumber = randomOperand.nextInt(100);
            rightAnswer = getRightAnswer(randomNumber);
            String playerAnswer = Engine.askPlayerStringChoose(String.valueOf(randomNumber));
            correctAnswerCount = Engine.checkAnswer(namePlayer, playerAnswer, rightAnswer, correctAnswerCount);
        } while (correctAnswerCount >= 0 && correctAnswerCount < Engine.attempt);

        Engine.showResultGame((correctAnswerCount >= Engine.attempt), namePlayer);
    }

    private static String getRightAnswer(int randomNumber) {
        String result = "";
        if (randomNumber < 2) {
            result = "no";
        } else {
            for (var i = 2; i <= randomNumber / 2; i++) {
                if (randomNumber % i == 0) {
                    result = "no";
                    return result;
                } else {
                    result = "yes";
                }
            }
        }
        return result;
    }

}
