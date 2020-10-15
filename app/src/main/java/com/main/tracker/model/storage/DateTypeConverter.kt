package com.main.tracker.model.storage

import androidx.room.TypeConverter
import java.time.LocalDate

class DateTypeConverter {
    @TypeConverter
    fun fromLocalDate(value: String): LocalDate {
        // retrieving values from the DB
        return value.let { LocalDate.parse(value) }

    }

    @TypeConverter
    fun toLocalDate(date: LocalDate?): String? {
        // prepairing a value for the DB to be stored
        return date.toString()

    }
}