package controller;

import javafx.animation.AnimationTimer;
import javafx.animation.Transition;
import javafx.animation.TranslateTransition;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.media.AudioClip;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;
import model.Player;
import uti.StageManager;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class BattleController implements Initializable {
    @FXML
    private Rectangle p1HealthBar, p2HealthBar;
    @FXML
    private ImageView p1,p2, battleground;

    private Player player1,player2;

    private Boolean p1JumpAction = false;
    private Boolean p1PunchAction = false;
    private Boolean p1KickAction = false;
    private Boolean p2JumpAction = false;
    private Boolean p2PunchAction = false;
    private Boolean p2KickAction = false;

    private BooleanProperty dPressed = new SimpleBooleanProperty();
    private BooleanProperty aPressed = new SimpleBooleanProperty();
    private BooleanProperty wPressed = new SimpleBooleanProperty();
    private BooleanProperty sPressed = new SimpleBooleanProperty();
    private BooleanProperty cPressed = new SimpleBooleanProperty();

    private BooleanProperty rightPressed = new SimpleBooleanProperty();
    private BooleanProperty leftPressed = new SimpleBooleanProperty();
    private BooleanProperty upPressed = new SimpleBooleanProperty();
    private BooleanProperty downPressed = new SimpleBooleanProperty();
    private BooleanProperty slashPressed = new SimpleBooleanProperty();

    private AudioClip punch, kick, music;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        /**
         * Escenario y Música Aleatoria.
         */
        int idBattleground = 0;
        idBattleground = (int) (Math.random()*5)+1;
        battleground.setImage(new Image("Assets/Battlegrounds/battleground-"+idBattleground+".png"));
        battleground.setFitHeight(603);
        battleground.setFitWidth(1200);

        music = new AudioClip(new File("src/main/resources/Audio/Music/sound-"+idBattleground+".wav").toURI().toString());
        music.play();
        music.setVolume(20);


        player1 = StageManager.getPlayer1();
        player2 = StageManager.getPlayer2();

        p1.setImage(this.player1.getImageFighterStanceL());
        p1.setX(100);
        p1.setY(303);
        p2.setImage(this.player2.getImageFighterStanceR());
        p2.setX(900);
        p2.setY(303);

        p1HealthBar.setWidth(player1.getHealth());
        p2HealthBar.setWidth(player2.getHealth());


        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                /**
                 * Jugador 1.
                 */
                if (dPressed.get() && p1.getX() <= 1200 - p1.getImage().getWidth() && p1.getX() < p2.getX())
                /**
                 * Animación ejecutada al pulsar la tecla "D".
                 */
                {
                    p1.setX((p1.getX() + 5));
                }

                if (aPressed.get() && p1.getX() >= 0)
                /**
                 * Animación ejecutada al pulsar la tecla "A".
                 */
                {

                    p1.setX((p1.getX() - 5));
                }
                /**
                 * Jugador 2.
                 */
                if (leftPressed.get() && p2.getX() >= 0 && p1.getX() < p2.getX())
                /**
                 * Animación ejecutada al pulsar la tecla "->".
                 */
                {
                    p2.setX((p2.getX() - 5));
                }

                if (rightPressed.get() && p2.getX() <= 1200 - p2.getImage().getWidth())
                /**
                 * Animación ejecutada al pulsar la tecla "<-".
                 */
                {
                    p2.setX((p2.getX() + 5));
                }
            }
        };

        /**
         * Jugador 1.

         * Listeners que comprueban si el estado del boolean property en cuestión cambia, es decir, si la tecla deja de estar presionada.
         */
        dPressed.addListener((obs, wasPressed, nowPressed) ->
        {
            if(dPressed.get()) // Si la tecla "D" está presionada se incia la animación.
            {
                timer.start();
            }
            else if(!dPressed.get()) // Si deja de estar presionada vuelve a su estado normal.
            {
                p1.setImage(player1.getImageFighterStanceL());
            }
        });

        aPressed.addListener((obs, wasPressed, nowPressed) ->
        {
            if(aPressed.get())
            {
                timer.start();
            }
            else if(!aPressed.get())
            {
                p1.setImage(player1.getImageFighterStanceL());
            }
        });

        sPressed.addListener((obs, wasPressed, nowPressed) ->
        {
            if(sPressed.get())
            {
                if (p1.getBoundsInParent().intersects(p2.getBoundsInParent()))
                {
                    player2.takeDamage(player1.getFighterPunchDamage());
                    p2HealthBar.setWidth(player2.getHealth());
                    p2HealthBar.setX(p2HealthBar.getX() + player1.getFighterPunchDamage());
                    punch = new AudioClip(new File("src/main/resources/Audio/Effects/punch.wav").toURI().toString());
                    if(p2.getX() <= 1200 - p2.getImage().getWidth())
                    {
                        p2.setX(p2.getX()+40);
                    }
                    punch.play();
                    punch.setVolume(15);
                }
            }
        });

        cPressed.addListener((obs, wasPressed, nowPressed) ->
        {
            if(cPressed.get())
            {
                if (p1.getBoundsInParent().intersects(p2.getBoundsInParent()))
                {
                    player2.takeDamage(player1.getFighterKickDamage());
                    p2HealthBar.setWidth(player2.getHealth());
                    p2HealthBar.setX(p2HealthBar.getX() + player1.getFighterKickDamage());
                    kick = new AudioClip(new File("src/main/resources/Audio/Effects/kick.wav").toURI().toString());
                    if(p2.getX() <= 1200 - p2.getImage().getWidth())
                    {
                        p2.setX(p2.getX()+60);
                    }
                    kick.play();
                    kick.setVolume(15);
                }
            }
        });

        /**
         * Jugador 2.
         */
        leftPressed.addListener((obs, wasPressed, nowPressed) ->
        {
            if(leftPressed.get())
            {
                timer.start();
            }
            else if(!leftPressed.get())
            {
                p2.setImage(player2.getImageFighterStanceR());
            }
        });

        rightPressed.addListener((obs, wasPressed, nowPressed) ->
        {
            if(rightPressed.get())
            {
                timer.start();
            }
            else if(!rightPressed.get())
            {
                p2.setImage(player2.getImageFighterStanceR());
            }
        });


        downPressed.addListener((obs, wasPressed, nowPressed) ->
        {
            if(downPressed.get())
            {
                if (p2.getBoundsInParent().intersects(p1.getBoundsInParent()))
                {
                    player1.takeDamage(player2.getFighterPunchDamage());
                    p1HealthBar.setWidth(player1.getHealth());
                    punch = new AudioClip(new File("src/main/resources/Audio/Effects/punch.wav").toURI().toString());
                    if(p1.getX() >= 0)
                    {
                        p1.setX(p1.getX()-40);
                    }
                    punch.play();
                    punch.setVolume(15);
                }
            }
        });

        slashPressed.addListener((obs, wasPressed, nowPressed) ->
        {
            if(slashPressed.get())
            {
                if (p2.getBoundsInParent().intersects(p1.getBoundsInParent()))
                {
                    player1.takeDamage(player2.getFighterKickDamage());
                    p1HealthBar.setWidth(player1.getHealth());
                    kick = new AudioClip(new File("src/main/resources/Audio/Effects/kick.wav").toURI().toString());
                    if(p1.getX() >= 0)
                    {
                        p1.setX(p1.getX()-60);
                    }
                    kick.play();
                    kick.setVolume(15);
                }
            }
        });

    }

    public void da(KeyEvent e) {
        if(player1.getHealth() > 0 && player2.getHealth() > 0)
        {
            /**
             * El jugador1 se mueve en horizontal hacía la derecha cuando se presiona la tecla "D".
             * Se realizan ciertas comprobaciones para este movimiento, como que el jugador no esté golpeando o dando una patada mientras está en movimiento.
             */
            if(e.getCode() == KeyCode.D && !p1PunchAction && !p1KickAction)
            {
                p1.setImage(player1.getImageFighterForwardL()); // El personaje en la pantalla cambia su gif, o animación, al movimiento hacía delante.
                dPressed.set(true);
            }

            /**
             * El jugador1 se mueve en horizontal hacía la izquierda cuando se presiona la tecla "A".
             * Se realizan las mismas comprobaciones.
             */
            if(e.getCode() == KeyCode.A && !p1PunchAction && !p1KickAction)
            {
                p1.setImage(player1.getImageFighterBackwardL()); // El personaje en la pantalla cambia su gif, o animación, al movimiento hacía atras.
                aPressed.set(true);
            }


            /**
             * Salto del jugador1.
             */
            if(e.getCode() == KeyCode.W && !p1JumpAction && !p1PunchAction && !p1KickAction && !wPressed.get())
            {
                p1JumpAction = true;
                p1.setY(303 - (player1.getImageFighterJumpL().getHeight() -
                        player1.getImageFighterStanceL().getHeight()));
                TranslateTransition jumpP1 = new TranslateTransition(Duration.millis
                        (player1.getFighterJumpDuration()), p1);
                jumpP1.setByY(-300);
                jumpP1.setAutoReverse(true);
                jumpP1.setCycleCount(2);
                jumpP1.play();

                Transition jumpAnimationP1 = new Transition()
                {
                    {
                        setCycleDuration(Duration.millis(player1.getFighterJumpDuration()));
                    }
                    @Override
                    protected void interpolate(double frac)
                    {
                        int index = (int)(frac*(player1.getListFighterJumpL().length-1));
                        p1.setImage(player1.getListFighterJumpL()[index]);
                    }
                };
                jumpAnimationP1.play();

                jumpP1.setOnFinished(event -> {
                    p1.setY(303);
                    p1.setImage(player1.getImageFighterStanceL());
                    p1JumpAction = false;
                });


                wPressed.set(true);
            }

            /**
             * Puñetazo del jugador1.
             */
            if(e.getCode() == KeyCode.S && !p1PunchAction && !p1KickAction && !p1JumpAction && !sPressed.get())
            {
                if(aPressed.get() || dPressed.get())
                {
                    aPressed.set(false);
                    dPressed.set(false);
                }
                p1PunchAction = true;
                Transition punchAnimationP1 = new Transition()
                {
                    {
                        setCycleDuration(Duration.millis(player1.getFighterPunchDuration()));
                    }
                    @Override
                    protected void interpolate(double frac)
                    {
                        int index = (int)(frac*(player1.getListFighterPunchL().length-1));
                        p1.setImage(player1.getListFighterPunchL()[index]);
                    }
                };
                punchAnimationP1.play();
                punchAnimationP1.setOnFinished(event -> {
                    p1.setImage(player1.getImageFighterStanceL());
                    p1PunchAction = false;
                });
                sPressed.set(true);

            }

            /**
             * Patada del jugador1.
             */
            if(e.getCode() == KeyCode.C && !p1KickAction && !p1PunchAction && !p1JumpAction && !cPressed.get())
            {
                if(aPressed.get() || dPressed.get())
                {
                    aPressed.set(false);
                    dPressed.set(false);
                }
                p1KickAction = true;
                double currentY = p1.getY();
                p1.setY(p1.getY() - (player1.getListFighterKickR()[0].getHeight() -
                        player1.getImageFighterStanceR().getHeight()));
                Transition kickAnimationP1 = new Transition()
                {
                    {
                        setCycleDuration(Duration.millis(player1.getFighterKickDuration()));
                    }
                    @Override
                    protected void interpolate(double frac)
                    {
                        int index = (int)(frac*(player1.getListFighterKickL().length-1));
                        p1.setImage(player1.getListFighterKickL()[index]);
                    }
                };
                kickAnimationP1.play();
                kickAnimationP1.setOnFinished(event -> {
                    p1.setImage(player1.getImageFighterStanceL());
                    p1.setY(currentY);
                    p1KickAction = false;
                });
                cPressed.set(true);
            }

            /**
             * El jugador2 se mueve en horizontal hacía la derecha cuando se presiona la tecla "J".
             * Se realizan ciertas comprobaciones para este movimiento, como que el jugador no esté golpeando o dando una patada mientras está en movimiento.
             */
            if(e.getCode() == KeyCode.J && !p2PunchAction && !p2KickAction)
            {
                p2.setImage(player2.getImageFighterForwardR());
                leftPressed.set(true);
            }

            /**
             * El jugador2 se mueve en horizontal hacía la izquierda cuando se presiona la tecla "L".
             * Se realizan las mismas comprobaciones.
             */
            if(e.getCode() == KeyCode.L && !p2PunchAction && !p2KickAction)
            {
                p2.setImage(player2.getImageFighterBackwardR());
                rightPressed.set(true);
            }

            /**
             * Salto del jugador2.
             */
            if(e.getCode() == KeyCode.I && !p2JumpAction && !p2PunchAction && !p2KickAction && !upPressed.get())
            {
                p2JumpAction = true;
                p2.setY(303 - (player2.getImageFighterJumpR().getHeight() -
                        player2.getImageFighterStanceR().getHeight()));
                TranslateTransition jumpP2 = new TranslateTransition(Duration.millis
                        (player2.getFighterJumpDuration()), p2);
                jumpP2.setByY(-300);
                jumpP2.setAutoReverse(true);
                jumpP2.setCycleCount(2);
                jumpP2.play();

                Transition jumpAnimationP2 = new Transition()
                {
                    {
                        setCycleDuration(Duration.millis(player2.getFighterJumpDuration()));
                    }
                    @Override
                    protected void interpolate(double frac)
                    {
                        int index = (int)(frac*(player2.getListFighterJumpR().length-1));
                        p2.setImage(player2.getListFighterJumpR()[index]);
                    }
                };
                jumpAnimationP2.play();

                jumpP2.setOnFinished(event -> {
                    p2.setY(303);
                    p2.setImage(player2.getImageFighterStanceR());
                    p2JumpAction = false;
                });

                upPressed.set(true);

            }

            /**
             * Puñetazo del jugador2.
             */
            if(e.getCode() == KeyCode.K && !p2PunchAction && !p2KickAction && !p2JumpAction &&
                    !downPressed.get())
            {
                if(leftPressed.get() || rightPressed.get())
                {
                    leftPressed.set(false);
                    rightPressed.set(false);
                }
                p2PunchAction = true;
                double currentX = p2.getX();
                p2.setX(p2.getX() - (player2.getImageFighterPunchR().getWidth() -
                        player2.getImageFighterStanceR().getWidth()));
                Transition punchAnimationP2 = new Transition()
                {
                    {
                        setCycleDuration(Duration.millis(player2.getFighterPunchDuration()));
                    }
                    @Override
                    protected void interpolate(double frac)
                    {
                        int index = (int)(frac*(player2.getListFighterPunchR().length-1));
                        p2.setImage(player2.getListFighterPunchR()[index]);
                    }
                };
                punchAnimationP2.play();
                punchAnimationP2.setOnFinished(event -> {
                    p2.setImage(player2.getImageFighterStanceR());
                    if (!leftPressed.get() && !rightPressed.get())
                    {
                        p2.setX(currentX);
                    }
                    p2PunchAction = false;
                });
                downPressed.set(true);

            }

            /**
             * Patada del jugador2.
             */
            if(e.getCode() == KeyCode.H && !p2KickAction && !p2PunchAction && !p2JumpAction &&
                    !slashPressed.get())
            {
                if(leftPressed.get() || rightPressed.get())
                {
                    leftPressed.set(false);
                    rightPressed.set(false);
                }
                p2KickAction = true;
                double currentX = p2.getX();
                double currentY = p2.getY();
                p2.setX(p2.getX() - (player2.getListFighterKickR()[0].getWidth() -
                        player2.getImageFighterStanceR().getWidth()));
                p2.setY(p2.getY() - (player2.getListFighterKickR()[0].getHeight() -
                        player2.getImageFighterStanceR().getHeight()));
                Transition kickAnimationP2 = new Transition()
                {
                    {
                        setCycleDuration(Duration.millis(player2.getFighterKickDuration()));
                    }
                    @Override
                    protected void interpolate(double frac)
                    {
                        int index = (int)(frac*(player2.getListFighterKickR().length-1));
                        p2.setImage(player2.getListFighterKickR()[index]);
                    }
                };
                kickAnimationP2.play();
                kickAnimationP2.setOnFinished(event -> {
                    p2.setImage(player2.getImageFighterStanceR());
                    p2.setX(currentX);
                    p2.setY(currentY);
                    p2KickAction = false;
                });
                slashPressed.set(true);
            }
        }
    }

    public void db(KeyEvent e){

        /**
         * Se realiza la comprobación de cuando una tecla deja de ser presionada para estblecer sus booleanos a False y poder realizar otras acciones.
         */
        /**
         * Jugador1.
         */
        if(e.getCode() == KeyCode.D)
        {
            dPressed.set(false);
        }

        if(e.getCode() == KeyCode.A)
        {
            aPressed.set(false);
        }

        if(e.getCode() == KeyCode.W)
        {
            wPressed.set(false);
        }

        if(e.getCode() == KeyCode.S)
        {
            sPressed.set(false);
        }

        if(e.getCode() == KeyCode.C)
        {
            cPressed.set(false);
        }

        /**
         * Jugador2.
         */
        if(e.getCode() == KeyCode.J)
        {
            leftPressed.set(false);
        }

        if(e.getCode() == KeyCode.L)
        {
            rightPressed.set(false);
        }

        if(e.getCode() == KeyCode.I)
        {
            upPressed.set(false);
        }

        if(e.getCode() == KeyCode.K)
        {
            downPressed.set(false);
        }

        if(e.getCode() == KeyCode.H)
        {
            slashPressed.set(false);
        }

        if(player2.getHealth() <= 0 && player1.getHealth() > 0 )//&& !gameOver)
        {

            Transition winAnimationP1 = new Transition()
            {
                {
                    setCycleDuration(Duration.millis(player1.getFighterWinDuration()));
                }
                @Override
                protected void interpolate(double frac)
                {
                    int index = (int)(frac*(player1.getListFighterWinL().length-1));
                    p1.setImage(player1.getListFighterWinL()[index]);
                }
            };

            Transition koAnimationP2 = new Transition()
            {
                {
                    setCycleDuration(Duration.millis(player2.getFighterKODuration()));
                }
                @Override
                protected void interpolate(double frac)
                {
                    int index = (int)(frac*(player2.getListFighterKOR().length-1));
                    p2.setImage(player2.getListFighterKOR()[index]);
                }
            };
            winAnimationP1.play();
            koAnimationP2.play();
            winAnimationP1.setOnFinished(event -> {
                try {
                    gameOver();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            });
        }

        else if(player1.getHealth() <= 0 && player2.getHealth() > 0 )//&& !gameOver)
        {

            Transition winAnimationP2 = new Transition()
            {
                {
                    setCycleDuration(Duration.millis(player2.getFighterWinDuration()));
                }
                @Override
                protected void interpolate(double frac)
                {
                    int index = (int)(frac*(player2.getListFighterWinR().length-1));
                    p2.setImage(player2.getListFighterWinR()[index]);
                }
            };

            Transition koAnimationP1 = new Transition()
            {
                {
                    setCycleDuration(Duration.millis(player1.getFighterKODuration()));
                }
                @Override
                protected void interpolate(double frac)
                {
                    int index = (int)(frac*(player1.getListFighterKOL().length-1));
                    p1.setImage(player1.getListFighterKOL()[index]);
                }
            };
            winAnimationP2.play();
            koAnimationP1.play();
            winAnimationP2.setOnFinished(event -> {
                try {
                    gameOver();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            });
        }
    }

    public void gameOver() throws IOException {
        /**
         * Se termina la partida y regresa al menú principal.
         */
        music.stop();
        Parent root = FXMLLoader.load(Thread.currentThread().getContextClassLoader().getResource("fxml/menu.fxml"));
        StageManager.stage.setScene(new Scene(root));
        StageManager.stage.show();
    }
}
