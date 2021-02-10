package BOJ02

import kotlin.math.min

/*
 정수 X 연산
 1. X가 3으로 나누어 떨어지면, 3으로 나눈다
 2. X가 2로 나누어 떨어지면, 2로 나눈다
 3. 1을 뺀다
 정수 N 이 주어졌을 때 X 연산 사용하여 1 만든다. 연산 사용 횟수의 최솟값 출력하기
*/

fun main() {
    val N = readLine()!!.toInt()
    val dp = IntArray(N + 1)
    for(i in 2..N) {
        dp[i] = dp[i - 1] + 1
        if(i % 2 == 0) dp[i] = min(dp[i], dp[i / 2] + 1)
        if(i % 3 == 0) dp[i] = min(dp[i], dp[i / 3] + 1)
    }
    print(dp[N])
}