package com.example.miem;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;


public class MyMusic extends Service {
    MediaPlayer myPlayer;
    private int resumePosition;

    @Override
    public void onCreate() {
        myPlayer = MediaPlayer.create(this, R.raw.kando7);
        myPlayer.setLooping(true);
    }

    @Override
    public void onDestroy() {
        myPlayer.stop();
    }

    @Override
    public void onStart(Intent intent, int startId) {
        myPlayer.start();
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    public void pauseMedia() {
        if (myPlayer.isPlaying()) {
            myPlayer.pause();
            resumePosition = myPlayer.getCurrentPosition();
        }
    }

    public void resumeMedia() {
        if (!myPlayer.isPlaying()) {
            myPlayer.seekTo(resumePosition);
            myPlayer.start();
        }
    }
}
