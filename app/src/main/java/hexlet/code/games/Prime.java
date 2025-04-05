package hexlet.code.games;

import hexlet.code.Engine;
import java.util.Random;
public class Prime {

    public static String getQuestion() {
        String questionText = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
        return questionText;
    }

    public static int playRound(String namePlayer, int correctAnswerCount) {
        Random randomOperand = new Random();
        int randomNumber = randomOperand.nextInt(Engine.getRangeForNumber());

        String rightAnswer = getRightAnswer(randomNumber);
        String playerAnswer = Engine.askPlayerStringChoose(String.valueOf(randomNumber));

        correctAnswerCount = Engine.checkAnswer(namePlayer, playerAnswer, rightAnswer, correctAnswerCount);
        Engine.gamePlay(namePlayer, correctAnswerCount);
        return correctAnswerCount;
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
