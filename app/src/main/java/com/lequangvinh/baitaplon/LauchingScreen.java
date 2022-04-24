package com.lequangvinh.baitaplon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class LauchingScreen extends AppCompatActivity {
    Thread thread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lauching_screen);
        thread = (Thread) run()  {
            super.run();
            int waited = 0;
            while (waited < 2000) {
                try {
                    thread.sleep();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                waited += 100;
            }
            Intent intent = new Intent(LauchingScreen.this, MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
            startActivity(intent);
            finish();
        }
        ;
        thread.start();
    }
}