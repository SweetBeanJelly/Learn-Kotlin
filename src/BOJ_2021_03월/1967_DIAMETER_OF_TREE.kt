package BOJ_2021_03월

import java.util.LinkedList
import java.util.StringTokenizer

/*
 가중치가 있는 트리의 지름을 구하는 문제
*/

fun main() {
    class Edge(var number: Int, var weight: Int)

    var max = 0
    var index = 0
    var stz: StringTokenizer

    val n = readLine()!!.toInt()
    val tree = arrayOfNulls<LinkedList<Edge>>(10001)
    var distance = IntArray(10001)

    var visit = BooleanArray(10001)
    for (i in 1..10000) tree[i] = LinkedList<Edge>()
    for (i in 0 until n - 1) {
        stz = StringTokenizer(readLine()!!)
        val p = stz.nextToken().toInt()
        val c = stz.nextToken().toInt()
        val w = stz.nextToken().toInt()
        tree[p]?.add(Edge(c, w))
        tree[c]?.add(Edge(p, w))
    }

    fun dfs(node: Int, weight: Int) {
        distance[node] = weight
        visit[node] = true
        if (weight > max) {
            max = weight
            index = node
        }
        for (next in tree[node]!!) {
            if (!visit[next.number]) dfs(next.number, weight + next.weight)
        }
    }

    if (n > 1) {
        dfs(1, 0)
        visit = BooleanArray(10001)
        distance = IntArray(10001)
        dfs(index, 0)
        println(max)
    } else println(0)
}

/*
fun main(args: Array<String>) {
  val N = readLine()!!.toInt()
  val gph = List(N+1) { mutableListOf<Pair<Int,Int>>() }
  repeat(N-1) {
    val (a,b,c) = readLine()!!.split(" ").map{ it.toInt() }
    gph[a].add(Pair(b, c))
    gph[b].add(Pair(a, c))
  }

  fun go(u: Int, p: Int, d: IntArray) {
    for((v, c) in gph[u]) if(v != p) {
      d[v] = d[u] + c
      go(v, u, d)
    }
  }

  val d1 = IntArray(N+1)
  go(1, -1, d1)
  val f = d1.indexOf(d1.max()!!)

  val d2 = IntArray(N+1)
  go(f, -1, d2)

  println(d2.max()!!)
}
*/
/*
fun main() {
    val N = readLine()!!.toInt()
    val tree = List(N+1) { ArrayList<Pair<Int,Int>>() }
    repeat(N - 1) {
        val (a,b,c) = readLine()!!.split(" ").map{ it.toInt() }
        tree[a].add(Pair(b, c))
        tree[b].add(Pair(a, c))
    }
    var start = -1
    var ret = 0
    val visited = BooleanArray(N + 1)
    fun dfs(cur : Int, dist : Int) {
        visited[cur] = true
        if(dist >= ret) {
            ret = dist
            start = cur
        }
        for((to, d) in tree[cur])
            if(!visited[to])
                dfs(to, dist + d)
    }
    dfs(1, 0)
    visited.fill(false)
    dfs(start, 0)
    println(ret)
}
*/

// 메모리 초과
/*
fun main() {
    val n = readLine()!!.toInt()
    val node = Array(n+1){ ArrayList<Pair<Int, Int>>(n + 1) }

    for (i in 1 until n) {
        val (a, b, c) = readLine()!!.split(" ").map { it.toInt() }
        node[a].add(Pair(b, c))
        node[b].add(Pair(a, c))
    }

    var (ans, x) = 0 to 0

    fun dfs(w: Int, cur: Int, prev: Int = -1) {
        if(ans < w) {
            ans = w
            x = cur
        }
        for(i in 0 until node[cur].size) {
            val next = node[cur][i].first
            val d = node[cur][i].second
            if(next == prev) continue
            dfs(w + d, next, cur)
        }
    }

    dfs(0, 1)
    ans = 0
    dfs(0, x)

    val s = StringBuilder()
    s.append(ans)
    print(s)
}
*/

/*
    val n = readLine()!!.toInt()
    val arrList = Array(n+1){ ArrayList<Point>(n+1) }
    var visit = BooleanArray(n + 1)

    for (i in 1 until n) {
        val (a, b, c) = readLine()!!.split(" ").map { it.toInt() }
        arrList[a].add(Point(b, c))
        arrList[b].add(Point(a, c))
    }

    var max = 0
    var maxP: Point? = null

    fun dfs(p: Point, c: Int): Point? {
        visit[p.x] = true
        for (tmp in arrList[p.x]) if (!visit[tmp.x]) dfs(tmp, c + tmp.y)
        if (max < c) {
            max = c
            maxP = p
        }
        return maxP
    }
    val tmp = dfs(arrList[1][0], 0)
    max = 0
    maxP = null
    visit = BooleanArray(n + 1)
    if (tmp != null) dfs(tmp, 0)
    println(max)
*/


