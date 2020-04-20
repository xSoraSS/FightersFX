package controller;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import uti.StageManager;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CharacterSelectController implements Initializable   {
    @FXML
    private Button back;
    @FXML
    private ToggleButton aries, kratos;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        back.setOnMouseEntered(event -> back.setGraphic(new ImageView("Assets/back_hover.png")));
        back.setOnMouseExited(event -> back.setGraphic(new ImageView("Assets/back.png")));


        aries.setOnMouseEntered(event -> aries.setGraphic(new ImageView("Assets/Aries/AriesMPunch.gif")));
        aries.setOnMouseExited(event -> aries.setGraphic(new ImageView("Assets/Aries/AriesStance.gif") ));


        kratos.setOnMouseEntered(event -> kratos.setGraphic(new ImageView("Assets/Kratos/KratosHPunch.gif")));
        kratos.setOnMouseExited(event -> kratos.setGraphic(new ImageView("Assets/Kratos/KratosStance.gif") ));

    }

    public void backmenu(MouseEvent mouseEvent) throws IOException {
        Stage stage = StageManager.getStage();
        Parent root = FXMLLoader.load(Thread.currentThread().getContextClassLoader().getResource("fxml/menu.fxml"));
        stage.setScene(new Scene(root));
        stage.show();
    }
}
