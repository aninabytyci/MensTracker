package com.main.tracker.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView

import com.main.tracker.model.Cycle;

class CycleAdapter(cycles: ArrayList<Cycle>) : RecyclerView.Adapter<CycleViewHolder>() {
    private var cycles: ArrayList<Cycle>

    override fun getItemCount(): Int {
        return this.cycles.size
    }

    init {
        this.cycles = cycles
    }

    @NonNull
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CycleViewHolder {
        val context = parent.getContext()
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(  // TODO change
            android.R.layout.simple_list_item_2,
            parent,
            false
        )
        // TODO change layout so that table that is visible
        val expectedTextView: TextView = view.findViewById(android.R.id.text1)
        val fromTextView: TextView = view.findViewById(android.R.id.text2)
        val toTextView: TextView = view.findViewById(android.R.id.text1)
        return CycleViewHolder(view, expectedTextView, fromTextView, toTextView)
    }

    override fun onBindViewHolder(holder: CycleViewHolder, position: Int) {
        val cycle = this.cycles.get(position)
        holder.expectedTextView.setText(cycle.expected.toString())
        holder.fromTextView.setText(cycle.to.toString())
        holder.toTextView.setText(cycle.from.toString())
    }




}