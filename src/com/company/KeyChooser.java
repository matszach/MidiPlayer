package com.company;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;

public class KeyChooser extends ComboBox {


    private static ObservableList<String> getOptions(){
        ObservableList<String> values = FXCollections.observableArrayList();
        for(String note : OptionsHolder.getNoteSymbols()){
            values.add(note);
        }
        return values;
    }

    public KeyChooser(){
        setPrefHeight(25);
        setPrefWidth(60);
        setBackground(new Background(new BackgroundFill(ColorPalette.CONTROLS_LIGHT_GREEN,new CornerRadii(5), null)));
        setItems(getOptions());
        setValue("C");

        // moves pitches on the whole key board
        setOnAction(event -> {
            OptionsHolder.setCurrentKeyNum(OptionsHolder.symbolToNoteNum((String)getValue()));
            MusicPlayer.updateAllNotePanes();
        });


    }
}
