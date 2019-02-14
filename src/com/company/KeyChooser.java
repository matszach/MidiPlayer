package com.company;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;

public class KeyChooser extends Chooser{


    private static ObservableList<String> getOptions(){
        ObservableList<String> values = FXCollections.observableArrayList();
        for(String note : OptionsHolder.getNoteSymbols()){
            values.add(note);
        }
        return values;
    }

    public KeyChooser(){
        super();
        setPrefWidth(60);
        setItems(getOptions());
        setValue("C");

        setOnAction(event -> {
            OptionsHolder.setCurrentKeyNum(OptionsHolder.symbolToNoteNum((String)getValue()));
            MusicPlayer.updateAllNotePanes();
        });


    }
}
