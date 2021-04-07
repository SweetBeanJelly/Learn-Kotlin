package BOJ_2021_03월

import java.util.*

/*
 2차원 BFS
*/

fun main() {
    val (M, N) = readLine()!!.split(" ").map { it.toInt() }
    val tomato = Array(N) { IntArray(M) }
    var cnt = 0
    var days = 0
    val que = LinkedList<IntArray>()

    for (n in 0 until N) {
        val str = StringTokenizer(readLine()!!, " ")
        for (m in 0 until M) {
            tomato[n][m] = str.nextToken().toInt()
            if (tomato[n][m] == 1) que.add(intArrayOf(n, m)) else if (tomato[n][m] == 0) cnt++
        }
    }

    while (cnt > 0 && !que.isEmpty()) {
        val dy = intArrayOf(-1, 1, 0, 0)
        val dx = intArrayOf(0, 0, -1, 1)
        for (s in que.size downTo 1) {
            val cur = que.poll()
            for (k in 0..3) {
                val ny = cur[0] + dy[k]
                val nx = cur[1] + dx[k]
                if (ny < 0 || nx < 0 || ny >= N || nx >= M || tomato[ny][nx] != 0) continue
                cnt--
                tomato[ny][nx] = 1
                que.add(intArrayOf(ny, nx))
            }
        }
        days++
    }
    println(if (cnt == 0) days else -1)
}

/*
  val sc = Scanner(System.`in`)

  val m = sc.nextInt()
  val n = sc.nextInt()
  val a = Array< IntArray >(n) { IntArray(m) { sc.nextInt() } }

  val queue: Queue<Pair<Int, Int>> = ArrayDeque<Pair<Int, Int>>()

  val d = Array< IntArray >(n) { IntArray(m) { -1 } }

  for(i in 0 until n) {
    for(j in 0 until m) {
      if(a[i][j] == 1) {
        queue.add( Pair(i, j) )
        d[i][j] = 0
      }
    }
  }

  while(!queue.isEmpty()) {
    val (x, y) = queue.poll()
    for((nx, ny) in arrayOf(Pair(x-1, y), Pair(x+1, y), Pair(x, y-1), Pair(x, y+1))) {
      if(0 <= nx && nx < n && 0 <= ny && ny < m && a[nx][ny] == 0 && d[nx][ny] == -1) {
        queue.add( Pair(nx, ny) )
        d[nx][ny] = d[x][y] + 1
      }
    }
  }

  for(i in 0 until n) {
    for(j in 0 until m) {
      if(a[i][j] == 0) {
        if(d[i][j] == -1) {
          println(-1)
          return
        }
      }
    }
  }

  println(d.map { it.max() ?: 0 }.max())
*/