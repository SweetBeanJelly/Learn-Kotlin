package BOJ02

/*
 수열 A의 가장 긴 증가하는 부분 수열 구하기
*/

fun main() {
    val N = readLine()!!.toInt()
    val array = readLine()!!.split(" ").map { it.toInt() }
    val dp = IntArray(N) {0}

    for(i in array.indices) {
        for (j in 0 until i)
            if (array[i] > array[j] && dp[i] < dp[j]) dp[i] = dp[j]
        dp[i] += 1
    }
    print(dp.max())
}