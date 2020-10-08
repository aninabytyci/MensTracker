package com.main.tracker.adapter

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CycleViewHolder(parent: View,
                      expected: TextView,
                      from: TextView,
                      to: TextView) : RecyclerView.ViewHolder(parent) {
    var expectedTextView: TextView
    var fromTextView: TextView
    var toTextView: TextView
    init {
        this.expectedTextView = expected
        this.fromTextView = from
        this.toTextView = to
    }
}
