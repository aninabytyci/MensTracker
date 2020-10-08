package com.main.tracker.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView

import com.main.tracker.model.Cycle;

class PeriodAdapter(cycles: ArrayList<Cycle>) : RecyclerView.Adapter<PeriodViewHolder>() {
    private var cycles: ArrayList<Cycle>

    override fun getItemCount(): Int {
        return this.cycles.size
    }

    init {
        this.cycles = cycles
    }

    @NonNull
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PeriodViewHolder {
        val context = parent.getContext()
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(
            android.R.layout.simple_list_item_2,
            parent,
            false
        )
        val expectedTextView: TextView = view.findViewById(android.R.id.text1)
        val fromTextView: TextView = view.findViewById(android.R.id.text1)
        val toTextView: TextView = view.findViewById(android.R.id.text1)
        return PeriodViewHolder(view, expectedTextView, fromTextView, toTextView)
    }

    override fun onBindViewHolder(holder: PeriodViewHolder, position: Int) {
        val cycle = this.cycles.get(position)
        holder.expectedTextView.setText(cycle.expected.toString())
        holder.fromTextView.setText(cycle.to.toString())
        holder.toTextView.setText(cycle.from.toString())


    }




}