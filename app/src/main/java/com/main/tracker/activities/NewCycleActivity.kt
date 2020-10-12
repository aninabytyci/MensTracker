package com.main.tracker.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.kizitonwose.calendarview.CalendarView
import com.kizitonwose.calendarview.model.CalendarDay
import com.kizitonwose.calendarview.ui.DayBinder
import com.main.tracker.R
import com.main.tracker.calendars.DayViewContainer

import com.main.tracker.model.CycleRepository
import java.time.LocalDate
import java.time.YearMonth
import java.time.temporal.WeekFields
import java.util.*

class NewCycleActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_newcycle)

        val calendarView = findViewById<CalendarView>(R.id.calendarView)
        calendarView.dayBinder = object : DayBinder<DayViewContainer> {
            // Called only when a new container is needed.
            override fun create(view: View) = DayViewContainer(view)

            // Called every time we need to reuse a container.
            override fun bind(container: DayViewContainer, day: CalendarDay) {
                container.textView.text = day.date.dayOfMonth.toString()
            }
        }

        val currentMonth = YearMonth.now()
        val firstMonth = currentMonth.minusMonths(1)
        val lastMonth = currentMonth.plusMonths(1)
        val firstDayOfWeek = WeekFields.of(Locale.getDefault()).firstDayOfWeek
        calendarView.setup(firstMonth, lastMonth, firstDayOfWeek)
        calendarView.scrollToMonth(currentMonth)


        val abortButton = findViewById<Button>(R.id.abortButton1)
        abortButton.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent);
        }

        val addButton = findViewById<Button>(R.id.addNewCycleButton)
        addButton.setOnClickListener{
            updateEntry() // TODO add user input
            val intent = Intent(this, NextExpectedCycleActivity::class.java)
            startActivity(intent);
        }

    }

    private fun updateEntry() {
        CycleRepository.cycles.first.from = LocalDate.parse("1990-01-01")
        CycleRepository.cycles.first.to = LocalDate.parse("1990-01-20")
    }

}