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
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class CodActivity extends AppCompatActivity {

    private Button otvetButton = null;
    private Button koridorButton = null;
    private String otvetText = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cod);
        final MediaPlayer wrongSound = MediaPlayer.create(this, R.raw.wrong);

        otvetButton = findViewById(R.id.otvet_button);
        koridorButton = findViewById(R.id.koridor_button);

        otvetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editText = findViewById(R.id.otvet_text);
                otvetText = editText.getText().toString();
                if (otvetText.equals("while (it != std::cend(v) && ix++ < 3) print_elem(*it);") ||
                        otvetText.equals("while (it != std::cend(v) && ix++ < 3){ print_elem(*it);") ||
                        otvetText.equals("while(it != std::cend(v) && ix++ < 3){ print_elem(*it);") ||
                        otvetText.equals("while (it != std::cend(v) && ix++ < 3){ print elem(*it);") ||
                        otvetText.equals("while(it != std::cend(v) && ix++ < 3){ print elem(*it);")){

                    SharedPreferences s_level = getSharedPreferences("levelSettings", MODE_PRIVATE);
                    int level = s_level.getInt("LEVEL", 1);
                    if(level<11) {
                        SharedPreferences.Editor editor = s_level.edit();
                        editor.putInt("LEVEL", 11);
                        editor.commit();
                    }

                    Intent i = new Intent(v.getContext(), Lab4Activity.class);
                    startActivity(i);
                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                }else{
                    wrongSound.start();
                }
            }
        });

        koridorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), Koridor2Activity.class);
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
