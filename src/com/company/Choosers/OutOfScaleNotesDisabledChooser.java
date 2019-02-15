package com.company.Choosers;

import com.company.MusicPlayer;
import com.company.OptionsHolder;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class OutOfScaleNotesDisabledChooser extends LabeledChooser{

    @Override
    public void restoreDefaultValue() {
        setValue(getOptions().get(1));
        OptionsHolder.setOutOfScaleNotesDisabled(Boolean.parseBoolean((String)getValue()));
    }

    private static ObservableList<String> getOptions(){
        ObservableList<String> values = FXCollections.observableArrayList();
        values.add("true");
        values.add("false");
        return values;
    }

    public OutOfScaleNotesDisabledChooser(int xLocation, int yLocation){
        super(xLocation, yLocation, "Disable out of scale notes?");
        setPrefWidth(150);
        setItems(getOptions());
        setValue(getOptions().get(1));

        setOnAction(event -> {
            OptionsHolder.setOutOfScaleNotesDisabled(Boolean.parseBoolean((String)getValue()));
            MusicPlayer.updateAllNotePanes();
        });


    }
}