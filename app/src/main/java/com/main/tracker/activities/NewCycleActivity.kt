package com.main.tracker.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.main.tracker.R


import com.main.tracker.model.CycleRepository
import com.squareup.timessquare.CalendarPickerView
import java.text.DateFormat
import java.time.LocalDate

import java.util.*

class NewCycleActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_newcycle)

        val today = Date()
        val nextYear = Calendar.getInstance()
        nextYear.add(Calendar.YEAR,1)
        val datePicker = findViewById<CalendarPickerView>(R.id.calendar)
        datePicker.init(today, nextYear.time).inMode(CalendarPickerView.SelectionMode.RANGE)

        datePicker.setOnDateSelectedListener(object: CalendarPickerView.OnDateSelectedListener {
            override fun onDateSelected(date: Date) {
                // TODO: How to get the selected Dates?
                val selectedDate = DateFormat.getDateInstance(DateFormat.MEDIUM).format(date)
                Toast.makeText(this@NewCycleActivity, selectedDate, Toast.LENGTH_SHORT).show()
            }
            override fun onDateUnselected(date: Date) {
            }
        })

        val abortButton = findViewById<Button>(R.id.abortButton1)
        abortButton.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent);
        }

        val addButton = findViewById<Button>(R.id.addNewCycleButton)
        addButton.setOnClickListener{
            // TODO: getselectedDates yields a IndexOutOfBounds
            val l = datePicker.selectedDates
            val from = LocalDate.parse(l.get(0).toString())
            val to = LocalDate.parse(l.get(1).toString() )
            updateEntry(from, to) // TODO add user input
            val intent = Intent(this, NextExpectedCycleActivity::class.java)
            startActivity(intent);
        }
    }

    private fun updateEntry(from: LocalDate, to: LocalDate) {
        CycleRepository.updateCycle(from, to)
    }

}