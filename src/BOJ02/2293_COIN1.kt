package BOJ02

/*
 N가지 종류의 동전. 각각 동전의 가치의 합을 K원이 되도록 하고싶다. 그 경우의 수 구하기
*/

fun main() {
    val (N, K) = readLine()!!.split(" ").map { it.toInt() }
    val dp = IntArray(K + 1)
    dp[0] = 1
    for(i in 0 until N) {
        val temp = readLine()!!.toInt()
        for (j in 1 until K + 1)
            if (j >= temp) dp[j] += dp[j - temp]
    }
    print(dp[K])
}

/*
val (n, k) = readLine()!!.split("\\s".toRegex()).map { it.toInt() }
    val dp = Array(100001) { 0 }.apply { this[0] = 1 }
    repeat(n) {
        val c = readLine()!!.toInt()
        (c..k).forEach { idx ->
            dp[idx] += dp[idx - c]
        }
    }
    println(dp[k])
*/