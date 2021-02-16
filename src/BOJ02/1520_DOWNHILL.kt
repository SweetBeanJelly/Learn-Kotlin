package BOJ02

import java.util.*

/*
 제일 왼쪽 위 지점에서 출발하여 제일 오른쪽 아래 지점까지 항상 내리막길로만 이동하는 경로의 개수
*/

fun main() {
    val (M: Int, N: Int) = readLine()!!.split(" ").map { it.toInt() }
    val array = Array(M + 1) { IntArray(N + 1) }
    val dp = Array(M + 1) { IntArray(N + 1) }

    for(i in 1..M) {
        val str = StringTokenizer(readLine())
        for(j in 1..N) {
            array[i][j] = str.nextToken().toInt()
            dp[i][j] = -1
        }
    }
    print(dfs(1, 1, M, N, array, dp))
}

fun dfs(X: Int, Y: Int, M: Int, N: Int, array: Array<IntArray>, dp: Array<IntArray>): Int {
    val dx = intArrayOf(1, 0, -1, 0)
    val dy = intArrayOf(0, 1, 0, -1)

    if(X == M && Y == N) return 1
    if(dp[X][Y] == -1) {
        dp[X][Y] = 0
        for (i in dx.indices) {
            val nx = X + dx[i]
            val ny = Y + dy[i]
            if (nx in 1..M && ny in 1..N && array[X][Y] > array[nx][ny]) dp[X][Y] += dfs(nx, ny, M, N, array, dp)
        }
    }

    return dp[X][Y]
}

/*
val dx = arrayOf(1,-1,0,0)
val dy = arrayOf(0,0,1,-1)

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (N,M) = readLine()!!.split(' ').map{it.toInt()}
    val arr = Array(N) {readLine()!!.split(' ').map{it.toInt()}}
    val dp = Array(N) {Array(M) {-1}}

    fun go(x : Int, y : Int) : Int {
        if(x == M - 1 && y == N - 1) return 1
        if(dp[y][x] != -1) return dp[y][x]
        var sum = 0
        for(i in 0..3) {
            val nx = dx[i] + x
            val ny = dy[i] + y
            if(nx<0 || ny<0 || nx==M || ny==N || arr[ny][nx] >= arr[y][x]) continue;
            sum += go(nx, ny)
        }
        dp[y][x] = sum
        return dp[y][x]
    }
    print(go(0,0))
}
*/