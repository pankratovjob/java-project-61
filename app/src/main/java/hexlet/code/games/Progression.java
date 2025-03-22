package  hexlet.code.games;

import hexlet.code.Engine;
import java.util.Random;
import java.util.Arrays;

public class Progression {
    public static void startGame(String name) {
        String questionText = "What number is missing in the progression?";
        int correct = 0;
        Random randomOperand = new Random();
        boolean win = false;
        Engine.showQuestionText(questionText);
        int[] numbers = new int[10];
        String[] numbersString = new String[10];

        do {
            int randomNumber = randomOperand.nextInt(9); // число маскирования
            int randomIncrement = randomOperand.nextInt(10);  // число шага
            numbers[0] = randomOperand.nextInt(100); // число старта
            numbersString[0] = String.valueOf(numbers[0]);

            for (var i = 0; i < numbers.length - 1; i++) {
                numbers[i + 1] = numbers[i] + randomIncrement;
                numbersString[i + 1] = String.valueOf(numbers[i + 1]);
            }

            int rightAnswer = numbers[randomNumber];
            numbersString[randomNumber] = "..";

            Engine.showQuestion(Arrays.toString(numbersString));
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
}
