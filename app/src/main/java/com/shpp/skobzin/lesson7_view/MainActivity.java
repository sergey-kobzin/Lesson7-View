package com.shpp.skobzin.lesson7_view;

import android.app.Activity;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Random;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Flag flag = (Flag) findViewById(R.id.flag);

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                flag.reDraw();
                handler.postDelayed(this, 3000);
            }
        }, 3000);
    }
}
