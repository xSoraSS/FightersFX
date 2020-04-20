package uti;

import javafx.stage.Stage;

import java.util.HashMap;
import java.util.Map;

public class StageManager {

    public static Stage stage;

    public static Stage getStage() {
        return stage;
    }

    public static void setStage(Stage stage) {
        StageManager.stage = stage;
    }
}
