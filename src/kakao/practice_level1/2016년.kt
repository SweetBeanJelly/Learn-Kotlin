package kakao.practice_level1

fun main() {
    fun solution(a: Int, b: Int): String {
        val year = listOf(31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31) // 윤년
        val day = listOf("THU", "FRI", "SAT", "SUN", "MON", "TUE", "WED")
        val today = (0 until a - 1).map { year[it] }.sum() + b

        return day[today % 7]
    }
    print(solution(5, 24))
}