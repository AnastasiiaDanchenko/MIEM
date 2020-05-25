package com.example.miem;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Koridor1Activity extends AppCompatActivity {

    private ImageButton atriumButton = null;
    private ImageButton liftButton = null;
    private ImageButton biblioButton = null;
    private ImageButton bufetButton = null;
    private ImageButton koridorButton = null;
    private int bufet = 0;
    private ImageView backImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_koridor1);
        final MediaPlayer liftSound = MediaPlayer.create(this, R.raw.lift);
        bufet = getIntent().getExtras().getInt("bufet");

        SharedPreferences s_level = getSharedPreferences("levelSettings", MODE_PRIVATE);
        final int level = s_level.getInt("LEVEL", 1);

        backImage = findViewById(R.id.back_image);
        atriumButton = findViewById(R.id.atrium_button);
        liftButton = findViewById(R.id.lift_button);
        biblioButton = findViewById(R.id.biblio_button);
        bufetButton = findViewById(R.id.bufet_button);
        koridorButton = findViewById(R.id.koridor_button);

        atriumButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), AtriumActivity.class);
                startActivity(i);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            }
        });

        liftButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(level<12){
                    Toast toast = Toast.makeText(getApplicationContext(), "Ну до третьего этажа и пешком можно.", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();
                }else{
                    atriumButton.setVisibility(View.INVISIBLE);
                    koridorButton.setVisibility(View.INVISIBLE);
                    biblioButton.setVisibility(View.INVISIBLE);
                    bufetButton.setVisibility(View.INVISIBLE);
                    liftButton.setVisibility(View.INVISIBLE);
                    backImage.setImageResource(R.drawable.lift);
                    liftSound.start();

                    Intent i = new Intent(v.getContext(), Kab412Activity.class);
                    startActivity(i);
                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                }
            }
        });

        biblioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), BiblioActivity.class);
                startActivity(i);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            }
        });

        bufetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(level<=9){
                    Intent i = new Intent(v.getContext(), BufetActivity.class);
                    i.putExtra("bufet", 0);
                    startActivity(i);
                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                }else if(level>=10){
                    Intent i = new Intent(v.getContext(), BufetActivity.class);
                    i.putExtra("bufet", 1);
                    startActivity(i);
                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                }
            }
        });

        koridorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(level<9){
                    Toast toast = Toast.makeText(getApplicationContext(), "Кажется, кто-то говорил про библиотеку...", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();
                }else if(bufet == 0){
                    Toast toast = Toast.makeText(getApplicationContext(), "О, там буфет что ли?", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();
                }else{
                    Intent i = new Intent(v.getContext(), Koridor2Activity.class);
                    startActivity(i);
                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                }
            }
        });
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
    }
}
