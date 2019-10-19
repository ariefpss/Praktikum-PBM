package com.example.praktikumpbm;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

import androidx.annotation.Nullable;

import java.io.IOException;

class myservice extends Service {
    MediaPlayer musik;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        // TODO Auto-generated method stub
    }

    @Override
    public void onStart(Intent intent, int startId) {
        // TODO Auto-generated method stub
        musik = MediaPlayer.create(this, R.raw.sound);
        try {
            musik.prepare();
        } catch (IllegalStateException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        musik.start();
    }

    @Override
    public void onDestroy() {
        // TODO Auto-generated method stub
        musik.stop();
    }
}
