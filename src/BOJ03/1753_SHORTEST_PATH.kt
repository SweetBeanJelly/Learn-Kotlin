package BOJ03

import java.util.PriorityQueue
import java.util.ArrayList
import java.util.Arrays


/*
 방향그래프가 주어지면 주어진 시작점에서 다른 모든 정점으로의 최단 경로를 구하는 프로그램을 작성
*/

class Node(var index: Int, var distance: Int) : Comparable<edge> {
    override fun compareTo(other: edge): Int {
        return this.distance - other.distance
    }
}

fun main() {
    val (v, e) = readLine()!!.split(" ").map { it.toInt() }
    val start = readLine()!!.toInt()
    val list: ArrayList<PriorityQueue<edge>> = ArrayList( v + 1 )

    for ( i in 0 until v+1 ) list.add(PriorityQueue<edge>())

    for ( i in 0 until e ) {
        val (a, b, c) = readLine()!!.split(" ").map { it.toInt() }
        list[a].add(edge(b,c))
    }


    val distance = IntArray( v + 1 )
    val check = BooleanArray( v + 1 )
    val pq = PriorityQueue<edge>()

    Arrays.fill(distance, Int.MAX_VALUE)

    distance[start] = 0
    pq.add(edge(start, 0))

    while ( !pq.isEmpty() ) {
        val now: Int = pq.poll().index

        if (check[now]) continue
        check[now] = true

        for ( node in list[now] ) {
            if ( distance[node.index] > distance[now] + node.distance ) {
                distance[node.index] = distance[now] + node.distance
                pq.add(edge(node.index, distance[node.index]))
            }
        }
    }

    for ( i in 1 until v+1 )
        if (distance[i] == Int.MAX_VALUE)
            println("INF")
        else
            println("${distance[i]}")
}

/*
import java.util.*

typealias Edge = Pair<Int,Int>

internal data class Move(val distance : Int, val vertex : Int) : Comparable<Move> {
	override fun compareTo(other: Move) = when {
		distance < other.distance -> -1
		distance > other.distance -> 1
		else -> 0
	}
}

fun main(args: Array<String>) = with(Scanner(System.`in`)) {
	val V = nextInt()
	val E = nextInt()

	val S = nextInt()

	var G = Array(V+1) { ArrayList<Edge>() }
	var D = Array(V+1) { 1_000_000_007 }

	var Q = PriorityQueue<Move>()

	for (i in 1..E) {
		val u = nextInt()
		val v = nextInt()
		val w = nextInt()
		G[u].add(Edge(v, w))
	}

	D[S] = 0
	Q.offer(Move(0, S))
	while(Q.any()) {
		val (distance, u) = Q.poll()

		if(D[u] < distance)
			continue

		for (uv in G[u]) {
			val (v, w) = uv
			if (D[v] > distance + w) {
				D[v] = distance + w
				Q.offer(Move(distance + w, v))
			}
		}
	}

	for (i in 1..V) {
		if (D[i] == 1_000_000_007)
			println("INF")
		else
			println(D[i])
	}
}
*/

/* 시간초과
internal class Edge(var end: Int, var value: Int)

fun main() {
    val (V, E) = readLine()!!.split(" ").map { it.toInt() }
    val K = readLine()!!.toInt()

    val distance = IntArray(V + 1)
    Arrays.fill(distance, Int.MAX_VALUE)
    val visited = BooleanArray(V + 1)
    val list = arrayOfNulls<ArrayList<Edge>>(V + 1)
    for (i in 0..V) list[i] = ArrayList()
    for (i in 0 until E) {
        val (start, end, value) = readLine()!!.split(" ").map { it.toInt() }
        list[start]!!.add(Edge(end, value))
    }
    val q = PriorityQueue<Int>()
    q.add(K)
    distance[K] = 0
    while (!q.isEmpty()) {
        val current = q.poll()
        visited[current] = true
        for (i in list[current]!!.indices) {
            val next = list[current]!![i].end
            val value = list[current]!![i].value
            if (distance[next] > distance[current] + value) {
                distance[next] = value + distance[current]
                q.add(next)
            }
        }
    }
    for (i in 1..V)
        if (visited[i]) println(distance[i]) else println("INF")
}
*/