package com.company;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class PitchChooser extends Chooser {

    private static ObservableList<String> getOptions(){
        ObservableList<String> values = FXCollections.observableArrayList();
        for(int i = -36; i <= 36; i++){
            values.add(""+i);
        }
        return values;
    }

    public PitchChooser(){
        super();
        setPrefWidth(60);
        setItems(getOptions());
        setValue(getOptions().get(getOptions().size()/2));

        // moves pitches on the whole key board
        setOnAction(event -> {
            OptionsHolder.adjustBaseNoteValue(Integer.parseInt((String)getValue()));
            MusicPlayer.updateAllNotePanes();
        });


    }
}
