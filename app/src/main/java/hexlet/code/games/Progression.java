package  hexlet.code.games;

import hexlet.code.Engine;
import java.util.Random;
//import java.util.Arrays;

public class Progression {
    public static void startGame(String namePlayer) {
        String questionText = "What number is missing in the progression?";
        int correctAnswerCount = 0;
        Random randomOperand = new Random();
        Engine.showQuestionText(questionText);
        int[] numbers = new int[10];
        String[] numbersString = new String[10];
        int rangeForNumber = 9;
        int rangeForSteps = 10;
        int rangeForStratNumber = 100;

        do {
            int randomNumber = randomOperand.nextInt(rangeForNumber); // число маскирования
            int randomIncrement = randomOperand.nextInt(rangeForSteps);  // число шага
            numbers[0] = randomOperand.nextInt(rangeForStratNumber); // число старта
            numbersString[0] = String.valueOf(numbers[0]);

            for (var i = 0; i < numbers.length - 1; i++) {
                numbers[i + 1] = numbers[i] + randomIncrement;
                numbersString[i + 1] = String.valueOf(numbers[i + 1]);
            }

            String rightAnswer = String.valueOf(numbers[randomNumber]);
            numbersString[randomNumber] = "..";

            //String expression = Arrays.toString(numbersString);
            String expression = toStringArr(numbers, randomNumber);
            String playerAnswer = Engine.askPlayerStringChoose(expression);

            correctAnswerCount = Engine.checkAnswer(namePlayer, playerAnswer, rightAnswer, correctAnswerCount);

        } while (correctAnswerCount >= 0 && correctAnswerCount < Engine.attempt);

        Engine.showResultGame((correctAnswerCount >= Engine.attempt), namePlayer);
    }

    private static String toStringArr(int[] arr, int randomNumber) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            if (i == randomNumber) {
                stringBuilder.append(".. ");
            } else {
                stringBuilder.append(arr[i] + " ");
            }
        }
        //String joinedString = stringBuilder.toString();
        return stringBuilder.toString();
    }
}
