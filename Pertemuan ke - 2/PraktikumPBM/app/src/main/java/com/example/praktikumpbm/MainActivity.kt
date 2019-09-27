package com.example.praktikumpbm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioGroup

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rdGroup = findViewById<RadioGroup>(R.id.rdGroup)
        rdGroup?.setOnCheckedChangeListener{group, checkedId ->

        }
    }
}
