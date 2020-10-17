package com.main.tracker.adapter

import android.content.Context
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CycleViewHolder(parent: View,
                      expected: TextView,
                      fromto: TextView,
                      context: Context,
                      ) : RecyclerView.ViewHolder(parent) {
    var expectationTextView: TextView
    var realityTextView: TextView
    var context: Context
    init {
        this.expectationTextView = expected
        this.realityTextView = fromto
        this.context = context

    }
}
