package com.company;

import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

import javax.sound.midi.MidiChannel;

public class NotePane extends Pane {

    // final static appearance values
    public static final int SIDE_LENGTH = 50;
    private static final CornerRadii PANE_RADII = new CornerRadii(10);

    // "what-button-to-press" label
    private Text keyCharText = new Text();

    // "what-note-will-be-played" label
    private Text noteSymbolText = new Text();
    private String decideNoteSymbol(){
        int noteNumDivRest = (noteNum + OptionsHolder.getBaseNoteValue()) % 12;
        return Scales.getNoteSymbols()[noteNumDivRest];
    }

    // note number for note to be emitted
    private int noteNum;
    private int getNotePlayed(){
        return noteNum+OptionsHolder.getBaseNoteValue();
    }

    // midi channel for for the note to be played on
    private MidiChannel midiChannel;

    // to prevent tote to start if it already in play
    private boolean isOn;

    // lets out the midi note and highlights the NotePane
    public void noteOn(){
        if(!isOn){
            midiChannel.noteOn(getNotePlayed(), 120);
            setBackground(new Background(new BackgroundFill(getOnColor(), PANE_RADII, null)));
            isOn = true;
        }
    }

    // stops the note and un-highlights the NotePAne
    public void noteOff(){
        if(isOn){
            midiChannel.noteOff(getNotePlayed());
            setBackground(new Background(new BackgroundFill(getOffColor(), PANE_RADII, null)));
            isOn = false;
        }
    }

    // checks if the note-to-be-played is in the current scale
    private boolean isInCurrentScale(){
        for(int i : Scales.getCurrentScale()){
            if(i == getNotePlayed()%12){
                return true;
            }
        }
        return false;
    }

    // decide color
    private Color getOnColor(){
        if(isInCurrentScale()){
            return ColorPalette.BTN_ON_BLUE;
        } else {
            return ColorPalette.BTN_ON_GREEN;
        }
    }
    private Color getOffColor(){
        if(isInCurrentScale()){
            return ColorPalette.BTN_OFF_BLUE;
        } else {
            return ColorPalette.BTN_OFF_GREEN;
        }
    }



    public NotePane(char keyChar, int noteNum, MidiChannel channel){

        this.noteNum = noteNum;
        this.midiChannel = channel;

        setPrefSize(SIDE_LENGTH, SIDE_LENGTH);
        setBackground(new Background(new BackgroundFill(getOffColor(), PANE_RADII, null)));

        getChildren().addAll(keyCharText, noteSymbolText);

        keyCharText.setText(""+keyChar);
        keyCharText.relocate(3,0);
        keyCharText.setStyle(" -fx-font-size: 10;");
        keyCharText.setFill(Color.LIGHTGRAY);

        noteSymbolText.setText(decideNoteSymbol());
        noteSymbolText.relocate(15,22);
        noteSymbolText.setStyle(" -fx-font-size: 22;");

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
