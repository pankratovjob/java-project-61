package hexlet.code;

import hexlet.code.games.Calc;
import hexlet.code.games.Even;
import hexlet.code.games.NOD;
import hexlet.code.games.Progression;
import hexlet.code.games.Prime;


class App {
    public static void main(String[] args) {
        System.out.println("Please enter the game number and press Enter.");
        String[][] games = {
                {"1", "Greet"},
                {"2", "Even"},
                {"3", "Calc"},
                {"4", "NOD"},
                {"5", "Progression"},
                {"6", "Prime"},
                {"0", "Exit"}
            };
        for (var game: games) {
            System.out.println(game[0] + " - " + game[1]);
        }

        Engine.askPlayerChoose();
    }
    public static void start(String playerChoose, int correctAnswerCount) {

        String namePlayer = Engine.askNamePlayer();

        if (playerChoose.equals("1")) {
            System.exit(0);

        } else if (playerChoose.equals("2")) {
            Engine.showQuestionText(Even.getQuestion());
            do {
                correctAnswerCount = Even.playRound(namePlayer, correctAnswerCount);
            } while (Engine.gamePlay(namePlayer, correctAnswerCount));

        } else if (playerChoose.equals("3")) {
            Engine.showQuestionText(Calc.getQuestion());
            do {
                correctAnswerCount = Calc.playRound(namePlayer, correctAnswerCount);
            } while (Engine.gamePlay(namePlayer, correctAnswerCount));

        } else if (playerChoose.equals("4")) {
            Engine.showQuestionText(NOD.getQuestion());
            do {
                correctAnswerCount = NOD.playRound(namePlayer, correctAnswerCount);
            } while (Engine.gamePlay(namePlayer, correctAnswerCount));

        } else if (playerChoose.equals("5")) {
            Progression.startGame(Engine.askNamePlayer());

        } else if (playerChoose.equals("6")) {
            Engine.showQuestionText(Prime.getQuestion());
            do {
                correctAnswerCount = Prime.playRound(namePlayer, correctAnswerCount);
            } while (Engine.gamePlay(namePlayer, correctAnswerCount));

        } else {
            System.exit(0);
        }

    }
}
