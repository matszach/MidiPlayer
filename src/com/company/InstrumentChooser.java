package com.company;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class InstrumentChooser extends Chooser {

    private static ObservableList<String> getOptions(){
        ObservableList<String> values = FXCollections.observableArrayList();
        for(int i = 1; i <= 128; i++){
            values.add(""+i);
        }
        return values;
    }

    public InstrumentChooser(){
        super();
        setPrefWidth(150);
        setItems(getOptions());
        setValue("1");

        setOnAction(event -> {
            MusicPlayer.changeInstrument(Integer.parseInt((String)getValue()));
            MusicPlayer.updateAllNotePanes();
        });


    }
}