package hexlet.code.games;

import java.util.Random;
import hexlet.code.Engine;


public class Even {

    public static String getQuestion() {
        String questionText = "Answer 'yes' if the number is even, otherwise answer 'no'.";
        return questionText;
    }

    public static int playRound(String namePlayer, int correctAnswerCount) {
        Random random = new Random();
        final int countRightAnswer = 3;
        final int rangeForNumber = 100;
        int randomNumber = random.nextInt(rangeForNumber);
        String rightAnswer = (randomNumber % 2 == 0) ? "yes" : "no";
        String playerAnswer = Engine.askPlayerStringChoose(String.valueOf(randomNumber));


        correctAnswerCount = Engine.checkAnswer(namePlayer, playerAnswer, rightAnswer, correctAnswerCount);
        Engine.gamePlay(namePlayer, correctAnswerCount);
        return correctAnswerCount;
    }
}
