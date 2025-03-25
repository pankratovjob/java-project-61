package hexlet.code.games;

import hexlet.code.Engine;
import java.util.Map;

public class Cli {
    public static String askNamePlayer() {


        Map<String, String> env = System.getenv();

        for (String envName : env.keySet()) {
            System.out.format("%s=%s%n", envName,
                    env.get(envName));
        }


        return Engine.askNamePlayer();
    }
}
