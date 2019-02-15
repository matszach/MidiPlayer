package com.company.Choosers;

import com.company.MusicPlayer;
import com.company.OptionsHolder;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.Arrays;

public class KeyChooser extends LabeledChooser{


    private static ObservableList<String> getOptions(){
        ObservableList<String> values = FXCollections.observableArrayList();
        values.addAll(Arrays.asList(OptionsHolder.getNoteSymbols()));
        return values;
    }

    public KeyChooser(int xLocation, int yLocation){
        super(xLocation, yLocation, "Key:");
        setPrefWidth(60);
        setItems(getOptions());
        setValue(getOptions().get(0));

        setOnAction(event -> {
            OptionsHolder.setCurrentKeyNum(OptionsHolder.symbolToNoteNum((String)getValue()));
            MusicPlayer.updateAllNotePanes();
        });


    }
}
