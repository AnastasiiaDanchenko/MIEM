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

public class LettersActivity extends AppCompatActivity {

    private ImageButton atriumButton = null;
    private ImageButton liftButton = null;
    private ImageButton lestnitsaButton = null;
    private ImageView backImage;
    private Button pauseButton = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_letters);
        final MediaPlayer liftSound = MediaPlayer.create(this, R.raw.lift);

        SharedPreferences s_level = getSharedPreferences("levelSettings", MODE_PRIVATE);
        final int level = s_level.getInt("LEVEL", 1);

        backImage = findViewById(R.id.back_image);
        atriumButton = findViewById(R.id.atrium_button);
        liftButton = findViewById(R.id.etazh5a_button);
        lestnitsaButton = findViewById(R.id.lestnitsa_button);
        pauseButton = findViewById(R.id.pause_button);

        pauseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), PauseActivity.class);
                i.putExtra("okno", 16);
                startActivity(i);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            }
        });

        atriumButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (level >= 8) {
                    Intent i = new Intent(v.getContext(), AtriumActivity.class);
                    startActivity(i);
                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                }else{
                    Toast toast = Toast.makeText(getApplicationContext(), "В столовку бы заглянуть...", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();
                }
            }
        });

        liftButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                atriumButton.setVisibility(View.INVISIBLE);
                lestnitsaButton.setVisibility(View.INVISIBLE);
                liftButton.setVisibility(View.INVISIBLE);
                backImage.setImageResource(R.drawable.lift);
                liftSound.start();

                Intent i = new Intent(v.getContext(), Etazh5aActivity.class);
                startActivity(i);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            }
        });

        lestnitsaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), LestnitsaActivity.class);
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
