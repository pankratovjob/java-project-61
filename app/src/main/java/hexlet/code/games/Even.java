package hexlet.code.games;

import java.util.Random;
import hexlet.code.Engine;

public class Even {
    public static void startGame(String namePlayer) {
        String questionText = "Answer 'yes' if the number is even, otherwise answer 'no'.";
        int correctAnswerCount = 0;
        Random random = new Random();
        int rangeForNumber = 100;
        Engine.showQuestionText(questionText);

        do {
            int randomNumber = random.nextInt(rangeForNumber);
            String rightAnswer = (randomNumber % 2 == 0) ? "yes" : "no";
            String playerAnswer = Engine.askPlayerStringChoose(String.valueOf(randomNumber));

            correctAnswerCount = Engine.checkAnswer(namePlayer, playerAnswer, rightAnswer, correctAnswerCount);

        } while (correctAnswerCount >= 0 && correctAnswerCount < Engine.attempt);

        Engine.showResultGame((correctAnswerCount >= Engine.attempt), namePlayer);

    }
}
