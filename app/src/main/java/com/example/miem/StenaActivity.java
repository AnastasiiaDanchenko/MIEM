package com.example.miem;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class StenaActivity extends AppCompatActivity {
    int door;
    private ImageButton komnataotButton = null;
    private Button kalendarButton = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        door = getIntent().getExtras().getInt("door");
        setContentView(R.layout.activity_stena);

        if (door == 1000 || door == 0){
            Toast toast = Toast.makeText(getApplicationContext(), "Надо бы подойти к календарю. Может, там есть что-то полезное?", Toast.LENGTH_LONG);
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.show();
        }

        komnataotButton = findViewById(R.id.komnata_ot_button);
        kalendarButton = findViewById(R.id.kalendar_button);

        komnataotButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), KomnataotActivity.class);
                i.putExtra("door", door);
                startActivity(i);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            }
        });

        kalendarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), KalendarActivity.class);
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
