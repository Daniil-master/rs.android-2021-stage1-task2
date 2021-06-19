package subtask3

import java.text.SimpleDateFormat
import java.time.LocalDate
import java.util.*
import kotlin.reflect.KClass

class Blocks {

    fun getData(blockA: Array<*>, blockB: KClass<*>): Any {
        if (blockB == Int::class) { // проверяем KClass на соответвие объекта (типа)
            var sumInt = 0 // данные для сбора чисел
            blockA.forEachIndexed { index, elAny -> // проходим по все элементам
                if (elAny is Int) { //println("Попали в цикл Чисел: $elAny") проверка на тип
                    sumInt += elAny.toString().toInt()
                }
            }
            return sumInt

        } else if (blockB == String::class) {
            var sumString = ""
            blockA.forEachIndexed { index, elAny ->
                if (elAny is String) { //  println("Попали в цикл Строк: $elAny")
                    sumString += elAny.toString()
                }
            }
            return sumString

        } else if (blockB == LocalDate::class) {

            var maxLocalDate = LocalDate.parse("0001-01-01")
            blockA.forEachIndexed { index, elAny ->
                if (elAny is LocalDate) { // println("Попали в цикл Дат: $elAny")
                    val date: LocalDate = elAny
                    if (date.compareTo(maxLocalDate) > 0) // если есть отклонение выше на дни то берем
                        maxLocalDate = date
                }
            }

            val calendar = Calendar.getInstance() // создаем календарь
            calendar.set(maxLocalDate.year, maxLocalDate.monthValue - 1, maxLocalDate.dayOfMonth) // устанавливаем дату из LocalDate
            val dateFormat = SimpleDateFormat("dd.MM.yyyy")

            return dateFormat.format(calendar.time)

        }

        return false
    }
}
