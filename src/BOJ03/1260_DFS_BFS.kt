package BOJ03

import java.util.*

fun main() {
    val list = readLine()!!.split(" ").map { it.toInt() }
    val array = Array(list[0]) { IntArray(list[0]) }
    val flag = BooleanArray(list[0])

    fun dfs(number: Int) {
        flag[number] = true
        print("${number + 1} ")
        for(i in 0 until list[0])
            if(array[number][i] == 1 && !flag[i]) dfs(i)
    }

    fun bfs(number: Int) {
        val n = LinkedList<Int>()
        n.add(number)
        flag[number] = true
        print("${number + 1} ")
        while(n.isNotEmpty()) {
            val p = n.poll()
            for(i in 0 until list[0])
                if(array[p][i] == 1 && !flag[i]) {
                    n.add(i)
                    flag[i] = true
                    print("${i + 1} ")
                }
        }
    }

    repeat(list[1]) {
        val n = readLine()!!.split(" ").map { it.toInt() }
        array[n[0] - 1][n[1] - 1] = 1
        array[n[1] - 1][n[0] - 1] = 1
    }

    flag.fill(false)
    dfs(list[2] - 1)
    println()
    flag.fill(false)
    bfs(list[2] - 1)
}

/*
fun dfs(n: Int, A: Array<BooleanArray>, vis: BooleanArray, u: Int) {
  vis[u] = true
  print("${u} ")
  for(v in 1..n) if(A[u][v] && !vis[v]) {
    dfs(n, A, vis, v)
  }
}

fun bfs(n: Int, A: Array<BooleanArray>, vis: BooleanArray, st: Int) {
  val queue: Queue<Int> = ArrayDeque<Int>()
  queue.add(st)
  vis[st] = true
  while(!queue.isEmpty()) {
    val u = queue.poll()
    print("${u} ")
    for(v in 1..n) if(A[u][v] && !vis[v]) {
      vis[v] = true
      queue.add(v)
    }
  }
}

fun main(args: Array<String>) {
  val (N, M, V) = readLine() ?. split(" ") ?. map { it.toInt() } ?: return
  val A = Array< BooleanArray > (N + 1) { BooleanArray(N + 1) }
  repeat(M) {
    val (u, v) = readLine() ?. split(" ") ?. map { it.toInt() } ?: return
    A[u][v] = true
    A[v][u] = true
  }

  val vis1 = BooleanArray(N + 1)
  dfs(N, A, vis1, V)

  println()

  val vis2 = BooleanArray(N + 1)
  bfs(N, A, vis2, V)
}
*/