package com.main.tracker.model

import android.content.Context
import androidx.room.Room
import com.main.tracker.model.storage.CycleDatabase
import java.time.LocalDate
import java.util.*


object CycleRepository {

    private lateinit var database: CycleDatabase

    @JvmStatic
    fun initialize(context: Context) {
        database = Room.databaseBuilder(
            context,
            CycleDatabase::class.java,
            "roomcycles.db"
        ).allowMainThreadQueries().build()
        /*
        if (getCycles().isEmpty()) {  // TODO: change to show image instead of prepopulated db when empty
            addCycle(Cycle(LocalDate.parse("2020-01-01"), LocalDate.parse("2020-01-01"), LocalDate.parse("2020-01-08")))
            addCycle(Cycle(LocalDate.parse("2020-02-02"), LocalDate.parse("2020-02-10"), LocalDate.parse("2020-02-17")))
            addCycle(Cycle(LocalDate.parse("2020-03-03"), LocalDate.parse("2020-03-05"), LocalDate.parse("2020-03-12"))            )
            addCycle(Cycle(LocalDate.parse("2020-04-01"), null, null))
        }
        */
    }

    fun addCycle(cycle: Cycle) {
        database.cycleDao().insertCycle(cycle)
    }

    fun updateCycle(from: LocalDate, to: LocalDate) {
        val  expectedCycle: Cycle = database.cycleDao().getNextExpectedCycle()
        expectedCycle.from = from
        expectedCycle.to = to
        database.cycleDao().updateCycle(expectedCycle)
    }


    fun getCycles(): List<Cycle> {
        return database.cycleDao().getAllCycles()
    }
}
