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
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class DiffurActivity extends AppCompatActivity {

    private Button otvetButton = null;
    private Button kompButton = null;
    private String otvetText = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diffur);
        final MediaPlayer wrongSound = MediaPlayer.create(this, R.raw.wrong);
        final MediaPlayer printerSound = MediaPlayer.create(this, R.raw.printer);

        otvetButton = findViewById(R.id.otvet_button);
        kompButton = findViewById(R.id.komp_button);

        otvetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editText = findViewById(R.id.otvet_text);
                otvetText = editText.getText().toString();
                if (otvetText.equals("(1/6,1/6)")){

                    SharedPreferences s_level = getSharedPreferences("levelSettings", MODE_PRIVATE);
                    int level = s_level.getInt("LEVEL", 1);
                    if(level<5) {
                        SharedPreferences.Editor editor = s_level.edit();
                        editor.putInt("LEVEL", 5);
                        editor.commit();
                    }

                    printerSound.start();
                    Toast toast = Toast.makeText(getApplicationContext(), "Супер! Что там, интересно?", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();
                    Intent i = new Intent(v.getContext(), Kab514Activity.class);
                    startActivity(i);
                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                }else{
                    wrongSound.start();
                }
            }
        });

        kompButton.setOnClickListener(new View.OnClickListener() {
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
