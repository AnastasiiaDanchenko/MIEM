package com.example.miem;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SettingsActivity extends AppCompatActivity {

    private Button backButton = null;
    private Button sbrosButton = null;
    private Button enterButton = null;

    private SharedPreferences mySettings;
    private boolean music = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        sbrosButton = findViewById(R.id.sbros);
        enterButton = findViewById(R.id.enter);
        backButton = findViewById(R.id.back_button);

        enterButton.setVisibility(View.INVISIBLE);

        sbrosButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(getApplicationContext(), "Подтвердите сброс прогресса.", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();
                enterButton.setVisibility(View.VISIBLE);
            }
        });

        enterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(getApplicationContext(), "Прогресс сброшен.", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();
                SharedPreferences s_level = getSharedPreferences("levelSettings", MODE_PRIVATE);
                SharedPreferences.Editor editor = s_level.edit();
                editor.putInt("LEVEL", 1);
                editor.commit();
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), MainActivity.class);
                startActivity(i);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            }
        });

        mySettings = getSharedPreferences("musicSettings", Context.MODE_PRIVATE);
    }

    public void musicOn(View view){
        music = true;
        SharedPreferences.Editor editor = mySettings.edit();
        editor.putBoolean("MUSIC", music);
        editor.commit();
        startService(new Intent(this, MyMusic.class));
    }

    public void musicOff(View view){
        music = false;
        SharedPreferences.Editor editor = mySettings.edit();
        editor.putBoolean("MUSIC", music);
        editor.commit();
        stopService(new Intent(this, MyMusic.class));
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
    }
}
