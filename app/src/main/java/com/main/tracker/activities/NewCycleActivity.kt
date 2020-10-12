package com.main.tracker.activities

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.main.tracker.R
import com.main.tracker.model.Cycle

import com.main.tracker.model.CycleRepository
import java.time.LocalDate

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
            updateEntry() // TODO add user input
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent);
        }

    }

    private fun updateEntry() {
        val current: Cycle = CycleRepository.cycles.removeLast()
        current.from = LocalDate.parse("1990-01-01") // TODO replace with value "from", entered by user
        current.to = LocalDate.parse("1990-01-01")  // TODO replace with value "to", entered by user
        CycleRepository.cycles.addLast(current)
    }

}