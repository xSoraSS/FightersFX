package controller;

import javafx.scene.image.ImageView;

public class CollisionController{
    private ImageView playerImage, bgImage, floorImage, platformImage, columnImage;

    public CollisionController(ImageView playerImage, ImageView bgImage, ImageView floorImage, ImageView platformImage, ImageView columnImage) {
        this.playerImage = playerImage;
        this.bgImage = bgImage;
        this.floorImage = floorImage;
        this.platformImage = platformImage;
        this.columnImage = columnImage;
    }

    /**
     * A continuación se comprueban la colisión con los diferentes objetos a los que el jugador puede alcanzar utilizando el salto.
     */
    public void jumpColCheck(){
        if (playerImage.getY() == platformImage.getY() && playerImage.getX() <= platformImage.getFitWidth() && playerImage.getX() >= platformImage.getX()) {
            playerImage.setY(platformImage.getY()-playerImage.getFitHeight());
        }else{
            playerImage.setY(680);
        }
    }

    /**
     * A continuación se comprueban los diferentes espacios vacios sobre los que se puede localizar el jugador.
     * Ya sea fuera de una plataforma, en un agujero del suelo, etc.
     */
    public void emptyColCheck(){
        if(playerImage.getX() > platformImage.getFitWidth()){
            playerImage.setY(680);
        }
    }

    /**
     * A continuación se comprueban las colisiones con las diferentes columnas/paredes.
     */
    public void columnColCheck(){

    }
}
