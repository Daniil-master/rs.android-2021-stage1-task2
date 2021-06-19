package subtask2

class Abbreviation {


    fun abbreviationFromA(a: String, b: String): String {
        val aUp = a.toUpperCase()
        var i = 0
        var aToB = ""

        aUp.forEachIndexed { index, el ->
            if (i < b.length && el == b.get(i)) {
                aToB += el
                i++
            }
        }

        return if (aToB == b) "YES" else "NO"
    }
}
