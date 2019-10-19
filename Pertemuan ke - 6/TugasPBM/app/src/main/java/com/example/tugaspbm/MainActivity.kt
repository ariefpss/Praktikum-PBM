package com.example.tugaspbm

import android.content.Intent
import android.media.MediaPlayer
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnFB.setOnClickListener({
            val i = Intent(Intent.ACTION_VIEW, Uri.parse("https://web.facebook.com/arief.prmanascreamo"))
                    startActivity(i)
        })

        btnGB.setOnClickListener({
            val i = Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/ariefpss"))
                    startActivity(i)
        })

        var MediaPlayer: MediaPlayer? = MediaPlayer.create(this, R.raw.sound)

        btnPlay.setOnClickListener {
            MediaPlayer?.start()
        }

        btnPause.setOnClickListener {
            MediaPlayer?.pause()
        }

        btnStop.setOnClickListener {
            MediaPlayer?.pause()
            MediaPlayer?.seekTo(0)
        }
    }
}
