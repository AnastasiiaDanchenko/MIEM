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

public class Stolovaya2Activity extends AppCompatActivity {

    private Button dep1Button = null;
    private ImageButton liftButton = null;
    private ImageButton stolovayaButton = null;
    private ImageView backImage;
    private Button pauseButton = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stolovaya2);
        final MediaPlayer liftSound = MediaPlayer.create(this, R.raw.lift);
        SharedPreferences s_level = getSharedPreferences("levelSettings", MODE_PRIVATE);
        final int level = s_level.getInt("LEVEL", 1);

        dep1Button = findViewById(R.id.dep1_button);
        liftButton = findViewById(R.id.lift_button);
        stolovayaButton = findViewById(R.id.stolovaya_button);
        backImage = findViewById(R.id.back_image);
        pauseButton = findViewById(R.id.pause_button);

        pauseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), PauseActivity.class);
                i.putExtra("okno", 19);
                startActivity(i);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            }
        });

        dep1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), Dep1Activity.class);
                startActivity(i);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            }
        });

        liftButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (level < 8) {
                    Toast toast = Toast.makeText(getApplicationContext(), "Кажется, там было что-то ещё. Или нет?", Toast.LENGTH_LONG);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();
                } else {
                    stolovayaButton.setVisibility(View.INVISIBLE);
                    dep1Button.setVisibility(View.INVISIBLE);
                    liftButton.setVisibility(View.INVISIBLE);
                    backImage.setImageResource(R.drawable.lift);

                    liftSound.start();
                    Intent i = new Intent(v.getContext(), Koridor1Activity.class);
                    if(level<=9){
                        i.putExtra("bufet", 0);
                    }else{
                        i.putExtra("bufet", 1);
                    }
                    startActivity(i);
                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                }
            }
        });

        stolovayaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), Stolovaya1Activity.class);
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
