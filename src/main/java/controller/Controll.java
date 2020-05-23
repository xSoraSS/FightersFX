package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import uti.StageManager;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controll implements Initializable {

    @FXML
    private Button back;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        back.setOnMouseEntered(event -> back.setGraphic(new ImageView("Assets/back_hover.png")));
        back.setOnMouseExited(event -> back.setGraphic(new ImageView("Assets/back.png")));
    }

    public void backmenu(MouseEvent mouseEvent) throws IOException {
        Parent root = FXMLLoader.load(Thread.currentThread().getContextClassLoader().getResource("fxml/menu.fxml"));
        StageManager.stage.setScene(new Scene(root));
        StageManager.stage.show();
    }
}
