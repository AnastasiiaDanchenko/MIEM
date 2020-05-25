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

public class Kab412Activity extends AppCompatActivity {


    private Button labButton = null;
    private ImageButton kabButton = null;
    private ImageButton koridorButton = null;
    private ImageView backImage;
    private Button pauseButton = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kab412);
        final MediaPlayer liftSound = MediaPlayer.create(this, R.raw.lift);
        final MediaPlayer paperSound = MediaPlayer.create(this, R.raw.paper);
        SharedPreferences s_level = getSharedPreferences("levelSettings", MODE_PRIVATE);
        final int level = s_level.getInt("LEVEL", 1);

        if(level<=12) {
            Toast toast = Toast.makeText(getApplicationContext(), "Кажется, кто-то бумажку обронил", Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.show();
        }

        backImage = findViewById(R.id.back_image);
        labButton = findViewById(R.id.lab_button);
        kabButton = findViewById(R.id.kab504_button);
        koridorButton = findViewById(R.id.koridor_button);
        pauseButton = findViewById(R.id.pause_button);

        pauseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), PauseActivity.class);
                i.putExtra("okno", 8);
                startActivity(i);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            }
        });

        labButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                paperSound.start();
                Intent i = new Intent(v.getContext(), Lab6Activity.class);
                startActivity(i);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            }
        });

        koridorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                labButton.setVisibility(View.INVISIBLE);
                kabButton.setVisibility(View.INVISIBLE);
                koridorButton.setVisibility(View.INVISIBLE);
                backImage.setImageResource(R.drawable.lift);
                liftSound.start();

                Intent i = new Intent(v.getContext(), Koridor1Activity.class);
                i.putExtra("bufet",1);
                startActivity(i);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            }
        });

        kabButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                labButton.setVisibility(View.INVISIBLE);
                kabButton.setVisibility(View.INVISIBLE);
                koridorButton.setVisibility(View.INVISIBLE);
                backImage.setImageResource(R.drawable.lift);
                liftSound.start();

                Intent i = new Intent(v.getContext(), Kab504nizActivity.class);
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
