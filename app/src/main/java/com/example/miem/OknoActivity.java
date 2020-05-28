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

public class OknoActivity extends AppCompatActivity {

    private Button zalivButton = null;
    private ImageButton liftButton = null;
    private ImageButton lestnitsaButton = null;
    private ImageView backImage;
    private Button pauseButton = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_okno);
        final MediaPlayer liftSound = MediaPlayer.create(this, R.raw.lift);
        final MediaPlayer lestnitsaSound = MediaPlayer.create(this, R.raw.lestnitsa);

        SharedPreferences s_level = getSharedPreferences("levelSettings", MODE_PRIVATE);
        final int level = s_level.getInt("LEVEL", 1);

        if(level<3){
            Toast toast = Toast.makeText(getApplicationContext(), "Хм, а тут красиво.", Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.show();
            Toast toast1 = Toast.makeText(getApplicationContext(), "Может быть, можно узнать что-то интересное про этот залив?", Toast.LENGTH_LONG);
            toast1.setGravity(Gravity.CENTER, 0, 0);
            toast1.show();
        }

        backImage = findViewById(R.id.back_image);
        zalivButton = findViewById(R.id.zaliv_button);
        liftButton = findViewById(R.id.lift_button);
        lestnitsaButton = findViewById(R.id.lestnitsa_button);
        pauseButton = findViewById(R.id.pause_button);

        pauseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), PauseActivity.class);
                i.putExtra("okno", 17);
                startActivity(i);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            }
        });

        zalivButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), ZalivActivity.class);
                startActivity(i);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            }
        });

        liftButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(level<4){
                    Toast toast = Toast.makeText(getApplicationContext(), "Лучше сначала поднимусь наверх", Toast.LENGTH_LONG);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();
                }else{
                    zalivButton.setVisibility(View.INVISIBLE);
                    lestnitsaButton.setVisibility(View.INVISIBLE);
                    liftButton.setVisibility(View.INVISIBLE);
                    backImage.setImageResource(R.drawable.lift);
                    liftSound.start();

                    Intent i = new Intent(v.getContext(), Etazh5aActivity.class);
                    startActivity(i);
                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                }
            }
        });

        lestnitsaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                zalivButton.setVisibility(View.INVISIBLE);
                lestnitsaButton.setVisibility(View.INVISIBLE);
                liftButton.setVisibility(View.INVISIBLE);
                backImage.setImageResource(R.drawable.lestnica);
                lestnitsaSound.start();

                Intent i = new Intent(v.getContext(), Etazh9aActivity.class);
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
