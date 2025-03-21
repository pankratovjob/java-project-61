package hexlet.code;

import java.util.Scanner;

class Cli {
    public static String askName() {
        System.out.println("Welcome to the Brain Games!");
        System.out.println("May I have your name?");
        Scanner console = new Scanner(System.in);
        String name = console.nextLine();
        System.out.println("Hello, " + name + "!");
        return name;
    }
}
