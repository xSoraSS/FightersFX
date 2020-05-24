package controller;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.AudioClip;
import uti.StageManager;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class MenuController implements Initializable {

    @FXML
    private Button start, quit, controls, platform;

    private AudioClip mainMenu;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        mainMenu =  new AudioClip(new File("src/main/resources/Audio/Effects/mainMenu.wav").toURI().toString());
        mainMenu.play();
        mainMenu.setVolume(20);

        platform.setOnMouseEntered(event -> platform.setGraphic(new ImageView("Assets/Menu/adventure_hover.png")));
        platform.setOnMouseExited(event -> platform.setGraphic(new ImageView("Assets/Menu/adventure.png")));

        start.setOnMouseEntered(event -> start.setGraphic(new ImageView("Assets/Menu/start_hover.png")));
        start.setOnMouseExited(event -> start.setGraphic(new ImageView("Assets/Menu/start.png")));

        controls.setOnMouseEntered(event -> controls.setGraphic(new ImageView("Assets/Menu/control_hover.png")));
        controls.setOnMouseExited(event -> controls.setGraphic(new ImageView("Assets/Menu/control.png")));

        quit.setOnAction(event -> System.exit(0));
        quit.setOnMouseEntered(event -> quit.setGraphic(new ImageView("Assets/Menu/quit_hover.png")));
        quit.setOnMouseExited(event -> quit.setGraphic(new ImageView("Assets/Menu/quit.png")));
    }


    public void startselectcharacter(MouseEvent mouseEvent) throws IOException {
        mainMenu.stop();
        Parent root = FXMLLoader.load(Objects.requireNonNull(Thread.currentThread().getContextClassLoader().getResource("fxml/characterSelect.fxml")));
        StageManager.stage.setScene(new Scene(root));
        StageManager.stage.show();
    }

    public void startplatformlevels(MouseEvent mouseEvent) throws IOException {
        mainMenu.stop();
        Parent root = FXMLLoader.load(Objects.requireNonNull(Thread.currentThread().getContextClassLoader().getResource("fxml/platformLevel1.fxml")));
        StageManager.stage.setScene(new Scene(root));
        StageManager.stage.show();
    }

    public void startcontrolls(MouseEvent mouseEvent) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(Thread.currentThread().getContextClassLoader().getResource("fxml/controlls.fxml")));
        StageManager.stage.setScene(new Scene(root));
        StageManager.stage.show();
    }

}
