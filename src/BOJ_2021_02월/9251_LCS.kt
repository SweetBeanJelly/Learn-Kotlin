package BOJ_2021_02월

/*
 두 수열이 주어졌을 때, 모두의 부분 수열이 되는 수열 중 가장 긴 것을 찾는 문제
*/

fun main() {
    val (A: String, B: String) = readLine()!! to readLine()!!
    val dp = Array(B.length + 1) { IntArray(A.length + 1) }

    for (i in 1..B.length)
        for (j in 1..A.length)
            if (B[i - 1] !== A[j - 1]) dp[i][j] = dp[i][j - 1].coerceAtLeast(dp[i - 1][j])
            else dp[i][j] = dp[i - 1][j - 1] + 1
    print(dp[B.length][A.length])
}