package com.company;

import javafx.scene.control.ComboBox;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;

abstract public class Chooser extends ComboBox {
    public Chooser(){
        setPrefHeight(25);
        setBackground(new Background(new BackgroundFill(ColorPalette.CONTROLS_LIGHT_GREEN,new CornerRadii(5), null)));
        setEffect(new DropShadow(5, Color.GRAY));
    }
}
