package com.company;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;

public class ScaleChooser extends ComboBox {

    private static ObservableList<String> getOptions(){
        ObservableList<String> values = FXCollections.observableArrayList();
        for(String scaleName : OptionsHolder.getScaleNames()){
            values.add(scaleName);
        }
        return values;
    }

    public ScaleChooser(){
        setPrefHeight(25);
        setPrefWidth(150);
        setBackground(new Background(new BackgroundFill(ColorPalette.CONTROLS_LIGHT_GREEN,new CornerRadii(5), null)));
        setItems(getOptions());
        setValue("Major");

        // moves pitches on the whole key board
        setOnAction(event -> {
            OptionsHolder.setCurrentScale(OptionsHolder.nameTointArray((String)getValue()));
            MusicPlayer.updateAllNotePanes();
        });


    }
}
