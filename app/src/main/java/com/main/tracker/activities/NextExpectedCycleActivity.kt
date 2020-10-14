package com.main.tracker.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.main.tracker.R
import com.main.tracker.model.Cycle
import com.main.tracker.model.CycleRepository
import com.squareup.timessquare.CalendarPickerView
import java.text.DateFormat
import java.time.LocalDate


class NextExpectedCycleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nextexpectedcycle)

        val today = Date()
        val nextYear = Calendar.getInstance()
        nextYear.add(Calendar.YEAR,1)
        val datePicker = findViewById<CalendarPickerView>(R.id.calendar)
        datePicker.init(today, nextYear.time)

        datePicker.setOnDateSelectedListener(object: CalendarPickerView.OnDateSelectedListener {
            override fun onDateSelected(date: Date) {
                val selectedDate = DateFormat.getDateInstance(DateFormat.FULL).format(date)
                Toast.makeText(this@NextExpectedCycleActivity, selectedDate, Toast.LENGTH_SHORT).show()
            }

            override fun onDateUnselected(date: Date) {
                TODO("Not yet implemented")
            }
        })


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