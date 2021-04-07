package BOJ_2021_02월

import kotlin.math.abs

/*
 양팔 저울. 주어진 구슬의 무게를 확인
 추의 최대 무게합(30*500(g)) + 구슬의 최대 무게(40000)
*/

fun main() {
    val N = readLine()!!.toInt()
    val array1 = readLine()!!.split(" ").map { it.toInt() }
    val M = readLine()!!.toInt()
    val array2 = readLine()!!.split(" ").map { it.toInt() }

    val dp = Array(N + 1) { BooleanArray(55001) }

    fun dfs(count: Int, weight: Int) {
        if(dp[count][weight]) return
        dp[count][weight] = true
        if(count == N) return

        dfs(count + 1, weight + array1[count])
        dfs(count + 1, weight)
        dfs(count + 1, abs(weight - array1[count]))
    }

    dfs(0, 0)
    for(i in 0 until M) {
        if(dp[N][array2[i]]) {
            print("Y ")
            continue
        }
        print("N ")
    }
}