package com.example.mge_menstracker.calendars

import android.view.View
import android.widget.TextView
import com.example.mge_menstracker.R
import com.kizitonwose.calendarview.ui.ViewContainer

class DayViewContainer(view: View) : ViewContainer(view) {
    val textView = view.findViewById<TextView>(R.id.calendarDayText)
}