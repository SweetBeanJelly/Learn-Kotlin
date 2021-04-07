package BOJ_2021_02월

import kotlin.math.sqrt

/*
 베르트랑 공준
 자연수 n이 주어졌을 때, n보다 크고, 2n보다 작거나 같은 소수의 개수를 구하기
*/

fun main() {
    fun check(N: Int): Int {
        var c = 0
        for(i in N + 1..N * 2) {
            var t = true
            for (j in 2 until sqrt(i.toDouble()).toInt() + 1)
                if (i % j == 0) {
                    t = false
                    break
                }
            if(t) c++
        }
        return c
    }

    while(true) {
        val N = readLine()!!.toInt()
        if(N == 0) break
        println(check(N))
    }
}