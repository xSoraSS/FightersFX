package controller;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import uti.StageManager;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MenuController implements Initializable {

    @FXML
    private Button start, quit;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        start.setOnMouseEntered(event -> start.setGraphic(new ImageView("Assets/Menu/start_hover.png")));
        start.setOnMouseExited(event -> start.setGraphic(new ImageView("Assets/Menu/start.png")));

        quit.setOnAction(event -> System.exit(0));
        quit.setOnMouseEntered(event -> quit.setGraphic(new ImageView("Assets/Menu/quit_hover.png")));
        quit.setOnMouseExited(event -> quit.setGraphic(new ImageView("Assets/Menu/quit.png")));
    }


    public void startselectcharacter(MouseEvent mouseEvent) throws IOException {
        Stage stage = StageManager.getStage();
        Parent root = FXMLLoader.load(Thread.currentThread().getContextClassLoader().getResource("fxml/characterSelect.fxml"));
        stage.setScene(new Scene(root));
        stage.show();
    }
}
