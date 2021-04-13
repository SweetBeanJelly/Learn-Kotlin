package kakao.practice_level1

fun main() {
    fun solution(s: String): Boolean = s.toIntOrNull() != null && s.length in intArrayOf(4, 6)
    print(solution("a234"))
}