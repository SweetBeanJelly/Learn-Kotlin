package BOJ_2021_04월

import java.util.PriorityQueue

fun main() {
    val (n, m) = readLine()!!.toInt() to readLine()!!.toInt()
    val node = Array(n + 1) { IntArray(n + 1) }
    val bus = Array(m) { IntArray(3) }
    bus.forEachIndexed { index, _ ->
        val (a, b, c) = readLine()!!.split(" ").map { it.toInt() }
        bus[index][0] = a
        bus[index][1] = b
        bus[index][2] = c
    }
    val (start, end) = readLine()!!.split(" ").map { it.toInt() }
    val dist = IntArray(n + 1)

    for (i in 1..n) {
        dist[i] = 1000000001
        for (j in 1..n)
            node[i][j] = 1000000001
    }

    for (i in 0 until m) {
        val x = bus[i][0]
        val y = bus[i][1]
        val value = bus[i][2]
        if (node[x][y] > value) node[x][y] = value
    }

    fun dijkstra() {
        val q = PriorityQueue<Int>()
        q.offer(start)
        dist[start] = 0
        while (!q.isEmpty()) {
            val current = q.poll()
            for (i in 1..n) {
                if (i != current && dist[i] > dist[current] + node[current][i]) {
                    dist[i] = dist[current] + node[current][i]
                    q.offer(i)
                }
            }
        }
    }

    dijkstra()
    println(dist[end])
}

/*
fun main(args: Array<String>) {
  val n = readLine()!!.toInt()
  val m = readLine()!!.toInt()
  val gph = Array<IntArray>(n) { IntArray(n) { 1000000000 } }
  repeat(m) {
    val (u, v, c) = readLine()!!.split(" ").map{ it.toInt() - 1 }
    gph[u][v] = Math.min(gph[u][v], c + 1)
  }
  val (s, t) = readLine()!!.split(" ").map{ it.toInt() - 1 }

  val tb = LongArray(n){ if(it == s) 0 else 2050000000 }
  val chk = BooleanArray(n)
  repeat(n) {
    val d = tb.filterIndexed{ i, _ -> !chk[i] }.min() ?: return
    val u = (0 until n).filter{ !chk[it] && tb[it] == d }.min() ?: return
    if(u == t) {
      println(d)
      return
    }
    chk[u] = true
    for(v in (0 until n).filter{ !chk[it] }) {
      if(d + gph[u][v] < tb[v]) {
        tb[v] = d + gph[u][v]
      }
    }
  }
}
*/