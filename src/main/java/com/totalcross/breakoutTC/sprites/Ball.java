package com.totalcross.breakoutTC.sprites;

import com.totalcross.breakoutTC.util.Constants;
import com.totalcross.breakoutTC.util.Images;

import totalcross.game.Sprite;
import totalcross.sys.Settings;
import totalcross.ui.image.ImageException;

@SuppressWarnings("deprecation")
public class Ball extends Sprite {
    public int speed = 10;
    public int dX = 0;
    public int dY = 0;
    public boolean isStop = false;
    private Paddle racket;
    private Stage stage;

    public Ball(Paddle racket, Stage stage) throws IllegalArgumentException, IllegalStateException, ImageException {
        super(Images.ball, 1, true, null);
        this.racket = racket;
        this.stage = stage;

    }

    //
    public final void move() {
        //Ball MRU
        this.setPos(centerX + speed * dX, centerY + speed * dY, true);
        this.show();
    }

    @Override
    public boolean onPositionChange() {
        //Check if the ball is stoped
        if(dX == 0 && dY == 0){
            isStop = true;
        }else{
            isStop = false;
        }
        // Change the ball direction every colision with the screen edges
        if (this.centerX < regionMinx) {
            this.centerX = regionMinx;
            dX = -dX;
        }
        if (this.centerX > regionMaxx) {
            this.centerX = regionMaxx;
            dX = -dX;
        }

        if (this.centerY < regionMiny) {
            this.centerY = regionMiny;
            dY = -dY;
        }

        try {
            stage.collide(this);
        } catch (IllegalArgumentException | IllegalStateException | ImageException e) {
            e.printStackTrace();
        }

        //Test if colide with the racket and in wich part collide to change the direction X and/or Y
        if (this.collide(racket)) {
            int racketMod = racket.width / 5;
            if (this.centerX < (racket.centerX - racketMod)) {
                dX = -1;
                dY = -1;
            } else if (this.centerX > (racket.centerX + racketMod)) {
                dX = 1;
                dY = -1;
            } else {
                dY = -dY;
            }
        }
        
        //If the ball fall (game over) make the ball stop
        if (this.centerY > (regionMaxy - Constants.EDGE_RACKET)) {
            this.reset();
        }

        return super.onPositionChange();
    }
    //Stop the ball by change the directions to 0;
    public void reset() {
        dX = 0;
        dY = 0;
        racket.setPos(Settings.screenWidth / 2, (Settings.screenHeight - racket.height) - Constants.EDGE_RACKET, false);
        this.setPos(racket.centerX, racket.centerY - (racket.height >> 1) - 10, false);
    }
}