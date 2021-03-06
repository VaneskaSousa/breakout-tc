package com.totalcross.breakoutTC.sprites;

import com.totalcross.breakoutTC.util.Constants;

import totalcross.ui.Container;
import totalcross.ui.gfx.Graphics;
import totalcross.ui.image.ImageException;

@SuppressWarnings("deprecation")
public class Stage extends Container {
    public int general_points = 0;
    public int level = 1;
    //create the diferents typs of bricks acording the constant NUM_BRICKS
    private RedBrick[] redBrick = new RedBrick[Constants.NUM_BRICKS];
    private OrangeBrick[] orangeBrick = new OrangeBrick[Constants.NUM_BRICKS];
    private DarkOrangeBrick[] darkOrangeBrick = new DarkOrangeBrick[Constants.NUM_BRICKS];
    private YellowBrick[] yellowBrick = new YellowBrick[Constants.NUM_BRICKS];
    private GreenBrick[] greenBrick = new GreenBrick[Constants.NUM_BRICKS];
    private BlueBrick[] blueBrick = new BlueBrick[Constants.NUM_BRICKS];

    public Stage() throws IllegalArgumentException, IllegalStateException, ImageException {
        //Set the bricks in each one position
        for (int i = 0; i < redBrick.length; i++) {
            redBrick[i] = new RedBrick();
            redBrick[i].setPos(i * redBrick[i].width + (redBrick[i].width >> 1), Constants.EDGE_RACKET * 3, false);

            orangeBrick[i] = new OrangeBrick();
            orangeBrick[i].setPos(i * orangeBrick[i].width + (orangeBrick[i].width >> 1),
                    redBrick[i].centerY + orangeBrick[i].height, false);

            darkOrangeBrick[i] = new DarkOrangeBrick();
            darkOrangeBrick[i].setPos(i * darkOrangeBrick[i].width + (darkOrangeBrick[i].width >> 1),
                    orangeBrick[i].centerY + darkOrangeBrick[i].height, false);

            yellowBrick[i] = new YellowBrick();
            yellowBrick[i].setPos(i * yellowBrick[i].width + (yellowBrick[i].width >> 1),
                    darkOrangeBrick[i].centerY + yellowBrick[i].height, false);

            greenBrick[i] = new GreenBrick();
            greenBrick[i].setPos(i * greenBrick[i].width + (greenBrick[i].width >> 1),
                    yellowBrick[i].centerY + greenBrick[i].height, false);

            blueBrick[i] = new BlueBrick();
            blueBrick[i].setPos(i * greenBrick[i].width + (greenBrick[i].width >> 1),
                    greenBrick[i].centerY + blueBrick[i].height, false);
        }
    }
    //"paint" the bricks on the screen
    public void show() {
        for (int i = 0; i < redBrick.length; i++) {
            redBrick[i].show();
            orangeBrick[i].show();
            darkOrangeBrick[i].show();
            yellowBrick[i].show();
            greenBrick[i].show();
            blueBrick[i].show();
        }
    }
    //Test if have an colision
    public void collide(Ball ball) throws IllegalArgumentException, IllegalStateException, ImageException {
        for (int i = 0; i < redBrick.length; i++) {
            if(redBrick[i].hit(ball)) continue;
            if(orangeBrick[i].hit(ball)) continue;
            if(darkOrangeBrick[i].hit(ball)) continue;
            if(yellowBrick[i].hit(ball)) continue;
            if(greenBrick[i].hit(ball)) continue;
            if(blueBrick[i].hit(ball)) continue;
        }
       // Check if the user broke all the bricks and if it is true, pass to level 2, incrising the ball speed
        if (haveBrick() == false && level == 1) {
            ball.reset();
            resetStage();
            ball.speed = 15;
            level = 2;
        }
    }
    //Check all bricks are "broken"
    public boolean haveBrick() {
        boolean bricks = false;
        for (int i = 0; i < redBrick.length; i++) {
            bricks |= (blueBrick[i].isShown);
            bricks |= (greenBrick[i].isShown);
            bricks |= (yellowBrick[i].isShown);
            bricks |= (darkOrangeBrick[i].isShown);
            bricks |= (orangeBrick[i].isShown);
            bricks |= (redBrick[i].isShown);

            if (bricks)
                break;
        }
        return bricks;
    }
    //Reset all the brick vetors to restart the game on level 2
    public void resetStage() {
        // Aqui tentei chamar esse metodo la em Ball.java quando cai mas nao deu certo
        for (int i = 0; i < redBrick.length; i++) {
            redBrick[i].isShown = true;
            orangeBrick[i].isShown = true;
            darkOrangeBrick[i].isShown = true;
            yellowBrick[i].isShown = true;
            greenBrick[i].isShown = true;
            blueBrick[i].isShown = true;
        }
    }

    @Override
    public void onPaint(Graphics g) {
    }
}