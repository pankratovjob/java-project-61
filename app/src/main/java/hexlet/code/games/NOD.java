package hexlet.code.games;

import hexlet.code.Engine;
import java.util.Random;
public class NOD {
    public static void startGame(String name) {
        String questionText = "Find the greatest common divisor of given numbers.";
        int correct = 0;
        Random randomOperand = new Random();
        boolean win = false;
        Engine.showQuestionText(questionText);

        do {
            int numOne = randomOperand.nextInt(100);
            int numTwo = randomOperand.nextInt(100);
            Engine.showQuestion("" + numOne + " " + numTwo);
            int rightAnswer = getRightAnswer(numOne, numTwo);

            int playerAnswer = Engine.askPlayerIntChoose();

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

    public static int getRightAnswer(int a, int b) {
        if (b == 0) {
            return a;
        }
        int temp = a % b;
        return getRightAnswer(b, temp);
    }
}
