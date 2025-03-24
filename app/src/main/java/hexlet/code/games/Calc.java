package hexlet.code.games;

import java.util.Random;
import hexlet.code.Engine;
public class Calc {
    public static void startGame(String namePlayer) {
        final int countRightAnswer = 3;
        final int rangeForNumber = 100; //Диапазон для рандома чисел в вопросе
        String questionText = "What is the result of the expression?";
        char[] arrChar = {'+', '-', '*'};
        int correctAnswerCount = 0;
        Random randomOperand = new Random();
        Engine.showQuestionText(questionText);

        do {
            int numOne = randomOperand.nextInt(rangeForNumber);
            int numTwo = randomOperand.nextInt(rangeForNumber);
            char oper = arrChar[randomOperand.nextInt(arrChar.length - 1)];

            String rightAnswer = getRightAnswer(oper, numOne, numTwo);
            String expression = "" + numOne + " " + oper + " " + numTwo;
            String playerAnswer = Engine.askPlayerStringChoose(expression);
            correctAnswerCount = Engine.checkAnswer(namePlayer, playerAnswer, rightAnswer, correctAnswerCount);

        } while (correctAnswerCount >= 0 && correctAnswerCount < countRightAnswer);

        Engine.showResultGame((correctAnswerCount >= countRightAnswer), namePlayer);

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
