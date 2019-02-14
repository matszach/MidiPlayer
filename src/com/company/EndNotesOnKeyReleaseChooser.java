package com.company;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class EndNotesOnKeyReleaseChooser extends Chooser {


    private static ObservableList<String> getOptions(){
        ObservableList<String> values = FXCollections.observableArrayList();
        values.add("true");
        values.add("false");
        return values;
    }

    public EndNotesOnKeyReleaseChooser(){
        super();
        setPrefWidth(130);
        setItems(getOptions());
        setValue(getOptions().get(0));

        setOnAction(event -> {
            OptionsHolder.setEndNotesOnKeyRelease(Boolean.parseBoolean((String)getValue()));
            MusicPlayer.updateAllNotePanes();
        });


    }
}