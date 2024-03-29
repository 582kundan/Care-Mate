package pl.bk20.android.core.data.repository

import kotlinx.coroutines.flow.Flow
import pl.bk20.android.core.data.source.DayDao
import pl.bk20.android.core.domain.model.Day
import pl.bk20.android.core.domain.model.DaySettings
import pl.bk20.android.core.domain.repository.DayRepository
import java.time.LocalDate

class DayRepositorylmpl(
    private val dao: DayDao
) : DayRepository {

    override fun getTreeCount(): Flow<Int> {
        return dao.getTreeCount()
    }

    override fun getFirstDay():Flow<Day?> {
        return dao.getDay(date)
    }

    override fun getDay(date: LocalDate): Flow<Day?> {
        return dao.getDay(date)
    }

    override suspend fun getAllDays(): List<Day> {
        return dao.getAllDays()
    }

    override fun getDays(range: ClosedRange<LocalDate>): Flow<List<Day>> {
        return dao.getDays(range.start, range.endInclusive )
    }

    override suspend fun upsertDay(day:Day) {
        dao.upsertDay(day)
    }
   override suspend fun updateDaySettings(daySettings : DaySettings) {
       dao.updateDaySettings(daySettings)
    }
}