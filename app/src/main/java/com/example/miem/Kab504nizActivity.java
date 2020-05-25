package com.example.miem;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class Kab504nizActivity extends AppCompatActivity {

    private Button historyButton = null;
    private ImageButton kabButton = null;
    private ImageButton koridorButton = null;
    private ImageView backImage;
    private Button pauseButton = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kab504niz);
        final MediaPlayer lestnitsSound = MediaPlayer.create(this, R.raw.lestnitsa);
        final MediaPlayer liftsSound = MediaPlayer.create(this, R.raw.lift);

        historyButton = findViewById(R.id.history_button);
        kabButton = findViewById(R.id.kab412_button);
        koridorButton = findViewById(R.id.koridor_button);
        backImage = findViewById(R.id.back_image);
        pauseButton = findViewById(R.id.pause_button);

        pauseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), PauseActivity.class);
                i.putExtra("okno", 9);
                startActivity(i);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            }
        });

        koridorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lestnitsSound.start();
                Intent i = new Intent(v.getContext(), Kab504verhActivity.class);
                startActivity(i);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            }
        });

        kabButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                historyButton.setVisibility(View.INVISIBLE);
                kabButton.setVisibility(View.INVISIBLE);
                koridorButton.setVisibility(View.INVISIBLE);
                backImage.setImageResource(R.drawable.lift);
                liftsSound.start();

                Intent i = new Intent(v.getContext(), Kab412Activity.class);
                startActivity(i);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            }
        });

        historyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), HistoryActivity.class);
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
