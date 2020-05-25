package com.example.miem;

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

public class LevelActivity extends AppCompatActivity {

    private SharedPreferences myLevel;
    private int level = 1;

    private Button backButton = null;
    private Button org1 = null;
    private Button fact1 = null;
    private Button fact2 = null;
    private Button fact3 = null;
    private Button dep1 = null;
    private Button dep2 = null;
    private Button dep3 = null;
    private Button lab1 = null;
    private Button lab2 = null;
    private Button lab3 = null;
    private Button lab4 = null;
    private Button lab5 = null;
    private Button lab6 = null;
    private Button diff1 = null;
    private Button diff2 = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level);

        myLevel = getSharedPreferences("levelSettings", MODE_PRIVATE);
        level = myLevel.getInt("LEVEL", 1);

        org1 = findViewById(R.id.org1);
        backButton = findViewById(R.id.back_button);
        fact1 = findViewById(R.id.fact1);
        fact2 = findViewById(R.id.fact2);
        fact3 = findViewById(R.id.fact3);
        dep1 = findViewById(R.id.dep1);
        dep2 = findViewById(R.id.dep2);
        dep3 = findViewById(R.id.dep3);
        lab1 = findViewById(R.id.lab1);
        lab2 = findViewById(R.id.lab2);
        lab3 = findViewById(R.id.lab3);
        lab4 = findViewById(R.id.lab4);
        lab5 = findViewById(R.id.lab5);
        lab6 = findViewById(R.id.lab6);
        diff1 = findViewById(R.id.diff1);
        diff2 = findViewById(R.id.diff2);

        if (level>=2){ diff1.setText("1"); }
        if(level>=3){ lab1.setText("1"); }
        if(level>=4){ lab2.setText("2"); }
        if(level>=6){ fact1.setText("1"); dep1.setText("1");}
        if(level>=8){ lab3.setText("3"); fact2.setText("2");}
        if(level>=9){ lab4.setText("4"); }
        if(level>=11){ lab5.setText("5"); dep2.setText("2");}
        if(level>=12){ lab6.setText("6"); dep3.setText("3"); diff2.setText("2"); fact3.setText("3");}

        fact3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(level>=12){
                    Toast toast = Toast.makeText(getApplicationContext(), "Аудитория 504", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();
                    Intent i = new Intent(v.getContext(), Kab504nizActivity.class);
                    startActivity(i);
                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                }
            }
        });

        diff2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(level>=12){
                    Toast toast = Toast.makeText(getApplicationContext(), "6 этаж", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();
                    Intent i = new Intent(v.getContext(), Koridor6Activity.class);
                    startActivity(i);
                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                }
            }
        });

        dep3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(level>=12){
                    Toast toast = Toast.makeText(getApplicationContext(), "Аудитория 617", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();
                    Intent i = new Intent(v.getContext(), Kab617Activity.class);
                    startActivity(i);
                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                }
            }
        });

        lab6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(level>=12){
                    Toast toast = Toast.makeText(getApplicationContext(), "Аудитория 412", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();
                    Intent i = new Intent(v.getContext(), Kab412Activity.class);
                    startActivity(i);
                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                }
            }
        });

        dep2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(level>=11){
                    Toast toast = Toast.makeText(getApplicationContext(), "Аудитория 323", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();
                    Intent i = new Intent(v.getContext(), Kab323Activity.class);
                    startActivity(i);
                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                }
            }
        });

        lab5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(level>=11){
                    Toast toast = Toast.makeText(getApplicationContext(), "Аудитория 318", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();
                    Intent i = new Intent(v.getContext(), Kab318Activity.class);
                    startActivity(i);
                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                }
            }
        });

        lab4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(level>=9){
                    Toast toast = Toast.makeText(getApplicationContext(), "1 этаж", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();
                    Intent i = new Intent(v.getContext(), Koridor2Activity.class);
                    startActivity(i);
                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                }
            }
        });

        fact2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(level>=8&&level<=9){
                    Intent i = new Intent(v.getContext(), BufetActivity.class);
                    i.putExtra("bufet", 0);
                    startActivity(i);
                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                }else if(level>=10){
                    Intent i = new Intent(v.getContext(), BufetActivity.class);
                    i.putExtra("bufet", 1);
                    startActivity(i);
                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                }
            }
        });

        lab3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(level>=8){
                    Intent i = new Intent(v.getContext(), BiblioActivity.class);
                    startActivity(i);
                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                }
            }
        });

        fact1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(level>=6){
                    Intent i = new Intent(v.getContext(), LestnitsaActivity.class);
                    startActivity(i);
                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                }
            }
        });

        dep1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(level>=6){
                    Intent i = new Intent(v.getContext(), Stolovaya2Activity.class);
                    startActivity(i);
                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                }
            }
        });

        diff1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(level>=2) {
                    Intent i = new Intent(v.getContext(), Etazh7aActivity.class);
                    startActivity(i);
                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                }
            }
        });

        lab1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(level>=3){
                    Intent i = new Intent(v.getContext(), Etazh9aActivity.class);
                    startActivity(i);
                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                    if(level>=4) {
                        Toast toast = Toast.makeText(getApplicationContext(), "9 этаж, административный корпус", Toast.LENGTH_LONG);
                        toast.setGravity(Gravity.CENTER, 0, 0);
                        toast.show();
                    }
                }
            }
        });

        lab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(level>=4){
                    Intent i = new Intent(v.getContext(), Etazh5aActivity.class);
                    startActivity(i);
                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                    if(level>=5) {
                        Toast toast = Toast.makeText(getApplicationContext(), "5 этаж, административный корпус", Toast.LENGTH_LONG);
                        toast.setGravity(Gravity.CENTER, 0, 0);
                        toast.show();
                    }
                }
            }
        });

        org1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), KomnataotActivity.class);
                i.putExtra("door", 0);
                startActivity(i);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                Toast toast = Toast.makeText(getApplicationContext(), "Комната MOVEMENT", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();
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
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
    }
}
