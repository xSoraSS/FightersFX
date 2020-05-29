package controller;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;
import model.Aries;
import model.Kratos;
import model.Player;
import uti.StageManager;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CharacterSelectController implements Initializable   {
    @FXML
    private Button back, confirm;
    @FXML
    private ToggleButton aries, kratos;


    private String p1, p2;
    private Player player1 , player2;

    private AudioClip cSelect;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        cSelect = new AudioClip(new File("src/main/resources/Audio/Effects/characterSelect.wav").toURI().toString());
        cSelect.play();
        cSelect.setVolume(20);
        p1="";
        p2="";



        back.setOnMouseEntered(event -> back.setGraphic(new ImageView("Assets/back_hover.png")));
        back.setOnMouseExited(event -> back.setGraphic(new ImageView("Assets/back.png")));

        confirm.setOnMouseEntered(event -> confirm.setGraphic(new ImageView("Assets/confirm_hover.png")));
        confirm.setOnMouseExited(event -> confirm.setGraphic(new ImageView("Assets/confirm.png")));
        confirm.setVisible(false);


        aries.setOnMouseEntered(event -> aries.setGraphic(new ImageView("Assets/Aries/AriesMPunch.gif")));
        aries.setOnMouseExited(event -> aries.setGraphic(new ImageView("Assets/Aries/AriesStance.gif") ));



        kratos.setOnMouseEntered(event -> kratos.setGraphic(new ImageView("Assets/Kratos/KratosHPunchR.gif")));
        kratos.setOnMouseExited(event -> kratos.setGraphic(new ImageView("Assets/Kratos/KratosStanceRight.gif") ));

    }

    public void backmenu(MouseEvent mouseEvent) throws IOException {
        cSelect.stop();
        Parent root = FXMLLoader.load(Thread.currentThread().getContextClassLoader().getResource("fxml/menu.fxml"));
        StageManager.stage.setScene(new Scene(root));
        StageManager.stage.show();
    }

    public void Select(MouseEvent mouseEvent) {

        if (aries.isSelected()){
            if (this.p1.equals("") && this.p2.equals("")){
                aries.setText("Aries - Player 1");
                this.p1 = "Aries";
            }else if (!this.p1.equals("") &&
                    !this.p1.equals("Aries") && this.p2.equals(""))
            {
                aries.setText("Aries - Player 2");
                this.p2 = "Aries";
            }else if (p1.equals("")){
                aries.setText("Aries - Player 1");
                this.p1 = "Aries";
            }
        }
        if (!aries.isSelected()){
            if (p1.equals("Aries")){
                aries.setText("Aries");
                p1="";
            }else if (p2.equals("Aries")){
                aries.setText("Aries");
                p2="";
            }
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

    public void setCharacter(String p1, String p2)
    {
        /**
         * Dependiendo del personaje que haya elegido el jugador previamente, se instaciará un objeto.
         */
        if(p1.equals("Kratos"))
        {
            this.player1 = new Kratos();
        }
        else if(p2.equals("Kratos"))
        {
            this.player2 = new Kratos();
        }
        if(p1.equals("Aries"))
        {
            this.player1 = new Aries();
        }
        else if(p2.equals("Aries"))
        {
            this.player2 = new Aries();
        }
    }

    public void Confirm(MouseEvent mouseEvent) throws IOException {
        setCharacter(this.p1, this.p2);
        StageManager.setPlayer1(this.player1);
        StageManager.setPlayer2(this.player2);

        cSelect.stop();
        Parent root = FXMLLoader.load(Thread.currentThread().getContextClassLoader().getResource("fxml/battle.fxml"));
        StageManager.stage.setScene(new Scene(root));
        StageManager.stage.show();
    }
}
