package kakao.kit

import kotlin.math.sqrt

// https://programmers.co.kr/learn/courses/30/lessons/42842

fun main() {
    fun solution(brown: Int, yellow: Int): IntArray {
        val i = ((brown / 2) + 2)
        val j = brown + yellow

        val dist = sqrt(((i * i) - (4 * j)).toDouble())

        val x = (i + dist) / 2
        val y = (i - dist) / 2

        return intArrayOf(x.toInt(), y.toInt())
    }
    print(solution(24, 24).contentToString())
}