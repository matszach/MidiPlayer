package com.company;

import javafx.scene.paint.Color;

public class ColorPalette {

    // Application colors
    public static final Color BCG_LIGHT_GRUE = new Color(0.6,0.7,0.7,1);
    public static final Color CONTROLS_LIGHT_GREEN = new Color(0.6,0.8,0.8,1);
    public static final Color BTN_ON_GREEN = new Color(0.2,0.5,0.2,1);
    public static final Color BTN_OFF_GREEN = new Color(0.2,0.7,0.2,1);
    public static final Color BTN_ON_BLUE = new Color(0.2,0.2,0.5,1);
    public static final Color BTN_OFF_BLUE = new Color(0.2,0.2,0.7,1);



    // Constructor and singleton instance
    private ColorPalette(){}
    private static final  ColorPalette instance = new ColorPalette();
}
