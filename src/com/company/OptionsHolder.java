package com.company;

public class OptionsHolder {


    // base note value (keys add their note value to base note when they release a note to the channel)
    // a value divisible by 12 here makes the lowest note (corresponding to the "Z" key) a C
    private static int baseNoteValue = 36;
    public static void setBaseNoteValue(int baseNoteValue) {
        OptionsHolder.baseNoteValue = baseNoteValue;
    }
    public static int getBaseNoteValue() {
        return baseNoteValue;
    }









    private OptionsHolder(){}
    private static OptionsHolder optionsHolder = new OptionsHolder();
}
