package com.example.nolose;

import android.os.Bundle;
import android.app.Activity;
import android.view.Window;

public class Main extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Quitar el titulo
        requestWindowFeature(Window.FEATURE_NO_TITLE);
      //this referencia al activity
        setContentView(new GameView(this));
    }


    
}
