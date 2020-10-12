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
    var to: LocalDate? = null  // https://www.bignerdranch.com/blog/kotlin-when-to-use-lazy-or-lateinit/

    init {
        this.expected = expectedDate
    }

}
