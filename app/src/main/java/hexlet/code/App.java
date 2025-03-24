package hexlet.code;

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
        String playerChoose = Engine.askPlayerChoose();
        Engine.start(playerChoose);
/*
        for (var game: games) {
            if (playerChoose.equals(game[0])) {
                var dddd = game[1];
                dddd.startGame(Engine.askNamePlayer());
            }
        }

 */

    }
}
