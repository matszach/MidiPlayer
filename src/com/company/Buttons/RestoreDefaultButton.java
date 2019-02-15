package com.company.Buttons;

import com.company.MusicPlayer;

public class RestoreDefaultButton extends AppButton {

    @Override
    public void onAction() {
        MusicPlayer.restoreDefault();
    }

    public RestoreDefaultButton(int xLocation, int yLocation){
        super(xLocation,yLocation,"Restore default");
        setPrefWidth(100);
    }
}
