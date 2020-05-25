package com.example.miem;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class KomnatakActivity extends AppCompatActivity {
    int door;
    private ImageButton stekloButton = null;
    private ImageButton komnataotButton = null;
    private Button doorButton = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        door = getIntent().getExtras().getInt("door");
        setContentView(R.layout.activity_komnata_k);
        final MediaPlayer openSound = MediaPlayer.create(this, R.raw.openeddoor);
        final MediaPlayer closeSound = MediaPlayer.create(this, R.raw.lokeddoor);

        doorButton = findViewById(R.id.door_button);
        stekloButton = findViewById(R.id.steklo_button);
        komnataotButton = findViewById(R.id.komnata_ot_button);

        doorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (door == 1000){
                    Toast toast = Toast.makeText(getApplicationContext(), "Может быть, тут есть что-то интересное?", Toast.LENGTH_LONG);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();
                }
                else if (door >= 0 && door < 1000){
                    closeSound.start();
                    Toast toast = Toast.makeText(getApplicationContext(), "Хм, заперто...", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();
                }
                else{
                    Intent i = new Intent(v.getContext(), Etazh7aActivity.class);
                    startActivity(i);
                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                    openSound.start();
                }
            }
        });

        stekloButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), StekloActivity.class);
                i.putExtra("door", door);
                startActivity(i);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            }
        });

        komnataotButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), KomnataotActivity.class);
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