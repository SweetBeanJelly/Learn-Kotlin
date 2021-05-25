package kakao.practice_level2

fun main() {
    fun solution(s: String): String {
        val temp = s.split(" ").map { it.toInt() }
        return "${temp.minOrNull()} ${temp.maxOrNull()}"
    }
    print(solution("-1 -1"))
}