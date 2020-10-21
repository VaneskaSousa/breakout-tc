package com.totalcross.breakoutTC.ui;

import com.totalcross.breakoutTC.util.Colors;
import com.totalcross.breakoutTC.util.Constants;
import com.totalcross.breakoutTC.util.Images;

import totalcross.game.GameEngine;
import totalcross.ui.Button;
import totalcross.ui.Container;
import totalcross.ui.ImageControl;
import totalcross.ui.Label;
import totalcross.ui.event.ControlEvent;
import totalcross.ui.event.Event;
import totalcross.ui.event.EventHandler;

@SuppressWarnings("deprecation")
/*
 * The game starts on a screen with the information and when the start button is
 * clicked the interface is changed
 */
public class InitialScreen extends Container {
    private Button start;
    private GameEngine game;
    private static InitialScreen instance;

    public static void swapTo(GameEngine game) {
        if (instance == null) {
            instance = new InitialScreen(game);
        }
        game.swap(instance);
    }

    private InitialScreen(GameEngine game) {
        setBackColor(Colors.PRIMARY);
        this.game = game;
    }

    public void initUI() {
        Images.loadImages();

        final ImageControl title = new ImageControl(Images.title);
        title.scaleToFit = true;
        title.centerImage = true;
        add(title, LEFT + Constants.DP_50, TOP + Constants.DP_50, FILL - Constants.DP_50, Constants.DP_50);

        final ImageControl crossy = new ImageControl(Images.p_crossy);
        crossy.scaleToFit = true;
        crossy.centerImage = true;
        add(crossy, CENTER - Constants.DP_100 * 2, AFTER + Constants.DP_50 / 2, Constants.DP_50 * 4,
                Constants.DP_50 * 4);

        final Label information = new Label("Vaneska Sousa - 476389\n" + "Breakout built with Java using TotalCross\n"
                + "\nMAMI - 2020.1\n\nDouble click on the game screen to start or restart the game");
        information.transparentBackground = true;
        information.setForeColor(Colors.P_FONT);
        add(information, CENTER + Constants.DP_100 * 3 / 2, AFTER + Constants.DP_50 * 2, PREFERRED, PREFERRED, title);

        start = new Button("Start", Button.BORDER_OUTLINED);
        start.setBackForeColors(Colors.SECUNDARY, Colors.P_FONT);
        add(start, CENTER, AFTER + Constants.DP_100);
    }

    @Override
    public <H extends EventHandler> void onEvent(Event<H> event) {
        if (event.type == ControlEvent.PRESSED && event.target == start) {
            game.start();
        }
    }
}