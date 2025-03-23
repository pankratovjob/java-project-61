package hexlet.code;

import java.util.Scanner;
import hexlet.code.games.Calc;
import hexlet.code.games.Even;
import hexlet.code.games.NOD;
import hexlet.code.games.Progression;
import hexlet.code.games.Prime;
public class Engine {
    public static int attempt = 3;

    public static int askPlayerChoose() {
        Scanner console = new Scanner(System.in);
        int playerChoose = console.nextInt();
        System.out.println("Your choice: " + playerChoose);
        return playerChoose;
    }

    public static void start(int playerChoose) {

        if (playerChoose == 1) {
            Engine.askNamePlayer();
        } else if (playerChoose == 2) {
            Even.startGame(askNamePlayer());
        } else if (playerChoose == 3) {
            Calc.startGame(askNamePlayer());
        } else if (playerChoose == 4) {
            NOD.startGame(askNamePlayer());
        } else if (playerChoose == 5) {
            Progression.startGame(askNamePlayer());
        } else if (playerChoose == 6) {
            Prime.startGame(askNamePlayer());
        } else {
            System.exit(0);
        }
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
