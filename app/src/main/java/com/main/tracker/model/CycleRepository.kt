package com.main.tracker.model

import java.time.LocalDate

class CycleRepository {
    val cycles: ArrayList<Cycle>
    init {
        cycles = ArrayList()
        cycles.add(Cycle(LocalDate.parse("2020-01-02")))
        cycles.add(Cycle(LocalDate.parse("2020-03-04")))
        cycles.add(Cycle(LocalDate.parse("2020-05-06")))
    }

}