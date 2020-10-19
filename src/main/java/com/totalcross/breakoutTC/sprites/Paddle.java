package com.totalcross.breakoutTC.sprites;

import com.totalcross.breakoutTC.util.Images;

import totalcross.game.Sprite;
import totalcross.ui.image.ImageException;

@SuppressWarnings("deprecation")
public class Paddle extends Sprite {
  private static final int SPEED = 4;

  public Paddle() throws IllegalArgumentException, IllegalStateException, ImageException {
    super(Images.paddle, -1, true, null);
  }

  public final void move(boolean left, int speed) {
    if (left) {
      centerX -= SPEED;
    } else {
      centerX += SPEED;
    }

    setPos(centerX, centerY, true);
  }
}