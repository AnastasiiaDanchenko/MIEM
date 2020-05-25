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

public class Kab323Activity extends AppCompatActivity {

    private Button dep2Button = null;
    private ImageButton lestnitsaButton = null;
    private ImageButton kabButton = null;
    private ImageView backImage;
    private Button pauseButton = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kab323);
        final MediaPlayer lestnitsSound = MediaPlayer.create(this, R.raw.lestnitsa);
        SharedPreferences s_level = getSharedPreferences("levelSettings", MODE_PRIVATE);
        final int level = s_level.getInt("LEVEL", 1);

        backImage = findViewById(R.id.back_image);
        dep2Button = findViewById(R.id.dep2_button);
        lestnitsaButton = findViewById(R.id.lestnitsa_button);
        kabButton = findViewById(R.id.kab318_button);
        pauseButton = findViewById(R.id.pause_button);

        pauseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), PauseActivity.class);
                i.putExtra("okno", 7);
                startActivity(i);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            }
        });

        dep2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), Dep2Activity.class);
                startActivity(i);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            }
        });

        lestnitsaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(level<=11){
                    Toast toast = Toast.makeText(getApplicationContext(), "Кто-то комп не выключил.", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();
                }else{
                    dep2Button.setVisibility(View.INVISIBLE);
                    lestnitsaButton.setVisibility(View.INVISIBLE);
                    kabButton.setVisibility(View.INVISIBLE);
                    backImage.setImageResource(R.drawable.lestnica);
                    lestnitsSound.start();

                    Toast toast = Toast.makeText(getApplicationContext(), "Аудитория 412", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();

                    Intent i = new Intent(v.getContext(), Kab412Activity.class);
                    startActivity(i);
                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                }
            }
        });

        kabButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(getApplicationContext(), "Аудитория 318", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();
                Intent i = new Intent(v.getContext(), Kab318Activity.class);
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
