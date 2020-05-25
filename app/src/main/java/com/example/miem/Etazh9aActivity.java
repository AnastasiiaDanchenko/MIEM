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
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Etazh9aActivity extends AppCompatActivity {

    private ImageButton oknoButton = null;
    private ImageButton labButton = null;
    private ImageView backImage;
    private Button pauseButton = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_etazh9a);
        final MediaPlayer lestnitsaSound = MediaPlayer.create(this, R.raw.lestnitsa);
        SharedPreferences s_level = getSharedPreferences("levelSettings", MODE_PRIVATE);
        final int level = s_level.getInt("LEVEL", 1);

        if(level<4){
            Toast toast = Toast.makeText(getApplicationContext(), "9 этаж, административный корпус", Toast.LENGTH_LONG);
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.show();
        }

        backImage = findViewById(R.id.back_image);
        oknoButton = findViewById(R.id.okno_button);
        labButton = findViewById(R.id.lab_button);
        pauseButton = findViewById(R.id.pause_button);

        pauseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), PauseActivity.class);
                i.putExtra("okno", 5);
                startActivity(i);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            }
        });

        labButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), Lab1Activity.class);
                startActivity(i);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            }
        });

        oknoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                oknoButton.setVisibility(View.INVISIBLE);
                labButton.setVisibility(View.INVISIBLE);
                backImage.setImageResource(R.drawable.lestnica);
                lestnitsaSound.start();

                Intent i = new Intent(v.getContext(), OknoActivity.class);
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
