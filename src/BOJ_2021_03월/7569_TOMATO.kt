package BOJ_2021_03월

import java.util.*
import java.util.LinkedList
import java.util.Queue

/*
 3차원 BFS
*/

fun main() = with(Scanner(System.`in`)) {
    val (M, N, H) = readLine()!!.split(" ").map { it.toInt() }
    val tomato = Array(H) { Array(N) { IntArray(M) } }
    var cnt = 0
    var days = 0
    val que: Queue<IntArray> = LinkedList()

    for (h in 0 until H)
        for (n in 0 until N) for (m in 0 until M) {
            tomato[h][n][m] = nextInt()
            if (tomato[h][n][m] == 1) que.add(intArrayOf(h, n, m)) else if (tomato[h][n][m] == 0) cnt++
        }

    while (cnt > 0 && !que.isEmpty()) {
        val dy = intArrayOf(0, 0, -1, 1, 0, 0)
        val dx = intArrayOf(0, 0, 0, 0, -1, 1)
        val dz = intArrayOf(-1, 1, 0, 0, 0, 0)

        for (s in que.size downTo 1) {
            val cur = que.poll()
            for (k in 0..5) {
                val nz = cur[0] + dz[k]
                val ny = cur[1] + dy[k]
                val nx = cur[2] + dx[k]
                if (ny < 0 || nx < 0 || nz < 0 || ny >= N || nx >= M || nz >= H || tomato[nz][ny][nx] != 0) continue
                cnt--
                tomato[nz][ny][nx] = 1
                que.add(intArrayOf(nz, ny, nx))
            }
        }
        days++
    }
    println(if (cnt == 0) days else -1)
}