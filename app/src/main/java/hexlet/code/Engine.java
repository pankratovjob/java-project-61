package hexlet.code;

import java.util.Scanner;
import hexlet.code.games.Calc;
import hexlet.code.games.Even;
import hexlet.code.games.NOD;
import hexlet.code.games.Progression;
public class Engine {
    public static int askPlayerIntChoose() {
        Scanner console = new Scanner(System.in);
        int playerChoose = console.nextInt();
        return playerChoose;
    }

    public static String askPlayerStringChoose() {
        Scanner console = new Scanner(System.in);
        String playerChoose = console.nextLine();
        return playerChoose;
    }
    public static void start(int playerChoose) {

        if (playerChoose == 1) {
            Engine.askName();
        } else if (playerChoose == 2) {
            Even.startGame(askName());
        } else if (playerChoose == 3) {
            Calc.startGame(askName());
        } else if (playerChoose == 4) {
            NOD.startGame(askName());
        } else if (playerChoose == 5) {
            Progression.startGame(askName());
        }
    }
    public static String askName() {
        System.out.println("Welcome to the Brain Games!");
        System.out.println("May I have your name?");
        Scanner console = new Scanner(System.in);
        String name = console.nextLine();
        System.out.println("Hello, " + name + "!");
        return name;
    }

    public static void showQuestionText(String questionText) {
        System.out.println(questionText);
    };
    public static void showQuestion(int question) {
        System.out.println("Question: " + question);
    }

    public static void showQuestion(String question) {
        System.out.println("Question: " + question);
    }

    public static int showResultAnswer(boolean result, int correct, String playerChoose, String rightQuestion) {
        if (result) {
            System.out.println("Correct!");
            correct += 1;
        } else {
            System.out.println(playerChoose + " is wrong answer ;(. Correct answer was " + rightQuestion + ".");
            correct = 0;
        }
        return correct;
    }

    public static int showResultAnswer(boolean result, int correct, int playerChoose, int rightQuestion) {
        if (result) {
            System.out.println("Correct!");
            correct += 1;
        } else {
            System.out.println(playerChoose + " is wrong answer ;(. Correct answer was " + rightQuestion + ".");
            correct = 0;
        }
        return correct;
    }

    public static void showResultGame(boolean win, String name) {
        if (win) {
            System.out.println("Congratulations, " + name + "!");
        } else {
            System.out.println("Let's try again, " + name + "!");
        }
    }
}
