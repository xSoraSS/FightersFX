package controller;

import javafx.animation.Transition;
import javafx.animation.TranslateTransition;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;
import model.Player;
import uti.StageManager;

import java.net.URL;
import java.util.ResourceBundle;

public class ArenaController implements Initializable {
    @FXML
    private Rectangle p1HealthBar, p2HealthBar;
    @FXML
    private ImageView p1,p2;

    private Player player1, player2;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        player1 = StageManager.getPlayer1();
        player2 = StageManager.getPlayer2();

        p1.setImage(this.player1.getImageFighterStanceL());
        p2.setImage(this.player2.getImageFighterStanceR());


        p1HealthBar.setWidth(200);
        p2HealthBar = player2.getHealthBar();

    }

}
