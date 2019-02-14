package com.company;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class OutOfScaleNotesDisabledChooser extends Chooser{


    private static ObservableList<String> getOptions(){
        ObservableList<String> values = FXCollections.observableArrayList();
        values.add("true");
        values.add("false");
        return values;
    }

    public OutOfScaleNotesDisabledChooser(){
        super();
        setPrefWidth(150);
        setItems(getOptions());
        setValue(getOptions().get(1));

        setOnAction(event -> {
            OptionsHolder.setOutOfScaleNotesDisabled(Boolean.parseBoolean((String)getValue()));
            MusicPlayer.updateAllNotePanes();
        });


    }
}