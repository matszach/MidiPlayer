package com.company.Choosers;

import com.company.MusicPlayer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class KeyPatternChooser extends LabeledChooser{


    private static ObservableList<String> getOptions(){
        ObservableList<String> values = FXCollections.observableArrayList();
        values.addAll("keyboard","grid");
        return values;
    }

    public KeyPatternChooser(int xLocation, int yLocation){
        super(xLocation, yLocation, "Key pattern:");
        setPrefWidth(100);
        setItems(getOptions());
        setValue(getOptions().get(0));

        setOnAction(event -> {
            if( (getValue()).equals(getOptions().get(0)) ){
                MusicPlayer.arrangeNotePanesInKeyboardPattern();
            } else if( (getValue()).equals(getOptions().get(1)) ){
                MusicPlayer.arrangeNotePanesInGridPattern();
            }
            MusicPlayer.updateAllNotePanes();
        });


    }
}
