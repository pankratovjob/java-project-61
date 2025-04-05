package hexlet.code.games;

import hexlet.code.Engine;
import java.util.Random;
public class NOD {

    public static String getQuestion() {
        String questionText = "Find the greatest common divisor of given numbers.";
        return questionText;
    }

    public static int playRound(String namePlayer, int correctAnswerCount) {
        Random randomOperand = new Random();

        int numOne = randomOperand.nextInt(Engine.getRangeForNumber());
        int numTwo = randomOperand.nextInt(Engine.getRangeForNumber());

        String expression = "" + numOne + " " + numTwo;
        String rightAnswer = getRightAnswer(numOne, numTwo);
        String playerAnswer = Engine.askPlayerStringChoose(String.valueOf(expression));


        correctAnswerCount = Engine.checkAnswer(namePlayer, playerAnswer, rightAnswer, correctAnswerCount);
        Engine.gamePlay(namePlayer, correctAnswerCount);
        return correctAnswerCount;
    }

    public static String getRightAnswer(int a, int b) {
        if (b == 0) {
            return String.valueOf(a);
        }
        int temp = a % b;
        return getRightAnswer(b, temp);
    }
}
