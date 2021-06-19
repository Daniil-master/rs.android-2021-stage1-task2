package subtask1

import java.text.SimpleDateFormat
import java.util.*

class DateFormatter {

    fun toTextDay(day: String, month: String, year: String): String {
        val dayInt = day.toInt()     // конвертация в числовой тип
        val monthInt = month.toInt() - 1
        val yearInt = year.toInt()

        val calendar = GregorianCalendar.getInstance() as GregorianCalendar // реализация григорианского календаря
        calendar.set(yearInt, monthInt, dayInt)

        if (!calendar.isLeapYear(calendar[GregorianCalendar.YEAR]) && dayInt == 29 && monthInt == 1 || dayInt > 31 || monthInt > 11 || yearInt < 0)
            return "Такого дня не существует"

        val dateFormat = SimpleDateFormat("d MMMM, EEEE") // формируем данные для нашего типа
        return dateFormat.format(calendar.time)
    }
}
