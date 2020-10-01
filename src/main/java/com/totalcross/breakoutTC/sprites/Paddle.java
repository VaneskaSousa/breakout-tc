package com.totalcross.breakoutTC.sprites;

import com.totalcross.breakoutTC.util.Images;

import totalcross.game.Sprite;
import totalcross.ui.image.ImageException;

@SuppressWarnings("deprecation")
public class Paddle extends Sprite {

  public Paddle() throws IllegalArgumentException, IllegalStateException, ImageException {
    super(Images.paddle, -1, true, null);
  }
  
}