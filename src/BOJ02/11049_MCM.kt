package BOJ02

import java.util.*

/*
 크기가 N×M인 행렬 A, M×K인 B를 곱할 때 필요한 곱셈 연산의 수는 총 N×M×K번.
 행렬 N개를 곱하는데 필요한 곱셈 연산의 수는 행렬을 곱하는 순서에 따라 달라지게 된다.
 행렬 N개의 크기가 주어졌을 때, 모든 행렬을 곱하는데 필요한 곱셈 연산 횟수의 최솟값을 구하는 프로그램을 작성하시오. 입력으로 주어진 행렬의 순서를 바꾸면 안 된다.
*/

fun main() {
    val N = readLine()!!.toInt()
    val array = Array(N) { IntArray (2) }
    val dp = Array(N) { IntArray(N) }

    for(i in 0 until N) {
        val str = StringTokenizer(readLine()!!)
        array[i][0] = str.nextToken().toInt()
        array[i][1] = str.nextToken().toInt()
    }

    for(i in 1 until N) {
        for(j in 0 until N - i) {
            dp[j][j + i] = Integer.MAX_VALUE
            for(k in 0 until i) dp[j][j+i] = dp[j][j + i].coerceAtMost(dp[j][j + k] + dp[j + k + 1][j + i] + array[j][0] * array[j + k][1] * array[j + i][1])
        }
    }
    println(dp[0][N - 1])
}