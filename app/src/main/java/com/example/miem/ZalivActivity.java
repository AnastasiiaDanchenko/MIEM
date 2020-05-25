package com.example.miem;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class ZalivActivity extends AppCompatActivity {
    private Button oknoButton = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zaliv);

        SharedPreferences s_level = getSharedPreferences("levelSettings", MODE_PRIVATE);
        int level = s_level.getInt("LEVEL", 1);

        if(level<3) {
            SharedPreferences.Editor editor = s_level.edit();
            editor.putInt("LEVEL", 3);
            editor.commit();
        }
        oknoButton = findViewById(R.id.okno_button);

        oknoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), OknoActivity.class);
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

