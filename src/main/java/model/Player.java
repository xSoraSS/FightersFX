package model;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Player {
    private int health = 200;
    private int fighterPunchDamage, fighterKickDamage;

    private Image imageFighterStanceL;
    private Image imageFighterStanceR;
    private Image imageFighterForwardL;
    private Image imageFighterForwardR;
    private Image imageFighterBackwardL;
    private Image imageFighterBackwardR;
    private Image imageFighterPunchL;
    private Image imageFighterPunchR;
    private Image imageFighterJumpL;
    private Image imageFighterJumpR;

    private Image[] listFighterJumpL;
    private Image[] listFighterJumpR;
    private Image[] listFighterPunchL;
    private Image[] listFighterPunchR;
    private Image[] listFighterKickL;
    private Image[] listFighterKickR;
    private Image[] listFighterKOL;
    private Image[] listFighterKOR;
    private Image[] listFighterWinL;
    private Image[] listFighterWinR;

    private int fighterJumpDuration;
    private int fighterPunchDuration;
    private int fighterKickDuration;
    private int fighterKODuration;
    private int fighterWinDuration;

    public void setImageFighters(Image stanceL, Image stanceR, Image forwardL, Image forwardR, Image backwardL,
                                 Image backwardR, Image punchL, Image punchR, Image jumpL, Image jumpR,
                                 Image[] listJumpL, Image[] listJumpR, Image[] listPunchL, Image[] listPunchR,
                                 Image[] listKickL, Image[] listKickR, Image[] listKOL, Image[] listKOR,
                                 Image[] listWinL, Image[] listWinR)
    {
        this.imageFighterStanceL = stanceL;
        this.imageFighterStanceR = stanceR;
        this.imageFighterForwardL = forwardL;
        this.imageFighterForwardR = forwardR;
        this.imageFighterBackwardL = backwardL;
        this.imageFighterBackwardR = backwardR;
        this.imageFighterPunchL = punchL;
        this.imageFighterPunchR = punchR;
        this.imageFighterJumpL = jumpL;
        this.imageFighterJumpR = jumpR;

        this.listFighterJumpL = listJumpL;
        this.listFighterJumpR = listJumpR;
        this.listFighterPunchL = listPunchL;
        this.listFighterPunchR = listPunchR;
        this.listFighterKickL = listKickL;
        this.listFighterKickR = listKickR;
        this.listFighterKOL = listKOL;
        this.listFighterKOR = listKOR;
        this.listFighterWinL = listWinL;
        this.listFighterWinR = listWinR;
    }

    public void setValues(int jumpDuration, int punchDuration, int kickDuration, int koDuration, int winDuration,
                          int punchDamage, int kickDamage)
    {
        this.fighterJumpDuration = jumpDuration;
        this.fighterKickDuration = kickDuration;
        this.fighterPunchDuration = punchDuration;
        this.fighterKODuration = koDuration;
        this.fighterWinDuration = winDuration;

        this.fighterPunchDamage = punchDamage;
        this.fighterKickDamage = kickDamage;

    }

    public Image getImageFighterStanceL()
    {
        return this.imageFighterStanceL;
    }

    public Image getImageFighterStanceR()
    {
        return this.imageFighterStanceR;
    }

    public Image getImageFighterForwardL()
    {
        return this.imageFighterForwardL;
    }

    public Image getImageFighterForwardR()
    {
        return this.imageFighterForwardR;
    }

    public Image getImageFighterBackwardL()
    {
        return this.imageFighterBackwardL;
    }

    public Image getImageFighterBackwardR()
    {
        return this.imageFighterBackwardR;
    }

    public Image getImageFighterPunchL()
    {
        return this.imageFighterPunchL;
    }

    public Image getImageFighterPunchR()
    {
        return this.imageFighterPunchR;
    }

    public Image getImageFighterJumpL()
    {
        return imageFighterJumpL;
    }

    public Image getImageFighterJumpR()
    {
        return imageFighterJumpR;
    }

    public Image[] getListFighterJumpL()
    {
        return listFighterJumpL;
    }

    public Image[] getListFighterJumpR()
    {
        return listFighterJumpR;
    }

    public Image[] getListFighterPunchL()
    {
        return listFighterPunchL;
    }

    public Image[] getListFighterPunchR()
    {
        return listFighterPunchR;
    }

    public Image[] getListFighterKickL()
    {
        return listFighterKickL;
    }

    public Image[] getListFighterKickR()
    {
        return listFighterKickR;
    }

    public Image[] getListFighterKOL()
    {
        return listFighterKOL;
    }

    public Image[] getListFighterKOR()
    {
        return listFighterKOR;
    }

    public Image[] getListFighterWinL()
    {
        return listFighterWinL;
    }

    public Image[] getListFighterWinR()
    {
        return listFighterWinR;
    }

    public void takeDamage(int damage)
    {
        this.health -= damage;
    }

    public int getHealth()
    {
        return this.health;
    }

    public Rectangle getHealthBar()
    {
        return new Rectangle(this.health, 20, Color.RED);
    }

    public int getFighterJumpDuration()
    {
        return fighterJumpDuration;
    }

    public int getFighterKickDuration()
    {
        return fighterKickDuration;
    }

    public int getFighterPunchDuration()
    {
        return fighterPunchDuration;
    }

    public int getFighterKODuration()
    {
        return fighterKODuration;
    }

    public int getFighterWinDuration()
    {
        return fighterWinDuration;
    }

    public int getFighterPunchDamage()
    {
        return fighterPunchDamage;
    }

    public int getFighterKickDamage()
    {
        return fighterKickDamage;
    }

}
