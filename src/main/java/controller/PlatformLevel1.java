package controller;

import javafx.animation.AnimationTimer;
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

import javafx.util.Duration;
import model.Aries;
import model.Player;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * MOVIMIENTO PERSONAJE SOLUCIONAR
 */

public class PlatformLevel1 implements Initializable {

    @FXML
    private ImageView playerImage, bgImage, floorImage, platformImage, columnImage;
    private Image backGround = new Image("Assets/Level/Background.png"), floor = new Image("Assets/Level/suelo.png"), platform = new Image("Assets/Level/plataformaAltura.png"), column = new Image("Assets/Level/columna.png");

    private Player player;

    private Boolean pJumpAction = false;
    private Boolean pPunchAction = false;
    private Boolean pKickAction = false;

    private BooleanProperty dPressed = new SimpleBooleanProperty();
    private BooleanProperty aPressed = new SimpleBooleanProperty();
    private BooleanProperty wPressed = new SimpleBooleanProperty();
    private BooleanProperty sPressed = new SimpleBooleanProperty();
    private BooleanProperty cPressed = new SimpleBooleanProperty();

    CollisionController collisionChecker;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        /**
         * Jugador
         */
        this.player = new Aries();
        playerImage.setImage(this.player.getImageFighterStanceL());
        playerImage.setFitHeight(80);
        playerImage.setFitWidth(80);
        playerImage.setX(100);
        playerImage.setY(680);
        bgImage.setImage(backGround);
        /**
         * SUELOS
         */
        floorImage.setImage(floor);
        floorImage.setFitWidth(floor.getWidth());
        floorImage.setFitHeight(floor.getHeight());
        /**
         * PLATAFORMAS FLOTANTES
         */
        platformImage.setImage(platform);
        platformImage.setFitWidth(platform.getWidth());
        platformImage.setFitHeight(platform.getHeight());
        platformImage.setY(544);
        /**
         * COLUMNAS
         */
        columnImage.setImage(column);
        columnImage.setFitWidth(column.getWidth());
        columnImage.setFitHeight(column.getHeight());

        /**
         * Comprobador de colisiones.
         */
        collisionChecker = new CollisionController(playerImage, bgImage, floorImage, platformImage, columnImage);

        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                if (dPressed.get() && playerImage.getX() <= 1200 - playerImage.getImage().getWidth())
                /**
                 * Animación ejecutada al pulsar la tecla "D".
                 */
                {
                    playerImage.setX((playerImage.getX() + 5));
                }

