package controller;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
    private Button back, confirm;
    @FXML
    private ToggleButton aries, kratos;


    private String p1, p2;
    private Stage stage;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        p1="";
        p2="";

        stage = StageManager.getStage();


        back.setOnMouseEntered(event -> back.setGraphic(new ImageView("Assets/back_hover.png")));
        back.setOnMouseExited(event -> back.setGraphic(new ImageView("Assets/back.png")));

        confirm.setOnMouseEntered(event -> confirm.setGraphic(new ImageView("Assets/confirm_hover.png")));
        confirm.setOnMouseExited(event -> confirm.setGraphic(new ImageView("Assets/confirm.png")));
        confirm.setOnAction(event -> {
//            setCharacter(this.player1Char, this.player2Char);
//            arena.setPlayer1(this.player1);
//            arena.setPlayer2(this.player2);
//            stage.setScene(this.arenaInfo.getArenaSelectScene());
        });
        confirm.setVisible(false);


        aries.setOnMouseEntered(event -> aries.setGraphic(new ImageView("Assets/Aries/AriesMPunch.gif")));
        aries.setOnMouseExited(event -> aries.setGraphic(new ImageView("Assets/Aries/AriesStance.gif") ));



        kratos.setOnMouseEntered(event -> kratos.setGraphic(new ImageView("Assets/Kratos/KratosHPunch.gif")));
        kratos.setOnMouseExited(event -> kratos.setGraphic(new ImageView("Assets/Kratos/KratosStance.gif") ));

    }

    public void backmenu(MouseEvent mouseEvent) throws IOException {
        Parent root = FXMLLoader.load(Thread.currentThread().getContextClassLoader().getResource("fxml/menu.fxml"));
        stage.setScene(new Scene(root));
        stage.show();
    }

    public void Select(MouseEvent mouseEvent) {

        if (aries.isSelected() && this.p1.equals("") && this.p2.equals(""))
        {
            aries.setText("Aries - Player 1");
            this.p1 = "Aries";

        }
        else if (aries.isSelected() && !this.p1.equals("") &&
                !this.p1.equals("Aries") && this.p2.equals(""))
        {
            aries.setText("Aries - Player 2");
            this.p2 = "Aries";
        }
        else if (!aries.isSelected() && !this.p1.equals("") &&
                this.p2.equals("Aries"))
        {
            aries.setText("Aries");
            this.p2 = "";
        }
        else if (!aries.isSelected() && this.p1.equals("Aries") &&
                this.p2.equals(""))
        {
            aries.setText("Aries");
            this.p1 = "";
        }

        if (kratos.isSelected() && this.p1.equals("") && this.p2.equals(""))
        {
            kratos.setText("Kratos - Player 1");
            this.p1 = "Kratos";

        }
        else if (kratos.isSelected() && !this.p1.equals("") && !this.p1.equals
                ("Kratos") && this.p2.equals(""))
        {
            kratos.setText("Kratos - Player 2");
            this.p2 = "Kratos";
        }
        else if (!kratos.isSelected() && !this.p1.equals("") && this.p2.equals
                ("Kratos"))
        {
            kratos.setText("Kratos");
            this.p2 = "";
        }
        else if (!kratos.isSelected() && this.p1.equals("Kratos") &&
                this.p2.equals(""))
        {
            kratos.setText("Kratos");
            this.p1 = "";
        }

        if(!this.p1.equals("") && !this.p2.equals(""))
        {
            confirm.setVisible(true);
        }
        else
        {
            confirm.setVisible(false);
        }
    }
}
