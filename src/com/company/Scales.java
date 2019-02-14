package com.company;

public class Scales {

    private static String[] noteSymbols = new String[]{"C","C#","D","D#","E","F","F#","G","G#","A","A#","B"};
    public static String[] getNoteSymbols() {
        return noteSymbols;
    }

    // Scales
    public static final int[] MAJOR = new int[]{0,2,4,5,7,9,11};
    public static final int[] MINOR = new int[]{0,2,3,5,7,8,10};
    public static final int[] HARMONIC_MINOR = new int[]{0,2,3,5,7,8,11};
    public static final int[] HUNGARIAN_MINOR = new int[]{0,2,3,6,7,8,11};
    public static final int[] WHOLE_TONE_MINOR = new int[]{0,2,4,6,8,10};
    public static final int[] DIMINISHED = new int[]{0,2,3,5,6,8,9,11};


    private static int[] currentScale = MAJOR;
    public static void setCurrentScale(int[] currentScale) {
        Scales.currentScale = currentScale;
    }
    public static int[] getCurrentScale() {
        return currentScale;
    }

    private Scales(){}
    private Scales scales = new Scales();
}
