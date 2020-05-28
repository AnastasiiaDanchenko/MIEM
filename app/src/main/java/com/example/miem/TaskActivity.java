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

public class    TaskActivity extends AppCompatActivity {

    private Button otvetButton = null;
    private Button kabButton = null;
    private String text1 = null;
    private String text2 = null;
    private String text3 = null;
    private String text4 = null;
    private String text5 = null;
    private String text6 = null;
    private String text7 = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task);
        final MediaPlayer wrongSound = MediaPlayer.create(this, R.raw.wrong);

        otvetButton = findViewById(R.id.otvet_button);
        kabButton = findViewById(R.id.kab_button);

        otvetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editText1 = findViewById(R.id.text1);
                EditText editText2 = findViewById(R.id.text2);
                EditText editText3 = findViewById(R.id.text3);
                EditText editText4 = findViewById(R.id.text4);
                EditText editText5 = findViewById(R.id.text5);
                EditText editText6 = findViewById(R.id.text6);
                EditText editText7 = findViewById(R.id.text7);
                text1 = editText1.getText().toString();
                text2 = editText2.getText().toString();
                text3 = editText3.getText().toString();
                text4 = editText4.getText().toString();
                text5 = editText5.getText().toString();
                text6 = editText6.getText().toString();
                text7 = editText7.getText().toString();

                if (text1.equals("1")||text1.equals("2")||text1.equals("3")||text1.equals("4")||text1.equals("5")||text1.equals("6")||text1.equals("7")) {
                    if (text2.equals("1") || text2.equals("2") || text2.equals("3") || text2.equals("4") || text2.equals("5") || text2.equals("6") || text2.equals("7")) {
                        if (text3.equals("1") || text3.equals("2") || text3.equals("3") || text3.equals("4") || text3.equals("5") || text3.equals("6") || text3.equals("7")) {
                            if (text4.equals("1") || text4.equals("2") || text4.equals("3") || text4.equals("4") || text4.equals("5") || text4.equals("6") || text4.equals("7")) {
                                if (text5.equals("1") || text5.equals("2") || text5.equals("3") || text5.equals("4") || text5.equals("5") || text5.equals("6") || text5.equals("7")) {
                                    if (text6.equals("1") || text6.equals("2") || text6.equals("3") || text6.equals("4") || text6.equals("5") || text6.equals("6") || text6.equals("7")) {
                                        if (text7.equals("1") || text7.equals("2") || text7.equals("3") || text7.equals("4") || text7.equals("5") || text7.equals("6") || text7.equals("7")) {
                                            int t1 = Integer.parseInt(text1);
                                            int t2 = Integer.parseInt(text2);
                                            int t3 = Integer.parseInt(text3);
                                            int t4 = Integer.parseInt(text4);
                                            int t5 = Integer.parseInt(text5);
                                            int t6 = Integer.parseInt(text6);
                                            int t7 = Integer.parseInt(text7);

                                            if(t1+t2+t3 ==12 && t1+t4+t7 == 12 && t2+t4+t6 == 12 && t3+t4+t5 == 12 && t5+t6+t7 == 12){
                                                SharedPreferences s_level = getSharedPreferences("levelSettings", MODE_PRIVATE);
                                                int level = s_level.getInt("LEVEL", 1);
                                                if(level<12) {
                                                    SharedPreferences.Editor editor = s_level.edit();
                                                    editor.putInt("LEVEL", 12);
                                                    editor.commit();
                                                }
                                                Intent i = new Intent(v.getContext(), Lab5Activity.class);
                                                startActivity(i);
                                                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                                            }else{
                                                wrongSound.start();
                                            }
                                        }else{
                                            wrongSound.start();
                                        }
                                        } else {
                                            wrongSound.start();
                                        }
                                    } else {
                                        wrongSound.start();
                                    }
                                } else {
                                    wrongSound.start();
                                }
                            } else {
                                wrongSound.start();
                            }
                        } else {
                            wrongSound.start();
                        }
                    } else {
                        wrongSound.start();
                    }
            }
        });

        kabButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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
