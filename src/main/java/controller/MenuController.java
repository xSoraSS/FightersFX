package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MenuController implements Initializable {

    @FXML
    private Button start, quit, d;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        start.setOnMouseEntered(event -> start.setGraphic(new ImageView("Assets/Menu/start_hover.png")));
        start.setOnMouseExited(event -> start.setGraphic(new ImageView("Assets/Menu/start.png")));
        quit.setOnMouseEntered(event -> quit.setGraphic(new ImageView("Assets/Menu/quit_hover.png")));
        quit.setOnMouseExited(event -> quit.setGraphic(new ImageView("Assets/Menu/quit.png")));
    }


    public void handleButtonAction(MouseEvent mouseEvent) throws IOException {
        Stage stage = null;
        AnchorPane root = null;

        if(mouseEvent.getSource()==start){
            stage = (Stage) start.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("fxml/characterSelect.fxml"));
            root = loader.load();
        }
        else if (mouseEvent.getSource()==d){

        }
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
