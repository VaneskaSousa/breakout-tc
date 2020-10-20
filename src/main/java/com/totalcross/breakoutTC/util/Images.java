package com.totalcross.breakoutTC.util;

import totalcross.sys.Settings;
import totalcross.ui.dialog.MessageBox;
import totalcross.ui.image.Image;
import static com.totalcross.breakoutTC.util.Constants.*;


public class Images {

    public static Image paddle, ball, crossy, p_crossy, title;
    public static Image red, orange, dark_orange, yellow, green, blue;

    public static void loadImages() {
        try {
            // general
            paddle = new Image("sprites/paddle.png");
            ball = new Image("sprites/ball.png").getScaledInstance(WIDTH_BALL, HEIGHT_BALL);
            crossy = new Image("others/crossy.png");
            p_crossy = new Image("others/p_crossy.png");
            title = new Image("others/breakout_title.png");

            // Bricks 20x32
            red = new Image("sprites/red_brick.png").getScaledInstance(WIDTH_BRICKS, HEIGHT_BRICKS);
            orange = new Image("sprites/orange_brick.png").getScaledInstance(WIDTH_BRICKS, HEIGHT_BRICKS);
            dark_orange = new Image("sprites/orange2_brick.png").getScaledInstance(WIDTH_BRICKS, HEIGHT_BRICKS);
            yellow = new Image("sprites/yellow_brick.png").getScaledInstance(WIDTH_BRICKS, HEIGHT_BRICKS);
            green = new Image("sprites/green_brick.png").getScaledInstance(WIDTH_BRICKS, HEIGHT_BRICKS);
            blue = new Image("sprites/blue_brick.png").getScaledInstance(WIDTH_BRICKS, HEIGHT_BRICKS);

        } catch (Exception e) {
            MessageBox.showException(e, true);
        }
    }
}