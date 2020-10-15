package com.main.tracker.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.main.tracker.model.storage.DateTypeConverter

import java.time.LocalDate



@Entity(tableName = "cycles")
@TypeConverters(DateTypeConverter::class)
class Cycle(@ColumnInfo var expected: LocalDate,
            @ColumnInfo var from: LocalDate,
            @ColumnInfo var to: LocalDate) {
    @PrimaryKey(autoGenerate = true)
    var id = 0

}
