package com.main.tracker.calendars

import android.view.View
import android.widget.TextView
import com.main.tracker.R
import com.kizitonwose.calendarview.ui.ViewContainer

class DayViewContainer(view: View) : ViewContainer(view) {
    val textView = view.findViewById<TextView>(R.id.calendarDayText)
}