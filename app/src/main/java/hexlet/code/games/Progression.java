package  hexlet.code.games;

import hexlet.code.Engine;
import java.util.Random;
//import java.util.Arrays;

public class Progression {
    public static void startGame(String namePlayer) {
        final int countRightAnswer = 3;
        String questionText = "What number is missing in the progression?";
        int correctAnswerCount = 0;
        Random randomOperand = new Random();
        Engine.showQuestionText(questionText);
        final int rangeForNumber = 9;
        final int rangeForSteps = 10;
        final int rangeForStartNumber = 100;
        int[] numbers = new int[rangeForSteps];

        do {
            int randomNumber = randomOperand.nextInt(rangeForNumber); // число маскирования
            int randomIncrement = randomOperand.nextInt(rangeForSteps);  // число шага
            numbers[0] = randomOperand.nextInt(rangeForStartNumber); // число старта

            for (var i = 0; i < numbers.length - 1; i++) {
                numbers[i + 1] = numbers[i] + randomIncrement;
            }

            String rightAnswer = String.valueOf(numbers[randomNumber]);
            String expression = toStringArr(numbers, randomNumber);
            String playerAnswer = Engine.askPlayerStringChoose(expression);

            correctAnswerCount = Engine.checkAnswer(namePlayer, playerAnswer, rightAnswer, correctAnswerCount);

        } while (correctAnswerCount >= 0 && correctAnswerCount < countRightAnswer);

        Engine.showResultGame((correctAnswerCount >= countRightAnswer), namePlayer);
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
        return stringBuilder.toString();
    }
}
