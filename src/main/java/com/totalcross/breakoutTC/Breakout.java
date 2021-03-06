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

    public static int threshold = 200;
    private int timeClick = -1;

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
    
    //Start the game, its like the setup on processing
    public void onGameStart() {
        this.swap(stage);
        ball.setPos(Settings.screenWidth / 2, Settings.screenHeight / 2, true);
        racket.setPos(Settings.screenWidth / 2, (Settings.screenHeight - racket.height) - Constants.EDGE_RACKET, true);
    }

    //to draw the interface
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
    //To make the paddle moving with the mouse/press moviment
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
    //To restart the game when the ball are stoped and have a double click
    @Override
    public void onPenUp(PenEvent evt) {
        if ((!Settings.fingerTouch || !hadParentScrolled()) && isInsideOrNear(evt.x, evt.y)) {
            // postPressedEvent();
            int current = Vm.getTimeStamp();
            if (timeClick == -1) {
                timeClick = current;
                return; // like the break in switch case
            }
            if (current - timeClick < threshold && ball.isStop) {
                ball.dX = 1;
                ball.dY = 1;
                ball.move();
            }
            timeClick = -1;
        }
    }
}