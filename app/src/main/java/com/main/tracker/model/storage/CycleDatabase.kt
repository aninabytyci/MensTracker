package com.main.tracker.model.storage

import androidx.room.Database
import androidx.room.RoomDatabase
import com.main.tracker.model.Cycle


@Database(entities = [Cycle::class], version = 1)
abstract class CycleDatabase : RoomDatabase() {
    abstract fun cycleDao(): CycleDao
}