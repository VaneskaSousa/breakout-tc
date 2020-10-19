package com.totalcross.breakoutTC;

import com.totalcross.breakoutTC.sprites.Ball;
import com.totalcross.breakoutTC.sprites.Paddle;
import com.totalcross.breakoutTC.sprites.Stage;
import com.totalcross.breakoutTC.ui.InitialScreen;
import com.totalcross.breakoutTC.util.Colors;
import com.totalcross.breakoutTC.util.Constants;
import com.totalcross.breakoutTC.util.Images;

import totalcross.game.GameEngine;
import totalcross.sys.Settings;
import totalcross.sys.Vm;
import totalcross.ui.MainWindow;
import totalcross.ui.dialog.MessageBox;
import totalcross.ui.event.PenEvent;
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
    InitialScreen.swapTo(this);
  }

  public void onGameStart() {
    this.swap(stage);
    ball.setPos(Settings.screenWidth / 2, Settings.screenHeight / 2, true);
    racket.setPos(Settings.screenWidth / 2, (Settings.screenHeight - racket.height) - Constants.EDGE_RACKET, true);
  }

  @Override
  public void onPaint(Graphics g) {
    super.onPaint(g);
    if (gameIsRunning) {
      g.backColor = Colors.PRIMARY;
      g.fillRect(0, 0, this.width, this.height);

      if (racket != null) {
        racket.show();
      }

      stage.show();
      ball.move();
    }
  }

  @Override
  public void onKey(KeyEvent evt) {
    super.onKey(evt);
    if (evt.key == SpecialKeys.BACKSPACE) {
      ball.dX = 1;
      ball.dY = 1;
      ball.move();
    }
  }

  @Override
  public final void onPenDown(PenEvent evt) {
    if (gameIsRunning) {
      racket.setPos(evt.x, racket.centerY, true);
    }
  }

  @Override
  public final void onPenDrag(PenEvent evt) {
    if (gameIsRunning) {
      racket.setPos(evt.x, racket.centerY, true);
    }
  }
}