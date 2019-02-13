package com.company;

import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

import javax.sound.midi.MidiChannel;

public class NotePane extends Pane {

    // final static appearance values
    public static final int SIDE_LENGTH = 50;
    private static final CornerRadii PANE_RADII = new CornerRadii(10);

    // "what-button-to-press" label
    private Text keyCharText = new Text();

    // note number for note to be emitted
    private int noteNum;

    // midi channel for for the note to be played on
    private MidiChannel midiChannel;

    // to prevent tote to start if it already in play
    private boolean isOn;

    // lets out the midi note and highlights the NotePane
    public void noteOn(){
        if(!isOn){
            midiChannel.noteOn(noteNum, 200);
            setBackground(new Background(new BackgroundFill(ColorPalette.BTN_ON_GREEN, PANE_RADII, null)));
            isOn = true;
        }
    }

    // stops the note and un-highlights the NotePAne
    public void noteOff(){
        if(isOn){
            midiChannel.noteOff(noteNum);
            setBackground(new Background(new BackgroundFill(ColorPalette.BTN_OFF_GREEN, PANE_RADII, null)));
            isOn = false;
        }
    }



    public NotePane(char keyChar, int noteNum, MidiChannel channel){

        setPrefSize(SIDE_LENGTH, SIDE_LENGTH);
        setBackground(new Background(new BackgroundFill(ColorPalette.BTN_OFF_GREEN, PANE_RADII, null)));

        keyCharText.setText(""+keyChar);
        keyCharText.relocate(2,2);
        getChildren().add(keyCharText);

        this.noteNum = noteNum;
        this.midiChannel = channel;

        setOnMousePressed(e->{
            if(!e.isPrimaryButtonDown()){
                return;
            }
            e.setDragDetect(true);
            noteOn();
        });

        setOnMouseReleased(e->{
            if(e.isPrimaryButtonDown()){
                return;
            }
            noteOff();
        });

        setOnMouseDragged(e->{
            e.setDragDetect(false);
        });

        setOnDragDetected(e-> {
            startFullDrag();
        });

        setOnMouseDragEntered(e-> {
            if(!e.isPrimaryButtonDown()){
                return;
            }
            noteOn();
        });

        setOnMouseDragExited(e-> {
            noteOff();
        });

        setOnMouseExited(e->{
            if(!e.isPrimaryButtonDown()){
                return;
            }
            noteOff();
        });



    }
}
