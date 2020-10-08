package com.main.tracker.model

import java.time.LocalDate

class Cycle(expectedDate: LocalDate) {

    var expected: LocalDate
    var from: LocalDate = LocalDate.parse("1989-6-4")  // val = readonly, var = RW
    var to = LocalDate.parse("1989-6-11")

    init {
        this.expected = expectedDate
    }

}

