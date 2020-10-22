package com.main.tracker.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.main.tracker.R
import com.main.tracker.adapter.CycleAdapter
import com.main.tracker.adapter.CycleViewHolder
import com.main.tracker.model.CycleRepository


class MainActivity : AppCompatActivity() {

    var adapter: RecyclerView.Adapter<CycleViewHolder>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(this)
        adapter = CycleAdapter(CycleRepository.getCycles())
        val dividerItemDecoration = DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        val recyclerView = findViewById<RecyclerView>(R.id.activity_main_overview)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = adapter

        recyclerView.addItemDecoration(dividerItemDecoration)

        val emptyViewDroplet = findViewById<ImageView>(R.id.empty_view_droplet)
        val emptyViewText = findViewById<TextView>(R.id.empty_view_text)

        if (CycleRepository.getCycles().isEmpty()) {
            recyclerView.visibility = View.INVISIBLE
            emptyViewDroplet.visibility = View.VISIBLE
            emptyViewText.visibility = View.VISIBLE
        } else {
            recyclerView.visibility = View.VISIBLE
            emptyViewDroplet.visibility = View.INVISIBLE
            emptyViewText.visibility = View.INVISIBLE
        }

        val fab = findViewById<FloatingActionButton>(R.id.fab_addnewperiod)
        fab.setOnClickListener{
            if (CycleRepository.getCycles().isEmpty()) {
                val intent = Intent(this, NextExpectedCycleActivity::class.java)
                startActivity(intent);
            } else {
                val intent = Intent(this, NewCycleActivity::class.java)
                startActivity(intent);
            }
        }
    }
}