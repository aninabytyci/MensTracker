package com.main.tracker.model

import java.time.LocalDate

object CycleRepository {
    val cycles: ArrayList<Cycle> = ArrayList()

    init {
        cycles.add(Cycle(LocalDate.parse("2020-01-02")))
        cycles.get(0).from = LocalDate.parse("2020-01-01")
        cycles.get(0).to = LocalDate.parse("2020-01-08")

        cycles.add(Cycle(LocalDate.parse("2020-03-04")))
        cycles.get(1).from = LocalDate.parse("2020-03-05")
        cycles.get(1).to = LocalDate.parse("2020-03-11")

        cycles.add(Cycle(LocalDate.parse("2020-05-06")))
    }

    fun addCycle(cycle: Cycle) {
        cycles.add(cycle)
    }
}

