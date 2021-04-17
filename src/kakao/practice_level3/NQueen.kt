package kakao.practice_level3

import kotlin.math.abs

fun main() {
    fun solution(n: Int): Int {
        var answer = 0
        var array = IntArray(n)

        fun queen(x: Int, y: Int) {
            repeat(y) {
                if(array[it] == x || abs(x - array[it]) == y - it) return
            }
            if(y == n - 1) {
                answer++
                return
            }
            repeat(n) {
                array[y + 1] = it
                queen(it, y + 1)
            }
        }

        for(i in 0 until n) {
            array[0] = i
            queen(i, 0)
        }

        return answer
    }
    print(solution(4))
}