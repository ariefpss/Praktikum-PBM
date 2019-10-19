package com.example.praktikumpbm;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button fbBtn, twBtn, telBtn, smsBtn, playBtn, stopBtn, sysBtn;
    MediaPlayer musik;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fbBtn = (Button) findViewById(R.id.button1);
        fbBtn.setOnClickListener(this);

        twBtn = (Button) findViewById(R.id.button2);
        twBtn.setOnClickListener(this);

        telBtn = (Button) findViewById(R.id.button3);
        telBtn.setOnClickListener(this);

        smsBtn = (Button) findViewById(R.id.button4);
        smsBtn.setOnClickListener(this);

        playBtn = (Button) findViewById(R.id.button5);
        playBtn.setOnClickListener(this);

        stopBtn = (Button) findViewById(R.id.button6);
        stopBtn.setOnClickListener(this);

        sysBtn = (Button) findViewById(R.id.button7);
        sysBtn.setOnClickListener(this);
    }

    @SuppressLint("MissingPermission")
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button1:
                Intent intfb = new Intent(Intent.ACTION_VIEW,Uri.parse("https://web.facebook.com/arief.prmanascreamo"));
                startActivity(intfb);
                break;
            case R.id.button2:
                Intent inttw = new Intent(Intent.ACTION_VIEW,Uri.parse("https://twitter.com/AriefPe08514472"));
                startActivity(inttw);
                break;
            case R.id.button3:
                Intent inttel = new Intent(Intent.ACTION_CALL,Uri.parse("tel:+621327470449"));
                startActivity(inttel);
                break;
            case R.id.button4:
                Intent intsms = new Intent(Intent.ACTION_SENDTO,Uri.parse("smsto:+621327470449"));
                intsms.putExtra("sms_body", "Assalamu'alaimkum");
                startActivity(intsms);
                break;
            case R.id.button5:
                startService(new Intent(MainActivity.this, myservice.class));
                break;
            case R.id.button6:
                stopService(new Intent(MainActivity.this, myservice.class));
                break;
            case R.id.button7:
                Intent intSys = new Intent(MainActivity.this, ListActivity.class);
                startActivity(intSys);
                break;
        }
    }
}

