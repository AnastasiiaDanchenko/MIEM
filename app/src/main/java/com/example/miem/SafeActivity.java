package com.example.miem;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class SafeActivity extends AppCompatActivity {
    int door;
    private String code ="";
    private ImageButton stekloButton = null;
    private Button button_0 = null;
    private Button button_1 = null;
    private Button button_2 = null;
    private Button button_3 = null;
    private Button button_4 = null;
    private Button button_5 = null;
    private Button button_6 = null;
    private Button button_7 = null;
    private Button button_8 = null;
    private Button button_9 = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        door = getIntent().getExtras().getInt("door");
        setContentView(R.layout.activity_safe);
        final MediaPlayer buttonSound = MediaPlayer.create(this, R.raw.safe);
        final MediaPlayer keySound = MediaPlayer.create(this, R.raw.key);
        final MediaPlayer wrongSound = MediaPlayer.create(this, R.raw.wrong);

        stekloButton = findViewById(R.id.steklo_button);
        button_0 = findViewById(R.id.button_0);
        button_1 = findViewById(R.id.button_1);
        button_2 = findViewById(R.id.button_2);
        button_3 = findViewById(R.id.button_3);
        button_4 = findViewById(R.id.button_4);
        button_5 = findViewById(R.id.button_5);
        button_6 = findViewById(R.id.button_6);
        button_7 = findViewById(R.id.button_7);
        button_8 = findViewById(R.id.button_8);
        button_9 = findViewById(R.id.button_9);

        View.OnClickListener oMyButton = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.button_0:
                        code += "0";
                        buttonSound.start();
                        if (code.length() == 4) {
                            wrongSound.start();
                            code = "";
                        }
                        break;
                    case R.id.button_1:
                        code += "1";
                        buttonSound.start();
                        if (code.length() == 4) {
                            wrongSound.start();
                            code = "";
                        }
                        break;
                    case R.id.button_2:
                        code += "2";
                        buttonSound.start();
                        if (code.length() == 4) {
                            wrongSound.start();
                            code = "";
                        }
                        break;
                    case R.id.button_3:
                        code += "3";
                        buttonSound.start();
                        if (code.length() == 4) {
                            wrongSound.start();
                            code = "";
                        }
                        break;
                    case R.id.button_4:
                        code += "4";
                        buttonSound.start();
                        if (code.length() == 4) {
                            wrongSound.start();
                            code = "";
                        }
                        break;
                    case R.id.button_5:
                        code += "5";
                        buttonSound.start();
                        if (code.length() == 4) {
                            wrongSound.start();
                            code = "";
                        }
                        break;
                    case R.id.button_6:
                        code += "6";
                        buttonSound.start();
                        if (code.length() == 4) {
                            wrongSound.start();
                            code = "";
                        }
                        break;
                    case R.id.button_7:
                        code += "7";
                        buttonSound.start();
                        if (code.length() == 4) {
                            if (code.equals("0137")) {
                                door += 1000;
                                Intent i = new Intent(v.getContext(), StekloActivity.class);
                                i.putExtra("door", door);
                                startActivity(i);
                                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                                keySound.start();
                            } else {
                                wrongSound.start();
                                code = "";
                            }
                        }
                        break;
                    case R.id.button_8:
                        code += "8";
                        buttonSound.start();
                        if (code.length() == 4) {
                            wrongSound.start();
                            code = "";
                        }
                        break;
                    case R.id.button_9:
                        code += "9";
                        buttonSound.start();
                        if (code.length() == 4) {
                            wrongSound.start();
                            code = "";
                        }
                        break;
                }
            }
        };

        button_0.setOnClickListener(oMyButton);
        button_1.setOnClickListener(oMyButton);
        button_2.setOnClickListener(oMyButton);
        button_3.setOnClickListener(oMyButton);
        button_4.setOnClickListener(oMyButton);
        button_5.setOnClickListener(oMyButton);
        button_6.setOnClickListener(oMyButton);
        button_7.setOnClickListener(oMyButton);
        button_8.setOnClickListener(oMyButton);
        button_9.setOnClickListener(oMyButton);

        stekloButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), StekloActivity.class);
                i.putExtra("door", door);
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
