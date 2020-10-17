package com.main.tracker.model.storage

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.main.tracker.model.Cycle


@Database(entities = [Cycle::class], version = 1)
@TypeConverters(DateTypeConverter::class)
abstract class CycleDatabase : RoomDatabase() {
    abstract fun cycleDao(): CycleDao
}