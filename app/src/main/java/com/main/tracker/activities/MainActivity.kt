package com.main.tracker.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.main.tracker.R
import com.main.tracker.adapter.CycleAdapter
import com.main.tracker.adapter.CycleViewHolder
import com.main.tracker.model.Cycle
import com.main.tracker.model.CycleRepository
import com.main.tracker.model.CycleRepository.cycles
import com.main.tracker.model.storage.CycleDatabase


class MainActivity : AppCompatActivity() {

    var adapter: RecyclerView.Adapter<CycleViewHolder>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // TODO how to have the db load at startup and have it available across all activities?
        // Variante 1: load db for every activity
        // Variante 2:

        // Database stuff

        val db: CycleDatabase = Room.databaseBuilder(
            this,
            CycleDatabase::class.java,
            "roomcycles.db"
        ).build()

        val dao = db.cycleDao()

        val cycles: List<Cycle> = dao.getAllCycles()


        setContentView(R.layout.activity_main)

        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(this)
        adapter = CycleAdapter(CycleRepository.cycles)
        val dividerItemDecoration = DividerItemDecoration(this, DividerItemDecoration.VERTICAL)

        val recyclerView = findViewById<RecyclerView>(R.id.mens_overview)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = adapter

        recyclerView.addItemDecoration(dividerItemDecoration)

        val button = findViewById<Button>(R.id.addNewButton)
        button.setOnClickListener{
            if (CycleRepository.cycles.isEmpty()) {
                val intent = Intent(this, NextExpectedCycleActivity::class.java)
                startActivity(intent);
            } else {
                val intent = Intent(this, NewCycleActivity::class.java)
                startActivity(intent);
            }
            /*
            val intent = Intent(this, NewCycleActivity::class.java)
            startActivity(intent);*/
        }

    }
}