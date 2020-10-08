package com.main.tracker.model

import java.time.LocalDate

class Cycle(expectedDate: LocalDate) {

    var expected: LocalDate
    var from: LocalDate? = null  // val = readonly, var = RW
    var to: LocalDate? = null  // https://www.bignerdranch.com/blog/kotlin-when-to-use-lazy-or-lateinit/

    init {
        this.expected = expectedDate
    }

}

