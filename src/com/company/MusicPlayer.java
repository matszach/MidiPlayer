package com.company;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import javax.sound.midi.MidiChannel;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Synthesizer;

public class MusicPlayer extends Application {

    // root pane, the background of the app
    private static Pane root = new Pane();

    // synthesizer and music channels for each row of NotePanes
    // (to allow 2 instances of the same note to be played at the same time)
    private static Synthesizer synthesizer;
    public static Synthesizer getSynthesizer() {
        return synthesizer;
    }

    private static MidiChannel channel1;
    private static MidiChannel channel2;
    private static MidiChannel channel3;
    private static MidiChannel channel4;

    // init. root, synthesizer and channels
    static {
        root.setBackground(new Background(new BackgroundFill(ColorPalette.BCG_LIGHT_GRUE, null, null)));

        try {
            synthesizer = MidiSystem.getSynthesizer();
            synthesizer.open();
            channel1 = synthesizer.getChannels()[0];
            channel2 = synthesizer.getChannels()[1];
            channel3 = synthesizer.getChannels()[2];
            channel4 = synthesizer.getChannels()[3];
        } catch (MidiUnavailableException e){
            e.printStackTrace();
        }
    }

    public static void changeInstrument(int instrumentNum){
        channel1.programChange(instrumentNum);
        channel2.programChange(instrumentNum);
        channel3.programChange(instrumentNum);
        channel4.programChange(instrumentNum);
    }

    // silences all ongoing notes
    public static void silienceAll(){
        channel1.allSoundOff();
        channel2.allSoundOff();
        channel3.allSoundOff();
        channel4.allSoundOff();

    }

    // panels divided in rows
    public static NotePane[] notePanesRow1 = new NotePane[12];
    public static NotePane[] notePanesRow2 = new NotePane[12];
    public static NotePane[] notePanesRow3 = new NotePane[11];
    public static NotePane[] notePanesRow4 = new NotePane[10];

    // note numbers to be passed to NotePanes after adding the baseNoteValue to it
    private static int[] noteNumsRow1 ={15,16,17,18,19,20,21,22,23,24,25,26};
    private static int[] noteNumsRow2 ={10,11,12,13,14,15,16,17,18,19,20,21};
    private static int[] noteNumsRow3 ={5,6,7,8,9,10,11,12,13,14,15};
    private static int[] noteNumsRow4 ={0,1,2,3,4,5,6,7,8,9};

    // notes in order                      :  C  C# D  D# E  F  F# G  G# A  A#  B   C
    // corresponding note nums modifiers   :  0 +1 +2 +3 +4 +5 +6 +7 +8 +9 +10 +11 +12

    private static void buildNotePaneRow(NotePane[] notePanesRow, char[] noteCharsRow, int[] noteNumsRow, MidiChannel channel){
        for(int i = 0; i<notePanesRow.length; i++){
            notePanesRow[i] = new NotePane(noteCharsRow[i], noteNumsRow[i], channel);
        }
    }
    private static void placeNotePaneRow(NotePane[] notePanesRow, double originX, double originY){
        for(int i = 0; i<notePanesRow.length; i++){
            notePanesRow[i].relocate(originX+(NotePane.SIDE_LENGTH+5)*i, originY);
            root.getChildren().add(notePanesRow[i]);
        }
    }

    static {
        buildNotePaneRow(notePanesRow1, KeyMapper.NOTE_CHARS_ROW_1, noteNumsRow1, channel1);
        placeNotePaneRow(notePanesRow1, 45,170);
        buildNotePaneRow(notePanesRow2, KeyMapper.NOTE_CHARS_ROW_2, noteNumsRow2, channel2);
        placeNotePaneRow(notePanesRow2, 70,225);
        buildNotePaneRow(notePanesRow3, KeyMapper.NOTE_CHARS_ROW_3, noteNumsRow3, channel3);
        placeNotePaneRow(notePanesRow3, 85,280);
        buildNotePaneRow(notePanesRow4, KeyMapper.NOTE_CHARS_ROW_4, noteNumsRow4, channel4);
        placeNotePaneRow(notePanesRow4, 110,335);
    }

    // pitch chooser
    private static Text pitchChooserLabel = new Text("Pitch offset");
    private static PitchChooser pitchChooser = new PitchChooser();
    static {
        pitchChooserLabel.relocate(50,30);
        pitchChooser.relocate(50, 50);
        root.getChildren().addAll(pitchChooserLabel,pitchChooser);
    }

    // key chooser
    private static Text keyChooserLabel = new Text("Key");
    private static KeyChooser keyChooser = new KeyChooser();
    static {
        keyChooserLabel.relocate(130,30);
        keyChooser.relocate(130, 50);
        root.getChildren().addAll(keyChooserLabel,keyChooser);
    }

    // scale chooser
    private static Text scaleChooserLabel = new Text("Scale");
    private static ScaleChooser scaleChooser = new ScaleChooser();
    static {
        scaleChooserLabel.relocate(210,30);
        scaleChooser.relocate(210, 50);
        root.getChildren().addAll(scaleChooserLabel,scaleChooser);
    }

    // instrument chooser
    private static Text instrumentChooserLabel = new Text("Instrument");
    private static InstrumentChooser instrumentChooser = new InstrumentChooser();
    static {
        instrumentChooserLabel.relocate(380,30);
        instrumentChooser.relocate(380, 50);
        root.getChildren().addAll(instrumentChooserLabel,instrumentChooser);
    }

    // end notes on key release chooser
    private static Text endNotesOnKeyReleaseChooserLabel = new Text("End note on key release");
    private static EndNotesOnKeyReleaseChooser endNotesOnKeyReleaseChooser = new EndNotesOnKeyReleaseChooser();
    static {
        endNotesOnKeyReleaseChooserLabel.relocate(550,30);
        endNotesOnKeyReleaseChooser.relocate(550, 50);
        root.getChildren().addAll(endNotesOnKeyReleaseChooserLabel, endNotesOnKeyReleaseChooser);
    }

    // notes out of scale disable chooser
    private static Text outOfScaleNotesDisabledChooserLabel = new Text("Out of scale notes disabled");
    private static OutOfScaleNotesDisabledChooser outOfScaleNotesDisabledChooser = new OutOfScaleNotesDisabledChooser();
    static {
        outOfScaleNotesDisabledChooserLabel.relocate(50,90);
        outOfScaleNotesDisabledChooser.relocate(50, 110);
        root.getChildren().addAll(outOfScaleNotesDisabledChooserLabel, outOfScaleNotesDisabledChooser);
    }

    // velocity of the note released
    private static Text velocityChooserLabel = new Text("Note velocity");
    private static VelocityChooser velocityChooser = new VelocityChooser();
    static {
        velocityChooserLabel.relocate(220,90);
        velocityChooser.relocate(220,110);
        root.getChildren().addAll(velocityChooserLabel,velocityChooser);
    }



    // updates all NotePanes after a change in the options
    public static void updateAllNotePanes(){
        for(NotePane np : notePanesRow1){
            np.updateDisplay();
        }
        for(NotePane np : notePanesRow2){
            np.updateDisplay();
        }
        for(NotePane np : notePanesRow3){
            np.updateDisplay();
        }
        for(NotePane np : notePanesRow4){
            np.updateDisplay();
        }
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setScene(new Scene(root, 780,420));
        primaryStage.setResizable(false);
        primaryStage.show();

        KeyMapper.mapKeys(primaryStage.getScene());
    }

    public static void main(String[] args) {
        launch(args);

    }
}
