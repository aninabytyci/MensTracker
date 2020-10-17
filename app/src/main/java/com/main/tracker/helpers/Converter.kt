package com.main.tracker.helpers

import java.time.LocalDate
import java.time.ZoneId
import java.util.*

object Converter {

    fun convertDatetoLocalDate(date: Date): LocalDate {
        return date.toInstant()
            .atZone(ZoneId.systemDefault())
            .toLocalDate()
    }
}