package com.hardcodedjoy.example.hellofullscreen;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        goFullscreen();

        setContentView(R.layout.layout_main);
    }

    private void goFullscreen() {
        Window window = getWindow();
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        window.clearFlags(WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN);
        window.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        // extra-fullscreen: also cover camera hole
        // see file styles.xml (v27)

        // extra-fullscreen: also cover navigation buttons
        // they will reappear when swiped from the bottom of the screen
        window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);

        // alternatively, to extend the app GUI and also draw the navigation buttons on top:
        // window.addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
    }
}