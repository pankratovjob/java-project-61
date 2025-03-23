package hexlet.code.games;

import hexlet.code.Engine;
import java.util.Random;
public class NOD {
    public static void startGame(String name) {
        String questionText = "Find the greatest common divisor of given numbers.";
        int correct = 0;
        Random randomOperand = new Random();
        Engine.showQuestionText(questionText);

        do {
            int numOne = randomOperand.nextInt(100);
            int numTwo = randomOperand.nextInt(100);
            String primer = "" + numOne + " " + numTwo;

            String rightAnswer = String.valueOf(getRightAnswer(numOne, numTwo));
            String playerAnswer = String.valueOf(Engine.askPlayerIntChoose(primer));

            correct = Engine.checkAnswer(name, playerAnswer, rightAnswer, correct);

        } while (correct >= 0 && correct < 3);

        Engine.showResultGame((correct >= 3), name);
    }

    public static int getRightAnswer(int a, int b) {
        if (b == 0) {
            return a;
        }
        int temp = a % b;
        return getRightAnswer(b, temp);
    }
}
