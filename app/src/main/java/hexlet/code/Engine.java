package hexlet.code;

import java.util.Scanner;

public class Engine {
    private static final int COUNTRIGHTANSWER = 3;
    private static final int RANGEFORNUMBER = 100;

    public static int getCountRightAnswer() {
        return COUNTRIGHTANSWER;
    }

    public static int getRangeForNumber() {
        return RANGEFORNUMBER;
    }
    public static String askNamePlayer() {
        System.out.println("Welcome to the Brain Games!");
        System.out.println("May I have your name?");
        Scanner console = new Scanner(System.in);
        String namePlayer = console.nextLine();
        System.out.println("Hello, " + namePlayer + "!");
        return namePlayer;
    }

    public static void showQuestionText(String questionText) {
        System.out.println(questionText);
    };

    public static void showQuestion(String question) {
        System.out.println("Question: " + question);
    }

    public static void askPlayerChoose() {
        int correctAnswerCount = 0;
        Scanner console = new Scanner(System.in);
        String playerChoose = console.nextLine();
        System.out.println("Your choice: " + playerChoose);
        App.start(playerChoose, correctAnswerCount);
        //return playerChoose;
    }

    public static String askPlayerStringChoose(String expression) {
        showQuestion(expression);
        Scanner console = new Scanner(System.in);
        String playerChoose = console.nextLine();
        return playerChoose;
    }
    public static int checkAnswer(String namePlayer, String playerAnswer, String rightAnswer, int correctAnswerCount) {
        if (playerAnswer.equals(rightAnswer)) {
            return showResultAnswer(namePlayer, true, correctAnswerCount, playerAnswer, rightAnswer);
        } else {
            return showResultAnswer(namePlayer, false, correctAnswerCount, playerAnswer, rightAnswer);
        }
    }

    public static boolean gamePlay(String namePlayer, int correctAnswerCount) {

        while (correctAnswerCount >= 0 && correctAnswerCount < getCountRightAnswer()) {
            return true;
        }

        return false;
    }

    public static int showResultAnswer(
            String name,
            boolean result,
            int correctAnswerCount,
            String playerChoose,
            String rightAnswer
    ) {
        if (result) {
            System.out.println("Correct!");
            correctAnswerCount += 1;
        } else {
            System.out.println(playerChoose + " is wrong answer ;(. Correct answer was " + rightAnswer + ".");
            correctAnswerCount = -1;

        }
        return correctAnswerCount;
    }
    public static void showResultGame(boolean win, String namePlayer) {
        if (win) {
            System.out.println("Congratulations, " + namePlayer + "!");
        } else {
            System.out.println("Let's try again, " + namePlayer + "!");
        }
    }

}
