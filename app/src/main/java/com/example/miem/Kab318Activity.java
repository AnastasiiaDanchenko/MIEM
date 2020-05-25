package com.example.miem;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Kab318Activity extends AppCompatActivity {

    private Button taskButton = null;
    private ImageButton lestnitsaButton = null;
    private ImageButton kabButton = null;
    private ImageView backImage;
    private Button pauseButton = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kab318);
        final MediaPlayer lestnitsSound = MediaPlayer.create(this, R.raw.lestnitsa);

        backImage = findViewById(R.id.back_image);
        taskButton = findViewById(R.id.task_button);
        lestnitsaButton = findViewById(R.id.koridor_button);
        kabButton = findViewById(R.id.kab_button);
        pauseButton = findViewById(R.id.pause_button);

        pauseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), PauseActivity.class);
                i.putExtra("okno", 6);
                startActivity(i);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            }
        });

        taskButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), TaskActivity.class);
                startActivity(i);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            }
        });

        lestnitsaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                taskButton.setVisibility(View.INVISIBLE);
                lestnitsaButton.setVisibility(View.INVISIBLE);
                kabButton.setVisibility(View.INVISIBLE);
                backImage.setImageResource(R.drawable.lestnica);
                lestnitsSound.start();

                Intent i = new Intent(v.getContext(), Koridor2Activity.class);
                startActivity(i);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            }
        });

        kabButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(getApplicationContext(), "Аудитория 323", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();
                Intent i = new Intent(v.getContext(), Kab323Activity.class);
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
