package com.company;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class ScaleChooser extends Chooser {

    private static ObservableList<String> getOptions(){
        ObservableList<String> values = FXCollections.observableArrayList();
        for(String scaleName : OptionsHolder.getScaleNames()){
            values.add(scaleName);
        }
        return values;
    }

    public ScaleChooser(){
        super();
        setPrefWidth(150);
        setItems(getOptions());
        setValue("Major");

        // moves pitches on the whole key board
        setOnAction(event -> {
            OptionsHolder.setCurrentScale(OptionsHolder.nameTointArray((String)getValue()));
            MusicPlayer.updateAllNotePanes();
        });


    }
}
