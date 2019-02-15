package com.company.Buttons;

import com.company.ColorPalette;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

abstract public class AppButton extends Button {

    abstract public void onAction();

    public AppButton(int xLocation, int yLocation, String buttonText){
        relocate(xLocation,yLocation);
        setText(buttonText);
        setPrefHeight(25);
        setBackground(new Background(new BackgroundFill(ColorPalette.CONTROLS_LIGHT_GREEN, new CornerRadii(5), null)));
        setBorder(new Border(new BorderStroke(ColorPalette.BTN_ON_BLUE, BorderStrokeStyle.SOLID, new CornerRadii(5), new BorderWidths(1))));
        setEffect(new DropShadow(5, Color.GRAY));
        setOnAction(e->onAction());
    }
}
