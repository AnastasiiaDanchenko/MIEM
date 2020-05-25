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

public class Koridor2Activity extends AppCompatActivity {
    private ImageButton codButton = null;
    private ImageButton kab318Button = null;
    private ImageView backImage;
    private Button pauseButton = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_koridor2);
        final MediaPlayer lestnitsaSound = MediaPlayer.create(this, R.raw.lestnitsa);
        SharedPreferences s_level = getSharedPreferences("levelSettings", MODE_PRIVATE);
        final int level = s_level.getInt("LEVEL", 1);

        backImage = findViewById(R.id.back_image);
        kab318Button = findViewById(R.id.lestnitsa_button);
        codButton = findViewById(R.id.cod_button);
        pauseButton = findViewById(R.id.pause_button);

        pauseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), PauseActivity.class);
                i.putExtra("okno", 13);
                startActivity(i);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            }
        });

        kab318Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(level<11){
                    Toast toast = Toast.makeText(getApplicationContext(), "Хм, а что за той дверью?", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();
                }else {
                    kab318Button.setVisibility(View.INVISIBLE);
                    codButton.setVisibility(View.INVISIBLE);
                    backImage.setImageResource(R.drawable.lestnica);
                    lestnitsaSound.start();

                    Intent i = new Intent(v.getContext(), Kab318Activity.class);
                    startActivity(i);
                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                    Toast toast = Toast.makeText(getApplicationContext(), "Аудитория 318", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();
                }
            }
        });

        codButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), CodActivity.class);
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
