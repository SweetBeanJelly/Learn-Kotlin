package BOJ02

import java.util.*

/*
 여행에 필요한 N개의 물건. 각 물건은 무게W, 가치V 가진다. 최대 K의 무게만을 넣을 수 있다.
 배낭에 넣을 수 있는 물건들의 가치의 최댓값 구하기
*/

fun main() {
    val (N: Int, K: Int) = readLine()!!.split(" ").map { it.toInt() }
    val array = Array(N + 1) { IntArray (2) }
    val dp = Array(K + 1) { IntArray(N + 1) }

    for(i in 1..N) {
        val str = StringTokenizer(readLine()!!)
        array[i][0] = str.nextToken().toInt()
        array[i][1] = str.nextToken().toInt()
    }
    for(i in 1..K)
        for(j in 1..N)
            if(i >= array[j][0]) dp[i][j] = dp[i][j - 1].coerceAtLeast(dp[i - array[j][0]][j - 1] + array[j][1])
            else dp[i][j] = dp[i][j - 1]
    print(dp[K][N])
}

