package kakao.practice_level1

import kotlin.math.sqrt

fun main() {
    fun solution(n: Long): Long {
        val answer: Long = sqrt(n.toDouble()).toLong()
        return if(answer * answer == n)
            (answer + 1) * (answer + 1)
        else -1
    }
    print(solution(3))
}