package com.totalcross.breakoutTC.sprites;

import totalcross.game.Sprite;
import totalcross.ui.image.Image;
import totalcross.ui.image.ImageException;

@SuppressWarnings("deprecation")
public abstract class Brick extends Sprite {
    public boolean isShown = true;

    public Brick(Image image) throws IllegalArgumentException, IllegalStateException, ImageException {
        super(image, -1, true, null);
    }

    @Override
    public void show() {
        if (isShown) {
            super.show();
        }
    }

    @Override
    public boolean collide(Sprite s) {
        if (isShown == false) {
            return false;
        }
        return super.collide(s);
    }

    public void hit(Ball ball) throws IllegalArgumentException, IllegalStateException, ImageException {
        if (this.collide(ball)) {
            ball.dY = -ball.dY;
            this.isShown = false;
            this.hide();
        }
    }
}