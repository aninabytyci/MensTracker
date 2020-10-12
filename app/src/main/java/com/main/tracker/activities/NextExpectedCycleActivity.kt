package com.main.tracker.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.main.tracker.R
import com.main.tracker.model.Cycle
import com.main.tracker.model.CycleRepository
import java.time.LocalDate

class NextExpectedCycleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nextexpectedcycle)

        val abortButton = findViewById<Button>(R.id.abortButton1)
        abortButton.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent);
        }

        val finishButton = findViewById<Button>(R.id.addExpectedButton)
        finishButton.setOnClickListener{
            addNewCycleEntry() // TODO add user input
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent);
        }
    }

    private fun addNewCycleEntry() { // TODO: replace with value "expected", entered by User
        val cycle = Cycle(LocalDate.parse("2000-01-01"))
        CycleRepository.cycles.addFirst(cycle)
    }
}