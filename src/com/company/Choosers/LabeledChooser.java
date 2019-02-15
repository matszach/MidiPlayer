package com.company.Choosers;

import com.company.ColorPalette;
import javafx.scene.control.ComboBox;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

abstract public class LabeledChooser extends ComboBox {

    private Text label = new Text();
    public Text getLabel() {
        return label;
    }

    public LabeledChooser(int xLocation, int yLocation, String labelMessage){
        setPrefHeight(25);
        setBackground(new Background(new BackgroundFill(ColorPalette.CONTROLS_LIGHT_GREEN,new CornerRadii(5), null)));
        setEffect(new DropShadow(5, Color.GRAY));
        label.setText(labelMessage);
        label.relocate(xLocation, yLocation);
        relocate(xLocation, yLocation+20);
    }
}
