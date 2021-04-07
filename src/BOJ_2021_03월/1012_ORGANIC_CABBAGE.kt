package BOJ_2021_03월

import java.util.*

fun main() {
    repeat(readLine()!!.toInt()) {
        val (N, M, K) = readLine()!!.split(" ").map { it.toInt() }
        val array = Array(N) { Array(M) {0} }
        var result = 0

        repeat(K) {
            val (X, Y) = readLine()!!.split(" ").map { it.toInt() }
            array[X][Y] = 1
        }

        fun bfs(x: Int, y: Int) {
            val q = LinkedList<Pair<Int, Int>>()
            val dx = arrayListOf(0, 1, 0, -1)
            val dy = arrayListOf(1, 0, -1, 0)

            q.offer(Pair(x, y))
            while(!q.isEmpty()) {
                val temp = q.poll()
                for(i in 0..3) {
                    val nx = temp.first + dx[i]
                    val ny = temp.second + dy[i]
                    if(nx < 0 || nx >= N || ny < 0 || ny >= M || array[nx][ny] != 1) continue
                    array[nx][ny] = 2
                    q.offer(Pair(nx, ny))
                }
            }
        }

        for(i in 0 until N)
            for(j in 0 until M)
                if(array[i][j] == 1) {
                    bfs(i, j)
                    result++
                }
        println(result)
    }
}

/*
fun main(args: Array<String>) = with(Scanner(System.`in`)) {
    for (c in 1..nextInt()) {
        val m = nextInt()
        val n = nextInt()
        val k = nextInt()

        val field = Array(m) { BooleanArray(n) { false } }

        fun process(x: Int, y: Int) {
            field[x][y] = false

            if (x > 0) if (field[x - 1][y]) process(x - 1, y)
            if (x < m - 1) if (field[x + 1][y]) process(x + 1, y)
            if (y > 0) if (field[x][y - 1]) process(x, y - 1)
            if (y < n - 1) if (field[x][y + 1]) process(x, y + 1)
        }

        for (l in 1..k) {
            field[nextInt()][nextInt()] = true
        }

        var count = 0

        for (x in 0 until m) for (y in 0 until n) {
            if (field[x][y]) {
                process(x, y)
                count++
            }
        }

        println(count)
    }
}
*/