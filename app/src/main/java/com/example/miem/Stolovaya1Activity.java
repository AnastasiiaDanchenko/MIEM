package com.example.miem;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class Stolovaya1Activity extends AppCompatActivity {

    private Button numbersButton = null;
    private ImageButton lestnitsaButton = null;
    private ImageButton stolovayaButton = null;
    private Button pauseButton = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stolovaya1);
        final MediaPlayer paperSound = MediaPlayer.create(this, R.raw.paper);
        final MediaPlayer lestnitsSound = MediaPlayer.create(this, R.raw.lestnitsa);

        numbersButton = findViewById(R.id.numbers_button);
        lestnitsaButton = findViewById(R.id.lestnitsa_button);
        stolovayaButton = findViewById(R.id.stolovaya_button);
        pauseButton = findViewById(R.id.pause_button);

        pauseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), PauseActivity.class);
                i.putExtra("okno", 18);
                startActivity(i);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            }
        });

        numbersButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                paperSound.start();
                Intent i = new Intent(v.getContext(), NumbersActivity.class);
                startActivity(i);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            }
        });

        lestnitsaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lestnitsSound.start();
                Intent i = new Intent(v.getContext(), LettersActivity.class);
                startActivity(i);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            }
        });

        stolovayaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), Stolovaya2Activity.class);
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
