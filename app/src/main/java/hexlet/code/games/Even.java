package hexlet.code.games;

import java.util.Random;
import hexlet.code.Engine;

public class Even {
    public static void startGame(String name) {
        String questionText = "Answer 'yes' if the number is even, otherwise answer 'no'.";
        int correct = 0;
        Random random = new Random();

        Engine.showQuestionText(questionText);

        do {
            int randomNumber = random.nextInt(100);
            String rightAnswer = (randomNumber % 2 == 0) ? "yes" : "no";
            String playerAnswer = Engine.askPlayerStringChoose(randomNumber);
            correct = Engine.checkAnswer(name, playerAnswer, rightAnswer, correct);

        } while (correct >= 0 && correct < 3);

        Engine.showResultGame((correct >= 3), name);

    }
}
