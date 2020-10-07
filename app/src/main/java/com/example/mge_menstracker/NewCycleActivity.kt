package com.example.mge_menstracker

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class NewCycleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nextexpectedcycle)

        val abortButton = findViewById<Button>(R.id.abortbtn)
        abortButton.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent);
        }

        val rangeButton = findViewById<Button>(R.id.addRangeButton)
        rangeButton.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent);
        }
    }
}