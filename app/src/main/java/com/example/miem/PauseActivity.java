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

public class PauseActivity extends AppCompatActivity {

    private int okno = 0;
    private Button backButton = null;
    private Button menuButton = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        okno = getIntent().getExtras().getInt("okno");
        setContentView(R.layout.activity_pause);

        backButton = findViewById(R.id.back_button);
        menuButton = findViewById(R.id.menu_button);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (okno == 1){
                    Intent i = new Intent(v.getContext(), AtriumActivity.class);
                    startActivity(i);
                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                }
                if (okno == 2){
                    Intent i = new Intent(v.getContext(), BiblioActivity.class);
                    startActivity(i);
                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                }
                if (okno == 3){
                    Intent i = new Intent(v.getContext(), Etazh5aActivity.class);
                    startActivity(i);
                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                }
                if (okno == 4){
                    Intent i = new Intent(v.getContext(), Etazh7aActivity.class);
                    startActivity(i);
                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                }
                if (okno == 5){
                    Intent i = new Intent(v.getContext(), Etazh9aActivity.class);
                    startActivity(i);
                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                }
                if (okno == 6){
                    Intent i = new Intent(v.getContext(), Kab318Activity.class);
                    startActivity(i);
                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                }
                if (okno == 7){
                    Intent i = new Intent(v.getContext(), Kab323Activity.class);
                    startActivity(i);
                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                }
                if (okno == 8){
                    Intent i = new Intent(v.getContext(), Kab412Activity.class);
                    startActivity(i);
                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                }
                if (okno == 9){
                    Intent i = new Intent(v.getContext(), Kab504nizActivity.class);
                    startActivity(i);
                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                }
                if (okno == 10){
                    Intent i = new Intent(v.getContext(), Kab504verhActivity.class);
                    startActivity(i);
                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                }
                if (okno == 11){
                    Intent i = new Intent(v.getContext(), Kab514Activity.class);
                    startActivity(i);
                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                }
                if (okno == 12){
                    Intent i = new Intent(v.getContext(), Kab617Activity.class);
                    startActivity(i);
                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                }
                if (okno == 13){
                    Intent i = new Intent(v.getContext(), Koridor2Activity.class);
                    startActivity(i);
                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                }
                if (okno == 14){
                    Intent i = new Intent(v.getContext(), Koridor6Activity.class);
                    startActivity(i);
                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                }
                if (okno == 15){
                    Intent i = new Intent(v.getContext(), LestnitsaActivity.class);
                    startActivity(i);
                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                }
                if (okno == 16){
                    Intent i = new Intent(v.getContext(), LettersActivity.class);
                    startActivity(i);
                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                }
                if (okno == 17){
                    Intent i = new Intent(v.getContext(), OknoActivity.class);
                    startActivity(i);
                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                }
                if (okno == 18){
                    Intent i = new Intent(v.getContext(), Stolovaya1Activity.class);
                    startActivity(i);
                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                }
                if (okno == 19){
                    Intent i = new Intent(v.getContext(), Stolovaya2Activity.class);
                    startActivity(i);
                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                }
            }
        });

        menuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), MainActivity.class);
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
