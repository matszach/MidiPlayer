package com.company;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class InstrumentChooser extends Chooser {

    private static ObservableList<String> getOptions(){
        ObservableList<String> values = FXCollections.observableArrayList();
        for(int i = 0; i <= 127; i++){
            values.add(i+".  "+MusicPlayer.getSynthesizer().getLoadedInstruments()[i].getName());
        }
        return values;
    }

    private int extractInstrumentNumber(){
        StringBuilder itemNumString = new StringBuilder();
        for(int i = 0;((String)getValue()).charAt(i)!='.';i++){
            itemNumString.append(((String)getValue()).charAt(i));
        }
        return Integer.parseInt(itemNumString.toString());
    }

    public InstrumentChooser(){
        super();
        setPrefWidth(150);
        setItems(getOptions());
        setValue("0");

        setOnAction(event -> {
            MusicPlayer.changeInstrument(extractInstrumentNumber());
            MusicPlayer.updateAllNotePanes();
        });


    }
}