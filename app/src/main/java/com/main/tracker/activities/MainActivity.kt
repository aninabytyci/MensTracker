package com.main.tracker.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
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
        adapter = CycleAdapter(CycleRepository.cycles)
        val dividerItemDecoration = DividerItemDecoration(this, DividerItemDecoration.VERTICAL)

        val recyclerView = findViewById<RecyclerView>(R.id.mens_overview)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = adapter
        recyclerView.addItemDecoration(dividerItemDecoration)

        val button = findViewById<Button>(R.id.button_addnew)
        button.setOnClickListener{
            val intent = Intent(this, NextExpectedCycleActivity::class.java)
            startActivity(intent);
        }

    }
}