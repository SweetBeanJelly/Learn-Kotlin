package BOJ_2021_02월

import kotlin.math.min

/*
 RGB 거리에는 집이 N개 있다. 각 집은 빨강, 초록, 파랑으로 칠하는 비용이 있다. 비용의 최솟값 구하기
 1. 1번 집의 색은 2번 집의 색과 겹치지 않는다.
 2. N번 집의 색은 N-1번 집의 색과 겹치지 않는다.
 3. i(2 ≤ i ≤ N-1)번 집의 색은 i-1번, i+1번 집의 색과 겹치지 않는다.
*/

fun main() {
    println(rgb(readLine()!!.toInt()))
}

fun rgb(N: Int): Int {
    val dp = Array(N) { IntArray(3) }
    val price = Array(N) { IntArray(3) }

    repeat(N) {
        price[it] = readLine()!!.split(" ").map { input -> input.toInt() }.toIntArray()
    }

    dp[0][0] = price[0][0]
    dp[0][1] = price[0][1]
    dp[0][2] = price[0][2]

    for(i in 1 until N) {
        dp[i][0] = min(dp[i - 1][1], dp[i - 1][2]) + price[i][0]
        dp[i][1] = min(dp[i - 1][0], dp[i - 1][2]) + price[i][1]
        dp[i][2] = min(dp[i - 1][0], dp[i - 1][1]) + price[i][2]
    }

    return dp[price.size - 1].min()!!
}