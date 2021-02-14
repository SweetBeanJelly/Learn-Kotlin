package BOJ02

import java.util.*

/*
 N개의 정수로 이루어진 임의의 수열.
 이 중 연속된 몇 개의 수를 선택해서 구할 수 있는 합 중 가장 큰 합을 구하기
*/

fun main() {
    val N = readLine()!!.toInt()
    val array = readLine()!!.split(" ").map { it.toInt() }
    val dp = IntArray(N)

    dp[0] = array[0]

    for(i in 1 until N)
        if(dp[i - 1] + array[i] > array[i]) dp[i] = dp[i - 1] + array[i]
        else dp[i] = array[i]
    Arrays.sort(dp)
    print(dp[dp.size - 1])
}