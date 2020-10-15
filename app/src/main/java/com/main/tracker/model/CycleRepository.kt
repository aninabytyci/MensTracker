package com.main.tracker.model

import android.content.Context
import androidx.room.Room
import com.main.tracker.model.storage.CycleDatabase
import java.time.LocalDate
import java.util.*


object CycleRepository {
    val cycles: LinkedList<Cycle> = LinkedList()

    private var database: CycleDatabase? = null

    init {
        
        cycles.addFirst(Cycle(LocalDate.parse("2020-01-02"), null, null))
        cycles[0].from = LocalDate.parse("2020-01-01")
        cycles[0].to = LocalDate.parse("2020-01-08")

        cycles.addFirst(Cycle(LocalDate.parse("2020-03-04"), null, null))
        cycles[0].from = LocalDate.parse("2020-03-05")
        cycles[0].to = LocalDate.parse("2020-03-11")

        cycles.addFirst(Cycle(LocalDate.parse("2020-05-06"), null, null))

    }

    fun initialize(context: Context) {  // TODO initialized DB
        database = Room.databaseBuilder(
            context,
            CycleDatabase::class.java,
            "roomcycles.db"
        ).allowMainThreadQueries().build()
        if (cycles.size == 0) {  // TODO: change to show image instead of prepopulated db
            addCycle(Cycle( LocalDate.parse("2020-01-01"), LocalDate.parse("2020-01-01"), LocalDate.parse("2020-01-08")))
            addCycle(Cycle(LocalDate.parse("2020-02-02"), LocalDate.parse("2020-02-10"), LocalDate.parse("2020-02-17")))
            addCycle(Cycle(LocalDate.parse("2020-03-03"), LocalDate.parse("2020-03-05"), LocalDate.parse("2020-03-12"))            )
            addCycle(Cycle(LocalDate.parse("2020-04-01"), null, null))
        }
    }

    fun addCycle(cycle: Cycle) {
        database?.cycleDao()?.insertCycle(cycle)
    }

    fun updateCycle(cycle: Cycle) {
        database?.cycleDao()?.updateCycle(cycle)
    }


    fun getCycles(): List<Cycle?>? {
        return database?.cycleDao()?.getAllCycles()
    }


}
