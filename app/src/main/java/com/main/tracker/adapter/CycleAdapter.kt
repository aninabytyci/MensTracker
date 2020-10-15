package com.main.tracker.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView
import com.main.tracker.R

import com.main.tracker.model.Cycle;

class CycleAdapter(private var cycles: List<Cycle>) : RecyclerView.Adapter<CycleViewHolder>() {

    override fun getItemCount(): Int {
        return this.cycles.size
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

        return CycleViewHolder(view, expectationTextView, realityTextView, context)
    }

    override fun onBindViewHolder(holder: CycleViewHolder, position: Int) {
        val cycle = this.cycles.get(position)

        // we need to retrieve the context, since adapter is not child of context, but context is part of activity, not adapter.
        // solution: initialize CycleViewHolder with context object
        holder.expectationTextView.text = holder.context.getString(R.string.expectation_list, cycle.expected.toString())

        if (cycle.from == null) {
            holder.realityTextView.text = ""

        } else {
            holder.realityTextView.text = holder.context.getString(R.string.reality_list, cycle.from.toString(), cycle.to.toString())
        }



    }




}