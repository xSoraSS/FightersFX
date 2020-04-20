package uti;

import javafx.stage.Stage;
import model.Player;

import java.util.HashMap;
import java.util.Map;

public class StageManager {

    public static Stage stage;

    private static Player player1, player2;

    public static Player getPlayer1() {
        return player1;
    }

    public static void setPlayer1(Player player1) {
        StageManager.player1 = player1;
    }

    public static Player getPlayer2() {
        return player2;
    }

    public static void setPlayer2(Player player2) {
        StageManager.player2 = player2;
    }
}
