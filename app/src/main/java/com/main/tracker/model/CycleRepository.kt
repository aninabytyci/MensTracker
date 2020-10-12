package com.main.tracker.model

import java.time.LocalDate
import java.util.*


object CycleRepository {
    val cycles: LinkedList<Cycle> = LinkedList()

    init {
        
        cycles.addFirst(Cycle(LocalDate.parse("2020-01-02")))
        cycles[0].from = LocalDate.parse("2020-01-01")
        cycles[0].to = LocalDate.parse("2020-01-08")

        cycles.addFirst(Cycle(LocalDate.parse("2020-03-04")))
        cycles[0].from = LocalDate.parse("2020-03-05")
        cycles[0].to = LocalDate.parse("2020-03-11")

        cycles.addFirst(Cycle(LocalDate.parse("2020-05-06")))

    }

}

