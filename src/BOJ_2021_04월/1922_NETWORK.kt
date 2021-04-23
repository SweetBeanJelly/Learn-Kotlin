package BOJ_2021_04월

import java.util.*

fun main() = with(Scanner(System.`in`)) {

    class Node(var x: Int, var cost: Int) : Comparable<Node?> {
        override operator fun compareTo(other: Node?): Int {
            return cost - other!!.cost
        }
    }

    val (n, m) = nextInt() to nextInt()
    val list = arrayOfNulls<ArrayList<Node>>(n + 1)
    for (i in 1 until n + 1) list[i] = ArrayList()

    for (i in 0 until m) {
        val s = nextInt()
        val e = nextInt()
        val cost = nextInt()
        list[s]!!.add(Node(e, cost))
        list[e]!!.add(Node(s, cost))
    }

    val visited = BooleanArray(n + 1)
    var r = 0

    fun prim() {
        val q = PriorityQueue<Node>()
        q.offer(Node(1, 0))
        while (!q.isEmpty()) {
            val current = q.poll()
            if (!visited[current.x]) visited[current.x] = true else continue
            r += current.cost
            for (i in 0 until list[current.x]!!.size) {
                val next: Node = list[current.x]!![i]
                q.offer(next)
            }
        }
    }

    prim()
    println(r)
}

/*
fun main(args:Array<String>) {
    val sc = java.util.Scanner(System.`in`)
    val n = sc.nextInt()
    val m = sc.nextInt()
    val grp = IntArray(n+1) { it }
    fun go(x: Int): Int {
        if(grp[x] != x) {
            grp[x] = go(grp[x])
        }
        return grp[x]
    }
    data class Edge(val u: Int, val v: Int, val c: Int)
    val gph = Array<Edge>(m) { Edge(sc.nextInt(), sc.nextInt(), sc.nextInt()) }.sortedWith(compareBy({ it.c }))
    var ans = 0L
    for(edge in gph) {
        val a = go(edge.u)
        val b = go(edge.v)
        if(a != b) {
            ans += edge.c
            grp[a] = b
        }
    }
    println(ans)
}

*/