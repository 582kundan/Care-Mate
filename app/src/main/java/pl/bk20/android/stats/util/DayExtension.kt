package pl.bk20.android.stats.util

import pl.bk20.android.core.domain.model.Day
import java.time.LocalDate

fun List<Day>.alignWeek(
    firstDay: LocalDate,
    lastDay: LocalDate = firstDay.plusDays(6),
): List<Day> {
    val alignedWeek = mutableListOf<Day>()
    for (date in firstDay..lastDay) {
        val currentDay = singleOrNull { it.date == date }
        alignedWeek.add(currentDay ?: Day(date, goal = 0))
    }
    return alignedWeek
}