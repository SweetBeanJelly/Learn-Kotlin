package kakao.practice_level1

fun main() {
    fun solution(s: String): String {
        return s.split(" ").joinToString(" ") {
            it.mapIndexed { i, j ->
                when (i % 2) {
                    0 -> j.toUpperCase()
                    else -> j.toLowerCase()
                }
            }.joinToString("")
        }
    }
    print(solution("try hello world"))
}