package hexlet.code;

import java.util.Scanner;
import hexlet.code.games.Calc;
import hexlet.code.games.Even;
import hexlet.code.games.NOD;
import hexlet.code.games.Progression;
import hexlet.code.games.Prime;
public class Engine {

    public static int askPlayerNameChoose() {
        Scanner console = new Scanner(System.in);
        int playerChoose = console.nextInt();
        return playerChoose;
    }
    public static int askPlayerIntChoose(String question) {
        showQuestion(question);
        Scanner console = new Scanner(System.in);
        int playerChoose = console.nextInt();
        return playerChoose;
    }

    public static String askPlayerStringChoose(int question) {
        showQuestion(question);
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
        } else if (playerChoose == 6) {
            Prime.startGame(askName());
        } esle {
            break;
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

    public static int showResultAnswer(
            String name,
            boolean result,
            int correct,
            String playerChoose,
            String rightQuestion
    ) {
        if (result) {
            System.out.println("Correct!");
            correct += 1;
        } else {
            System.out.println(playerChoose + " is wrong answer ;(. Correct answer was " + rightQuestion + ".");
            correct = -1;

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

    public static int checkAnswer(String name, String playerAnswer, String rightAnswer, int correct) {
        if (playerAnswer.equals(rightAnswer)) {
            return showResultAnswer(name, true, correct, playerAnswer, rightAnswer);
        } else {
            return showResultAnswer(name, false, correct, playerAnswer, rightAnswer);
        }
    }
}
