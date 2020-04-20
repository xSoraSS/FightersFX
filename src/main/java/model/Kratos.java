package model;

import javafx.scene.image.Image;

public class Kratos extends Player
{
    public Kratos()
    {

        Image imageKratosStanceL = new Image("Assets/Kratos/KratosStance.gif");
        Image imageKratosStanceR = new Image("Assets/Kratos/KratosStanceRight.gif");
        Image imageKratosForwardL = new Image("Assets/Kratos/KratosForward.gif");
        Image imageKratosForwardR = new Image("Assets/Kratos/KratosForwardRight.gif");
        Image imageKratosBackwardL = new Image("Assets/Kratos/KratosBackward.gif");
        Image imageKratosBackwardR = new Image("Assets/Kratos/KratosBackwardRight.gif");
        Image imageKratosPunchL = new Image("Assets/Kratos/KratosHPunch.gif");
        Image imageKratosPunchR = new Image("Assets/Kratos/KratosHPunchR.gif");
        Image imageKratosJumpL = new Image("Assets/Kratos/KratosJump.gif");
        Image imageKratosJumpR = new Image("Assets/Kratos/KratosJumpR.gif");

        Image[] listKratosPunchL = new Image[16];
        Image[] listKratosPunchR = new Image[16];
        Image[] listKratosJumpL = new Image[31];
        Image[] listKratosJumpR = new Image[31];
        Image[] listKratosKickL = new Image[14];
        Image[] listKratosKickR = new Image[14];
        Image[] listKratosKOL = new Image[16];
        Image[] listKratosKOR = new Image[16];
        Image[] listKratosWinL = new Image[32];
        Image[] listKratosWinR = new Image[32];

        int punchDamage = 30;
        int kickDamage = 60;


        for(int i = 0; i < listKratosPunchL.length; i++ )
        {
            String url = String.format("Assets/Kratos/KratosPunchFramesL/Frame%s.png", Integer.toString(i));
            listKratosPunchL[i] = new Image(url);
        }

        for(int i = 0; i < listKratosPunchR.length; i++ )
        {
            String url = String.format("Assets/Kratos/KratosPunchFramesR/Frame%s.png", Integer.toString(i));
            listKratosPunchR[i] = new Image(url);
        }

        for(int i = 0; i < listKratosJumpL.length; i++ )
        {
            String url = String.format("Assets/Kratos/KratosJumpFramesL/Frame%s.png", Integer.toString(i));
            listKratosJumpL[i] = new Image(url);
        }

        for(int i = 0; i < listKratosJumpR.length; i++ )
        {
            String url = String.format("Assets/Kratos/KratosJumpFramesR/Frame%s.png", Integer.toString(i));
            listKratosJumpR[i] = new Image(url);
        }

        for(int i = 0; i < listKratosKickL.length; i++ )
        {
            String url = String.format("Assets/Kratos/KratosKickFramesL/Frame%s.png", Integer.toString(i));
            listKratosKickL[i] = new Image(url);
        }

        for(int i = 0; i < listKratosKickR.length; i++ )
        {
            String url = String.format("Assets/Kratos/KratosKickFramesR/Frame%s.png", Integer.toString(i));
            listKratosKickR[i] = new Image(url);
        }

        for(int i = 0; i < listKratosKOL.length; i++ )
        {
            String url = String.format("Assets/Kratos/KratosKOFramesL/Frame%s.png", Integer.toString(i));
            listKratosKOL[i] = new Image(url);
        }

        for(int i = 0; i < listKratosKOR.length; i++ )
        {
            String url = String.format("Assets/Kratos/KratosKOFramesR/Frame%s.png", Integer.toString(i));
            listKratosKOR[i] = new Image(url);
        }

        for(int i = 0; i < listKratosWinL.length; i++ )
        {
            String url = String.format("Assets/Kratos/KratosWinFramesL/Frame%s.png", Integer.toString(i));
            listKratosWinL[i] = new Image(url);
        }

        for(int i = 0; i < listKratosWinR.length; i++ )
        {
            String url = String.format("Assets/Kratos/KratosWinFramesR/Frame%s.png", Integer.toString(i));
            listKratosWinR[i] = new Image(url);
        }

        super.setImageFighters(imageKratosStanceL, imageKratosStanceR, imageKratosForwardL, imageKratosForwardR,
                imageKratosBackwardL, imageKratosBackwardR, imageKratosPunchL, imageKratosPunchR, imageKratosJumpL,
                imageKratosJumpR, listKratosJumpL, listKratosJumpR, listKratosPunchL, listKratosPunchR, listKratosKickL,
                listKratosKickR, listKratosKOL, listKratosKOR, listKratosWinL, listKratosWinR);

        super.setValues(325, 650, 900, 2180, 6990,
                punchDamage, kickDamage);
    }
}
