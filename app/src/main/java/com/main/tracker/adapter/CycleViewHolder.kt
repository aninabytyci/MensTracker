package com.main.tracker.adapter

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CycleViewHolder(parent: View,
                      expected: TextView,
                      fromto: TextView,
                      ) : RecyclerView.ViewHolder(parent) {
    var expectationTextView: TextView
    var realityTextView: TextView
    init {
        this.expectationTextView = expected
        this.realityTextView = fromto

    }
}
