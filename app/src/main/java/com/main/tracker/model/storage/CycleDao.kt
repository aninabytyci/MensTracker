package com.main.tracker.model.storage

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

import com.main.tracker.model.Cycle

@Dao
interface CycleDao {
    @Insert
    fun insertCycle(cycle: Cycle)

    @Query("SELECT * from cycles  ORDER BY id DESC")
    fun getAllCycles(): List<Cycle>

    @Query("SELECT * from cycles WHERE `from` is null")
    fun getNextExpectedCycle() : Cycle

    @Update
    fun updateCycle(cycle: Cycle)
}