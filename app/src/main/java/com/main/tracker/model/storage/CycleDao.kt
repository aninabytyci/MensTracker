package com.main.tracker.model.storage

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

import com.main.tracker.model.Cycle
import java.util.*

@Dao
interface CycleDao {
    @Insert
    fun insertCycle(cycle: Cycle) // returns rowId: long

    @Query("SELECT * from cycles  ORDER BY id DESC")
    fun getAllCycles(): List<Cycle>

    // @Query("SELECT * from cycles WHERE `from` LIKE '1640-06-05'")
    @Query("SELECT * from cycles WHERE `from` is null")
    fun getNextExpectedCycle() : Cycle

    @Update
    fun updateCycle(cycle: Cycle)
}