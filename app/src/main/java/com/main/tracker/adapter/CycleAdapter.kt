package com.main.tracker.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView
import com.main.tracker.R

import com.main.tracker.model.Cycle;
import java.util.*

class CycleAdapter(cycles: LinkedList<Cycle>) : RecyclerView.Adapter<CycleViewHolder>() {
    private var cycles: LinkedList<Cycle>

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
        val view = inflater.inflate(
            R.layout.three_line_list_item,
            parent,
            false
        )
        val expectationTextView: TextView = view.findViewById(R.id.show_expectation)
        val realityTextView: TextView = view.findViewById(R.id.show_reality)

        return CycleViewHolder(view, expectationTextView, realityTextView)
    }

    override fun onBindViewHolder(holder: CycleViewHolder, position: Int) {
        val cycle = this.cycles.get(position)
        holder.expectationTextView.text = "Expectation: " + cycle.expected.toString()
        // TODO: extracting String + input does not work:
        //  holder.expectationTextView.text = getString(R.string.expectation_list, cycle.expected.toString())
        if (cycle.from != null) {
            holder.realityTextView.text = "Reality: " + cycle.from.toString() + " - " + cycle.to.toString()
        } else {
            holder.realityTextView.text = ""
        }



    }




}