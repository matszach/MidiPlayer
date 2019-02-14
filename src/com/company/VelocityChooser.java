package com.company;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class VelocityChooser extends Chooser {

    private static ObservableList<String> getOptions(){
        ObservableList<String> values = FXCollections.observableArrayList();
        for(int i = 10; i <= 200; i+=10){
            values.add(""+i);
        }
        return values;
    }

    public VelocityChooser(){
        super();
        setPrefWidth(90);
        setItems(getOptions());
        setValue(getOptions().get(9));

        // moves pitches on the whole key board
        setOnAction(event -> {
            OptionsHolder.setNoteVelocity(Integer.parseInt((String)getValue()));
            MusicPlayer.updateAllNotePanes();
        });


    }
}
