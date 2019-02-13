package com.company;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import javax.sound.midi.MidiChannel;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Synthesizer;

public class MusicPlayer extends Application {

    // root pane, the background of the app
    private static Pane root;

    // synthesizer and music channels for each row of NotePanes
    // (to allow 2 instances of the same note to be played at the same time)
    private static Synthesizer synthesizer;
    private static MidiChannel channel1;
    private static MidiChannel channel2;
    private static MidiChannel channel3;
    private static MidiChannel channel4;

    // panels divided in rows
    public static NotePane[] notePanesRow1 = new NotePane[12];
    public static NotePane[] notePanesRow2 = new NotePane[12];
    public static NotePane[] notePanesRow3 = new NotePane[11];
    public static NotePane[] notePanesRow4 = new NotePane[10];

    // note characters to be put on NotePanes
    private static char[] noteCharsRow1 ={'1','2','3','4','5','6','7','8','9','0','-','='};
    private static char[] noteCharsRow2 ={'Q','W','E','R','T','Y','U','I','O','P','[',']'};
    private static char[] noteCharsRow3 ={'A','S','D','F','G','H','J','K','L',';','\''};
    private static char[] noteCharsRow4 ={'Z','X','C','V','B','N','M',',','.','/'};

    // note numbers to be passed to NotePanes after adding the baseNoteValue to it
    private static int baseNoteValue = 45;
    private static int[] noteNumsRow1 ={15,16,17,18,19,20,21,22,23,24,25,26};
    private static int[] noteNumsRow2 ={10,11,12,13,14,15,16,17,18,19,20,21};
    private static int[] noteNumsRow3 ={5,6,7,8,9,10,11,12,13,14,15};
    private static int[] noteNumsRow4 ={0,1,2,3,4,5,6,7,8,9};


    // init. root, synthesizer and channels
    static {
        root = new Pane();
        root.setBackground(new Background(new BackgroundFill(ColorPalette.BCG_LIGHT_GREEN, null, null)));

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

    private static void buildNotePaneRow(NotePane[] notePanesRow, char[] noteCharsRow, int[] noteNumsRow, MidiChannel channel){
        for(int i = 0; i<notePanesRow.length; i++){
            notePanesRow[i] = new NotePane(noteCharsRow[i], noteNumsRow[i]+baseNoteValue, channel);
        }
    }
    private static void placeNotePaneRow(NotePane[] notePanesRow, double originX, double originY){
        for(int i = 0; i<notePanesRow.length; i++){
            notePanesRow[i].relocate(originX+(NotePane.SIDE_LENGTH+5)*i, originY);
            root.getChildren().add(notePanesRow[i]);
        }
    }

    @Override
    public void start(Stage primaryStage) {

        primaryStage.setScene(new Scene(root, 780,420));
        primaryStage.setResizable(false);
        primaryStage.show();


        buildNotePaneRow(notePanesRow1, noteCharsRow1, noteNumsRow1, channel1);
        placeNotePaneRow(notePanesRow1, 45,170);

        buildNotePaneRow(notePanesRow2, noteCharsRow2, noteNumsRow2, channel2);
        placeNotePaneRow(notePanesRow2, 70,225);

        buildNotePaneRow(notePanesRow3, noteCharsRow3, noteNumsRow3, channel3);
        placeNotePaneRow(notePanesRow3, 85,280);

        buildNotePaneRow(notePanesRow4, noteCharsRow4, noteNumsRow4, channel4);
        placeNotePaneRow(notePanesRow4, 110,335);

        KeyMapper.mapKeys(primaryStage.getScene());


    }

    public static void main(String[] args) {
        launch(args);

    }
}
