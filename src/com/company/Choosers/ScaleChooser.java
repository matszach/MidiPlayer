package com.company.Choosers;

import com.company.MusicPlayer;
import com.company.OptionsHolder;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.Arrays;


public class ScaleChooser extends LabeledChooser {

    private static ObservableList<String> getOptions(){
        ObservableList<String> values = FXCollections.observableArrayList();
        values.addAll(Arrays.asList(OptionsHolder.getScaleNames()));
        return values;
    }

    public ScaleChooser(int xLocation, int yLocation){
        super(xLocation, yLocation, "Scale:");
        setPrefWidth(150);
        setItems(getOptions());
        setValue(getOptions().get(0));

        setOnAction(event -> {
            OptionsHolder.setCurrentScale(OptionsHolder.nameToIntArray((String)getValue()));
            MusicPlayer.updateAllNotePanes();
        });


    }
}
