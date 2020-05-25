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

public class Etazh5aActivity extends AppCompatActivity {

    private ImageButton liftButton = null;
    private ImageButton kabButton = null;
    private ImageButton oknoButton = null;
    private ImageView backImage;
    private Button pauseButton = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_etazh5a);
        final MediaPlayer liftSound = MediaPlayer.create(this, R.raw.lift);
        SharedPreferences s_level = getSharedPreferences("levelSettings", MODE_PRIVATE);
        final int level = s_level.getInt("LEVEL", 1);

        if(level<5){
            Toast toast = Toast.makeText(getApplicationContext(), "5 этаж, административный корпус", Toast.LENGTH_LONG);
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.show();
        }

        oknoButton = findViewById(R.id.okno_button);
        backImage = findViewById(R.id.back_image);
        liftButton = findViewById(R.id.lift_button);
        kabButton = findViewById(R.id.kab_button);pauseButton = findViewById(R.id.pause_button);

        pauseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), PauseActivity.class);
                i.putExtra("okno", 3);
                startActivity(i);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            }
        });

        liftButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (level < 5) {
                    Toast toast = Toast.makeText(getApplicationContext(), "Думаю, в этом корпусе ещё есть чем заняться.", Toast.LENGTH_LONG);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();
                }else {
                    liftButton.setVisibility(View.INVISIBLE);
                    kabButton.setVisibility(View.INVISIBLE);
                    backImage.setImageResource(R.drawable.lift);
                    liftSound.start();

                    Intent i = new Intent(v.getContext(), LettersActivity.class);
                    startActivity(i);
                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                }
            }
        });

        oknoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                kabButton.setVisibility(View.INVISIBLE);
                oknoButton.setVisibility(View.INVISIBLE);
                liftButton.setVisibility(View.INVISIBLE);
                backImage.setImageResource(R.drawable.lift);
                liftSound.start();

                Intent i = new Intent(v.getContext(), OknoActivity.class);
                startActivity(i);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            }
        });

        kabButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), Kab514Activity.class);
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
