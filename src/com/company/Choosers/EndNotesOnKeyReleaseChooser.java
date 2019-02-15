package com.company.Choosers;

import com.company.MusicPlayer;
import com.company.OptionsHolder;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class EndNotesOnKeyReleaseChooser extends LabeledChooser {


    private static ObservableList<String> getOptions(){
        ObservableList<String> values = FXCollections.observableArrayList();
        values.add("true");
        values.add("false");
        return values;
    }

    public EndNotesOnKeyReleaseChooser(int xLocation, int yLocation){
        super(xLocation, yLocation, "End notes on key release?");
        setPrefWidth(130);
        setItems(getOptions());
        setValue(getOptions().get(0));

        setOnAction(event -> {
            OptionsHolder.setEndNotesOnKeyRelease(Boolean.parseBoolean((String)getValue()));
            MusicPlayer.updateAllNotePanes();
        });


    }
}