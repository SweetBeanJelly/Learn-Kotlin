package kakao.practice_level1

fun main() {
    fun solution(n: Long): IntArray = n.toString().reversed().map { it.toString().toInt() }.toIntArray()
    print(solution(1234567))
}