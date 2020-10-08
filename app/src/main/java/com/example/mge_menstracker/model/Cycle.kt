package com.example.mge_menstracker.model

import java.time.LocalDate
import java.util.*

private class Cycle(exp: Date) {

    var expected: Date = exp
    var from = LocalDate.parse("1989-6-4")  // val = readonly, var = RW
    var to = LocalDate.parse("1989-6-11")

}