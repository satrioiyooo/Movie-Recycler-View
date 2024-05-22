package com.example.fundatest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class About : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)

        val btnMoveActivity: Button = findViewById(R.id.button)
        btnMoveActivity.setOnClickListener{
            finish()
        }

    }
}