                /**
                 * Animación ejecutada al pulsar la tecla "A".
                 */
                if (aPressed.get() && playerImage.getX() >= 0) {

                    playerImage.setX((playerImage.getX() - 5));
                }
            }
        };

        /**
         * Listeners que comprueban si el estado del boolean property en cuestión cambia, es decir, si la tecla deja de estar presionada.
         */
        dPressed.addListener((obs, wasPressed, nowPressed) ->
        {
            if (dPressed.get()) // Si la tecla "D" está presionada se incia la animación.
            {
                timer.start();
            } else if (!dPressed.get()){ // Si deja de estar presionada vuelve a su estado normal.
                playerImage.setImage(player.getImageFighterStanceL());
            }
        });

        aPressed.addListener((obs, wasPressed, nowPressed) ->
        {
            if (aPressed.get()) { // Si la tecla "A" está presionada se incia la animación.
                timer.start();
            } else if (!aPressed.get()) {// Si deja de estar presionada vuelve a su estado normal.
                playerImage.setImage(player.getImageFighterStanceL());
            }
        });
    }

    public void da(KeyEvent e) {
        collisionChecker.emptyColCheck();
        if (player.getHealth() > 0) {

            /**
             * El jugador se mueve en horizontal hacía la derecha cuando se presiona la tecla "D".
             * Se realizan ciertas comprobaciones para este movimiento, como que el jugador no esté golpeando o dando una patada mientras está en movimiento.
             */
            if (e.getCode() == KeyCode.D && !pPunchAction && !pKickAction) {
                playerImage.setImage(player.getImageFighterForwardL()); // El personaje en la pantalla cambia su gif, o animación, al movimiento hacía delante.
                dPressed.set(true);
            }

            /**
             * El jugador se mueve en horizontal hacía la izquierda cuando se presiona la tecla "A".
             * Se realizan las mismas comprobaciones.
             */
            if (e.getCode() == KeyCode.A && !pPunchAction && !pKickAction) {
                playerImage.setImage(player.getImageFighterBackwardL()); // El personaje en la pantalla cambia su gif, o animación, al movimiento hacía atras.
                aPressed.set(true);
            }

            /**
             * Salto del jugador.
             */
            if (e.getCode() == KeyCode.W && !pJumpAction && !pPunchAction && !pKickAction && !wPressed.get()) {
                pJumpAction = true;
                playerImage.setY(playerImage.getY() - (player.getImageFighterJumpL().getHeight() -
                        player.getImageFighterStanceL().getHeight() - 26));
                TranslateTransition jumpP1 = new TranslateTransition(Duration.millis
                        (player.getFighterJumpDuration()), playerImage);
                jumpP1.setByY(-254);
                jumpP1.setAutoReverse(true);
                jumpP1.setCycleCount(2);
                jumpP1.play();

                Transition jumpAnimationP1 = new Transition() {
                    {
                        setCycleDuration(Duration.millis(player.getFighterJumpDuration()));
                    }

                    @Override
                    protected void interpolate(double frac) {
                        int index = (int) (frac * (player.getListFighterJumpL().length - 1));
                        playerImage.setImage(player.getListFighterJumpL()[index]);
                        System.out.println("Player Y TIEMPO REAL: " + playerImage.getY());
                    }
                };
                jumpAnimationP1.play();

                jumpP1.setOnFinished(event -> {
                    System.out.println("Plataforma Y: " + platformImage.getY());
                    collisionChecker.jumpColCheck();
                    playerImage.setImage(player.getImageFighterStanceL());
                    pJumpAction = false;
                    System.out.println("Jugador Y: " + playerImage.getY());
                    System.out.println("Player X: " + playerImage.getX());
                });

                wPressed.set(true);
            }

            /**
             * Puñetazo del jugador.
             */
            if (e.getCode() == KeyCode.S && !pPunchAction && !pKickAction && !pJumpAction && !sPressed.get()) {
                if (aPressed.get() || dPressed.get()) {
                    aPressed.set(false);
                    dPressed.set(false);
                }
                pPunchAction = true;
                Transition punchAnimationP1 = new Transition() {
                    {
                        setCycleDuration(Duration.millis(player.getFighterPunchDuration()));
                    }

                    @Override
                    protected void interpolate(double frac) {
                        int index = (int) (frac * (player.getListFighterPunchL().length - 1));
                        playerImage.setImage(player.getListFighterPunchL()[index]);
                    }
                };
                punchAnimationP1.play();
                punchAnimationP1.setOnFinished(event -> {
                    playerImage.setImage(player.getImageFighterStanceL());
                    pPunchAction = false;
                });
                sPressed.set(true);

            }

            /**
             * Patada del jugador.
             */
            if (e.getCode() == KeyCode.C && !pKickAction && !pPunchAction && !pJumpAction && !cPressed.get()) {
                if (aPressed.get() || dPressed.get()) {
                    aPressed.set(false);
                    dPressed.set(false);
                }
                pKickAction = true;
                double currentY = playerImage.getY();
                playerImage.setY(playerImage.getY() - (player.getListFighterKickR()[0].getHeight() -
                        player.getImageFighterStanceR().getHeight()));
                Transition kickAnimationP1 = new Transition() {
                    {
                        setCycleDuration(Duration.millis(player.getFighterKickDuration()));
                    }

                    @Override
                    protected void interpolate(double frac) {
                        int index = (int) (frac * (player.getListFighterKickL().length - 1));
                        playerImage.setImage(player.getListFighterKickL()[index]);
                    }
                };
                kickAnimationP1.play();
                kickAnimationP1.setOnFinished(event -> {
                    playerImage.setImage(player.getImageFighterStanceL());
                    playerImage.setY(currentY);
                    pKickAction = false;
                });
                cPressed.set(true);
            }
        }
    }

    public void db(KeyEvent e) {

        /**
         * Se realiza la comprobación de cuando una tecla deja de ser presionada para estblecer sus booleanos a False y poder realizar otras acciones.
         */
        if (e.getCode() == KeyCode.D) {
            dPressed.set(false);
        }

        if (e.getCode() == KeyCode.A) {
            aPressed.set(false);
        }

        if (e.getCode() == KeyCode.W) {
            wPressed.set(false);
        }

        if (e.getCode() == KeyCode.S) {
            sPressed.set(false);
        }

        if (e.getCode() == KeyCode.C) {
            cPressed.set(false);
        }
    }
}
