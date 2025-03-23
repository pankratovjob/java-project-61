package hexlet.code.games;

import java.util.Random;
import hexlet.code.Engine;
public class Calc {
    public static void startGame(String name) {
        String questionText = "What is the result of the expression?";
        char[] arrChar = {'+', '-', '*'};
        int correct = 0;
        String rightAnswer = "";
        Random randomOperand = new Random();

        Engine.showQuestionText(questionText);

        do {
            int numOne = randomOperand.nextInt(100);
            int numTwo = randomOperand.nextInt(100);
            char oper = arrChar[randomOperand.nextInt(3)];

            if (oper == '-') {
                rightAnswer = String.valueOf(numOne - numTwo);
            } else if (oper == '*') {
                rightAnswer = String.valueOf(numOne * numTwo);
            } else if (oper == '+') {
                rightAnswer = String.valueOf(numOne + numTwo);
            }

            String primer = "" + numOne + " " + oper + " " + numTwo;

            String playerAnswer = String.valueOf(Engine.askPlayerIntChoose(primer));

            correct = Engine.checkAnswer(name, playerAnswer, rightAnswer, correct);

        } while (correct >= 0 && correct < 3);

        Engine.showResultGame((correct >= 3), name);

    }
}
