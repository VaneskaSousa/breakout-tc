package com.totalcross.breakoutTC.sprites;

import com.totalcross.breakoutTC.util.Constants;
import com.totalcross.breakoutTC.util.Images;

import totalcross.game.Sprite;
import totalcross.sys.Settings;
import totalcross.ui.image.ImageException;

@SuppressWarnings("deprecation")
public class Ball extends Sprite {
    private int vX = 10;
    private int vY = 10;
    public int dX = -1;
    public int dY = -1;

    private Paddle racket;
    private Stage stage;

    public Ball(Paddle racket, Stage stage) throws IllegalArgumentException, IllegalStateException, ImageException {
        super(Images.ball, 1, true, null);
        this.racket = racket;
        this.stage = stage;

    }

    public final void move() {
        // move so é chamado quando é animação (velocidade e percurso)
        this.setPos(centerX + vX * dX, centerY + vY * dY, true);
        this.show();
    }

    @Override
    public boolean onPositionChange() {
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

        // Change the ball direction every colision with the red paddle
        stage.collide(this);

        // Changes the direction of the ball according to the location of the racket
        /*
         * Pensei em pegar a largura e dividir por 4 e dai em cada lugar tem um
         * movimento diferente
         *
         */
        if (this.collide(racket)) {
            int racketMod = racket.width / 4;

            if (this.regionMinx < racketMod) { // 1
                dX = -1;
                dY = -1;
            }
            if (this.regionMinx >= racketMod && this.regionMinx < (racketMod * 2)) { // 2
                dX = -1;
                dY = -dY;
            }
            if (this.regionMinx >= (racketMod * 2) && this.regionMinx < (racketMod * 3)) { // Center
                dX = 0;
                dY = -1;
            }
            if (this.regionMinx >= (racketMod * 3) && this.regionMinx < (racketMod * 4)) { // 2
                dX = 1;
                dY = -dY;
            }
            if (this.regionMinx > (racketMod * 4)) { // 1
                dX = 1;
                dY = -1;
            }
        }

        /*
         * if the ball arrives at the place where the racket starts, that is, there is
         * no collision with the racket, it returns to the home screen
         */
        if (this.centerY > (regionMaxy - Constants.EDGE_RACKET)) {
            // estranho
            this.reset();
        }
        return super.onPositionChange();
    }

    public void reset() {
        dX = 0;
        dY = 0;
        int racketY = (Settings.screenHeight - racket.height) - Constants.EDGE_RACKET;
        racket.setPos(Settings.screenWidth / 2, racketY, false);
        this.setPos(racket.centerX, racket.centerY - (racket.height >> 1) - 10, false);
    }
}