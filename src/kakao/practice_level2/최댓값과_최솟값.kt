package kakao.practice_level2

fun main() {
    fun solution(s: String): String {
        val temp = s.split(" ").map { it.toInt() }
        val answer = "${temp.min()} ${temp.max()}"
        return answer
    }
    print(solution("-1 -1"))
}