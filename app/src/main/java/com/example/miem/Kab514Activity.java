package com.example.miem;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Kab514Activity extends AppCompatActivity {

    private Button kompButton = null;
    private Button printerButton = null;
    private ImageButton etazh5aButton = null;
    private Button pauseButton = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kab514);
        final MediaPlayer paperSound = MediaPlayer.create(this, R.raw.paper);
        SharedPreferences s_level = getSharedPreferences("levelSettings", MODE_PRIVATE);
        final int level = s_level.getInt("LEVEL", 1);

        printerButton = findViewById(R.id.printer_button);
        etazh5aButton = findViewById(R.id.etazh5a_button);
        kompButton = findViewById(R.id.komp_button);
        pauseButton = findViewById(R.id.pause_button);

        pauseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), PauseActivity.class);
                i.putExtra("okno", 11);
                startActivity(i);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            }
        });

        etazh5aButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), Etazh5aActivity.class);
                startActivity(i);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            }
        });

        printerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(level<5){
                    Toast toast = Toast.makeText(getApplicationContext(), "О, кажется, что-то недопечаталось...", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();
                }else{
                    paperSound.start();
                    Intent i = new Intent(v.getContext(), Lab2Activity.class);
                    startActivity(i);
                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                }
            }
        });

        kompButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), DiffurActivity.class);
                startActivity(i);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            }
        });

    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
    }
}
