package BOJ_2021_04월

import java.util.PriorityQueue

fun main() {
    class Node(var start: Int, var end: Int, var weight: Int) : Comparable<Node> {
        override operator fun compareTo(n: Node): Int {
            return weight - n.weight
        }
    }

    val pq = PriorityQueue<Node>()
    val (v, e) = readLine()!!.split(" ").map { it.toInt() }
    val parent = IntArray(v + 1)

    for (i in 1..v) parent[i] = i

    fun find(x: Int): Int = if (parent[x] == x) x else find(parent[x]).also { parent[x] = it }
    fun union(a: Int, b: Int) {
        parent[a] = b
    }

    fun solve(): Int {
        var sum = 0
        while (!pq.isEmpty()) {
            val node: Node = pq.poll()
            val parentS = find(node.start)
            val parentE = find(node.end)

            if (parentS != parentE) {
                union(parentS, parentE)
                sum += node.weight
            }
        }
        return sum
    }

    for (i in 0 until e) {
        val (a, b, c) = readLine()!!.split(" ").map { it.toInt() }
        pq.offer(Node(a, b, c))
    }

    println(solve())
}

/*
data class Edge(val x: Int, val y: Int, val z: Int)

fun main() {
    val (m, n) = readLine()!!.split(" ").map { it.toInt() }
    val e = MutableList(n) {
        val (x, y, z) = readLine()!!.split(" ").map { it.toInt() }
        Edge(x-1, y-1, z)
    }.sortedBy { it.z }
    var r = 0
    val g = MutableList(m) { it }
    var f: (Int) -> Int = { throw AssertionError() }
    f = {
        if (g[it] != it) g[it] = f(g[it])
        g[it]
    }
    for (c in e) {
        if (f(c.x) != f(c.y)) {
            r += c.z
            g[f(c.x)] = f(c.y)
        }
    }
    println(r)
}
*/

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