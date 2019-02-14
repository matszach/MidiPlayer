package com.company;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;

public class PitchChooser extends ComboBox {

    private static ObservableList<String> getOptions(){
        ObservableList<String> values = FXCollections.observableArrayList();
        for(int i = -36; i <= 36; i++){
            values.add(""+i);
        }
        return values;
    }

    public PitchChooser(){
        setPrefHeight(25);
        setPrefWidth(60);
        setBackground(new Background(new BackgroundFill(ColorPalette.CONTROLS_LIGHT_GREEN,new CornerRadii(5), null)));
        setItems(getOptions());
        setValue("0");

        // moves pitches on the whole key board
        setOnAction(event -> {
            OptionsHolder.adjustBaseNoteValue(Integer.parseInt((String)getValue()));
            MusicPlayer.updateAllNotePanes();
        });


    }
}
