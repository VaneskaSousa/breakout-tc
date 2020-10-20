package com.totalcross.breakoutTC.util;

import totalcross.sys.Settings;
import totalcross.ui.Control;
import totalcross.util.UnitsConverter;

public class Constants {
    public static final int BOTTOM_EDGE = UnitsConverter.toPixels(430 + Control.DP);
    public static final int DP_23 = UnitsConverter.toPixels(23 + Control.DP);
    public static final int DP_50 = UnitsConverter.toPixels(50 + Control.DP);
    public static final int DP_100 = UnitsConverter.toPixels(100 + Control.DP);
    public static final int EDGE_RACKET = UnitsConverter.toPixels(20 + Control.DP);
    public static final int WIDTH_BALL =  UnitsConverter.toPixels(20 + Control.DP);
    public static final int HEIGHT_BALL =  UnitsConverter.toPixels(20 + Control.DP);
    public static final int NUM_BRICKS = 10;
    public static final int WIDTH_BRICKS = Settings.screenWidth / NUM_BRICKS;
    public static final int HEIGHT_BRICKS = Settings.screenHeight / 32;

    //Brick Points
    public static final int BLUE_POINT = 1;
    public static final int GREEN_POINT = 2;
    public static final int YELLOW_POINT = 3;
    public static final int DARK_ORANGE_POINT = 4;
    public static final int ORANGE_POINT = 5;
    public static final int RED_POINT = 6;
}