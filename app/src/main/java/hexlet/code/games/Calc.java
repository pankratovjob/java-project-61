package hexlet.code.games;

import java.util.Random;
import hexlet.code.Engine;
public class Calc {

    public static String getQuestion() {
        String questionText = "What is the result of the expression?";
        return questionText;
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

    public static int playRound(String namePlayer, int correctAnswerCount) {
        Random randomOperand = new Random();
        final int countRightAnswer = 3;
        final int rangeForNumber = 100;
        char[] arrChar = {'+', '-', '*'};
        int numOne = randomOperand.nextInt(rangeForNumber);
        int numTwo = randomOperand.nextInt(rangeForNumber);
        char oper = arrChar[randomOperand.nextInt(arrChar.length - 1)];

        String rightAnswer = getRightAnswer(oper, numOne, numTwo);
        String expression = "" + numOne + " " + oper + " " + numTwo;
        String playerAnswer = Engine.askPlayerStringChoose(expression);

        Engine.gamePlay(namePlayer, correctAnswerCount);
        correctAnswerCount = Engine.checkAnswer(namePlayer, playerAnswer, rightAnswer, correctAnswerCount);
        return correctAnswerCount;

    }

}
