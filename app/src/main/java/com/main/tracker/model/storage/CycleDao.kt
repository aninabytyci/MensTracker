package com.main.tracker.model.storage

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

import com.main.tracker.model.Cycle

@Dao
interface CycleDao {
    @Insert
    fun insertCycle(cycle: Cycle) // returns rowId: long

    @Query("SELECT * from cycles")
    fun getAllCycles(): List<Cycle>

    @Update
    fun updateCycle(cycle: Cycle)

}