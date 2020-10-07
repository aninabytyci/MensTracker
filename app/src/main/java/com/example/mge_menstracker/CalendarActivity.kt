package com.example.mge_menstracker

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class CalendarActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calendar)

        val abortButton = findViewById<Button>(R.id.abortbutton)
        abortButton.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent);
        }

        val addButton = findViewById<Button>(R.id.addDataButton)
        addButton.setOnClickListener{
            val intent = Intent(this, CalendarActivity2::class.java)
            startActivity(intent);
        }
    }
}