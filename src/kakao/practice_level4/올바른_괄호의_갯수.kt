package kakao.practice_level4

// https://programmers.co.kr/learn/courses/30/lessons/12929
// catalan number

fun main() {

    /*
    fun result(n: Int): Int {
        if(n == 1) return 1
        return n * result(n - 1)
    }
    fun solution(n: Int) = result(2 * n) / (result(n + 1) * result(n))
    */

    fun solution(n: Int): Int {
        var result = 0
        fun test(a: Int, b: Int) {
            if(a == 0 && b == n) {
                result++
                return
            }
            if(a > 0) test(a - 1, b)
            if(n - a > b) test(a, b + 1)

        }
        test(n, 0)
        return result
    }
    print(solution(3))
}

/*
fun solution(n: Int): Int {
        val dp = Array(n + 1) { 0 }
        dp[0] = 1
        dp[1] = 1
        for (i in 2..n)
            for (j in 1..i)
                dp[i] += dp[j - 1] * dp[i - j]
        return dp[n]
    }
*/