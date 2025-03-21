package hexlet.code.games;

import java.util.Scanner;
import java.util.Random;
import hexlet.code.Engine;
public class Calc {
    public static void startGame() {
        String name = Engine.askName();
        String questionText = "What is the result of the expression?";
        char[] arrChar = {'+', '-', '*'};
        int correct = 0;
        int rightAnswer = 0;
        Random randomOperand = new Random();
        Scanner console = new Scanner(System.in);

        do {
            int numOne = randomOperand.nextInt(100);
            int numTwo = randomOperand.nextInt(100);
            char oper = arrChar[randomOperand.nextInt(3)];
            if(oper == '-') {
                rightAnswer = numOne - numTwo;
            } else if (oper == '*') {
                rightAnswer = numOne * numTwo;
            } else if (oper == '+') {
                rightAnswer = numOne + numTwo;
            }
            String primer = "" + numOne + " " + oper + " " + numTwo;

            Engine.showQuestion(primer, questionText);

            int playerAnswer = console.nextInt();

            if (playerAnswer == rightAnswer) {
                correct = Engine.showResultAnswer(true, correct, playerAnswer, rightAnswer);
            } else {
                correct = Engine.showResultAnswer(false, correct, playerAnswer, rightAnswer);
                break;
            }
        } while (correct < 3);

        Engine.showResultGame(true, name);

    }
}