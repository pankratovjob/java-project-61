package  hexlet.code.games;

import hexlet.code.Engine;
import java.util.Random;
//import java.util.Arrays;

public class Progression {

    public static String getQuestion() {
        String questionText = "What number is missing in the progression?";
        return questionText;
    }

    public static int playRound(String namePlayer, int correctAnswerCount) {
        Random randomOperand = new Random();
        final int rangeForNumber = 9;
        final int rangeForSteps = 10;
        int[] numbers = new int[rangeForSteps];
        int randomNumber = randomOperand.nextInt(rangeForNumber); // число маскирования
        int randomIncrement = randomOperand.nextInt(rangeForSteps);  // число шага
        numbers[0] = randomOperand.nextInt(Engine.getRangeForNumber()); // число старта

        for (var i = 0; i < numbers.length - 1; i++) {
            numbers[i + 1] = numbers[i] + randomIncrement;
        }

        String rightAnswer = String.valueOf(numbers[randomNumber]);
        String expression = toStringArr(numbers, randomNumber);
        String playerAnswer = Engine.askPlayerStringChoose(expression);

        correctAnswerCount = Engine.checkAnswer(namePlayer, playerAnswer, rightAnswer, correctAnswerCount);
        Engine.gamePlay(namePlayer, correctAnswerCount);
        return correctAnswerCount;
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
