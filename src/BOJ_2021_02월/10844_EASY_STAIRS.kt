package BOJ_2021_02월

import java.util.*

/*
 인접한 모든 자리수의 차이가 1 = 계단 수
 N이 주어질 때 길이가 N인 계단 수가 총 몇개 있는지 구하기 (0으로 시작하는 수 없다.)
*/

fun main() {
    val N = readLine()!!.toInt()
    val dp = Array(N + 2) { LongArray(10) }
    for(i in 1..9) {
        dp[1][i] = 1
        if(i == 9) dp[2][i] = 1 else dp[2][i] = 2
    }
    val mod = 1000000000
    for(i in 3..N)
        for(j in 1..9) {
            when(j) {
                1 -> dp[i][j] = (dp[i - 2][j] + dp[i - 1][j + 1]) % mod
                9 -> dp[i][j] = dp[i - 1][j - 1] % mod
                else -> dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % mod
            }
        }
    println(Arrays.stream(dp[N]).sum() % mod)
}