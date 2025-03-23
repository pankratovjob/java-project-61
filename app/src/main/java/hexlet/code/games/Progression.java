package  hexlet.code.games;

import hexlet.code.Engine;
import java.util.Random;
import java.util.Arrays;

public class Progression {
    public static void startGame(String name) {
        String questionText = "What number is missing in the progression?";
        int correct = 0;
        Random randomOperand = new Random();
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

            String rightAnswer = String.valueOf(numbers[randomNumber]);
            numbersString[randomNumber] = "..";

            String primer = Arrays.toString(numbersString);
            String playerAnswer = String.valueOf(Engine.askPlayerIntChoose(primer));

            correct = Engine.checkAnswer(name, playerAnswer, rightAnswer, correct);

        } while (correct >= 0 && correct < 3);

        Engine.showResultGame((correct >= 3), name);
    }
}
