package hexlet.code.games;

import java.util.Random;
import hexlet.code.Engine;
public class Calc {
    public static void startGame(String namePlayer) {
        String questionText = "What is the result of the expression?";
        char[] arrChar = {'+', '-', '*'};
        int correctAnswerCount = 0;
        Random randomOperand = new Random();

        Engine.showQuestionText(questionText);

        do {
            int numOne = randomOperand.nextInt(100);
            int numTwo = randomOperand.nextInt(100);
            char oper = arrChar[randomOperand.nextInt(3)];

            String rightAnswer = getRightAnswer(oper, numOne, numTwo);
            String expression = "" + numOne + " " + oper + " " + numTwo;
            String playerAnswer = Engine.askPlayerStringChoose(expression);
            correctAnswerCount = Engine.checkAnswer(namePlayer, playerAnswer, rightAnswer, correctAnswerCount);

        } while (correctAnswerCount >= 0 && correctAnswerCount < Engine.attempt);

        Engine.showResultGame((correctAnswerCount >= Engine.attempt), namePlayer);

    }
    private static String getRightAnswer(char oper, int numOne, int numTwo) {
        int rightAnswer = 0;
        if (oper == '-') {
            rightAnswer = numOne - numTwo;
        } else if (oper == '*') {
            rightAnswer = numOne * numTwo;
        } else if (oper == '+') {
            rightAnswer = numOne + numTwo;
        }
        return String.valueOf(rightAnswer);
    }

}
