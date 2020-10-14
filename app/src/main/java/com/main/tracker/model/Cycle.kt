package com.main.tracker.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

import java.time.LocalDate



@Entity(tableName = "cycles")
class Cycle(expectedDate: LocalDate) {
    @PrimaryKey(autoGenerate = true)
    var id = 0

    @ColumnInfo
    var expected: LocalDate

    @ColumnInfo
    var from: LocalDate? = null  // val = readonly, var = RW

    @ColumnInfo
    var to: LocalDate? = null

    init {
        this.expected = expectedDate
    }

}
/* Innerhalb App: LocalDate, aber Room bzw. SQL erkennt LocalDate nicht
*
* /
