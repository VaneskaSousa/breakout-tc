package com.totalcross.breakoutTC;

import com.totalcross.breakoutTC.util.Constants;
import com.totalcross.breakoutTC.util.Images;
import com.totalcross.breakoutTC.sprites.Ball;
import com.totalcross.breakoutTC.sprites.Paddle;
import com.totalcross.breakoutTC.sprites.Stage;

import totalcross.game.GameEngine;
import totalcross.sys.Settings;
import totalcross.sys.SpecialKeys;
import totalcross.ui.MainWindow;
import totalcross.ui.dialog.MessageBox;
import totalcross.ui.event.KeyEvent;
import totalcross.ui.gfx.Color;
import totalcross.ui.gfx.Graphics;

@SuppressWarnings("deprecation")
public class Breakout extends GameEngine {
  public static int screenPosition = 0;

  private Paddle racket;
  private Ball ball;
  private Stage stage;

  public Breakout() {
    setUIStyle(Settings.MATERIAL_UI);
    gameName = "Breakout";
    gameCreatorID = "vsbg";
    gameVersion = 100;
    gameHasUI = true;
    gameRefreshPeriod = 70;

    if (Settings.screenWidth < Settings.screenHeight) {
      screenPosition = Settings.screenWidth;
    } else {
      screenPosition = Settings.screenHeight;
    }

  }

  @Override
  public void onGameInit() {

    setBackColor(Color.BLACK);
    Images.loadImages();

    try {
      stage = new Stage();
      racket = new Paddle();
      ball = new Ball(racket, stage);

    } catch (Exception e) {
      MessageBox.showException(e, true);
      MainWindow.exit(0);
    }
    this.start();
  }

  public void onGameStart() {
    ball.reset();
  }

  @Override
  public void onPaint(Graphics g) {
    super.onPaint(g);
    if (racket != null) {
      racket.show();
    }
    stage.show();
    ball.move();
  }

  @Override
  public void onKey(KeyEvent evt) {
    super.onKey(evt);
    if (evt.key == SpecialKeys.RIGHT) {
      racket.setPos(racket.centerX + 50, racket.centerY, true);
    }
    if (evt.key == SpecialKeys.LEFT) {
      racket.setPos(racket.centerX - 50, racket.centerY, true);
    }
  }
}