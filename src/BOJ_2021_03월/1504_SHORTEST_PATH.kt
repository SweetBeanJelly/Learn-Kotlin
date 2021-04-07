package BOJ_2021_03월

/*
 규칙을 만족하는 최단 거리 구하기
*/

import java.util.*

data class edge(val index: Int, val distance: Int): Comparable<edge> {
    override fun compareTo(other: edge): Int {
        return this.distance - other.distance
    }
}

fun main() {

    val (vertex: Int, edge: Int) = readLine()!!.split(" ").map { it.toInt() }
    val adjList = Array(vertex) { PriorityQueue<edge>() }
    val route = Array(vertex) { IntArray(vertex) { Int.MAX_VALUE } }

    for (i in 0 until edge) {
        val (a, b, c) = readLine()!!.split(" ").map { it.toInt() }

        if (adjList[a - 1].any { it.index == b - 1 }) {
            val oldRoad = adjList[a - 1].find { it.index == b - 1 }
            if (oldRoad!!.distance < c) continue
        }
        adjList[a - 1].add(edge(b - 1, c))
        adjList[b - 1].add(edge(a - 1, c))
    }

    val (via1: Int, via2: Int) = readLine()!!.split(" ").map { it.toInt() - 1 }

    fun search(stop1: Int, stop2: Int, stop3: Int): Int {
        if (route[0][stop1] == Int.MAX_VALUE) return -1
        if (route[stop1][stop2] == Int.MAX_VALUE) return -1
        if (route[stop2][stop3] == Int.MAX_VALUE) return -1
        return route[0][stop1] + route[stop1][stop2] + route[stop2][stop3]
    }

    fun dijkstra(routeInfo: IntArray, vertex: Int) {

        for (i in routeInfo.indices) {

            val queue: PriorityQueue<edge> = PriorityQueue()
            queue.add(edge(routeInfo[i], 0))

            val check = BooleanArray(vertex) { false }

            route[routeInfo[i]][routeInfo[i]] = 0

            while (queue.isNotEmpty()) {

                val now: Int = queue.poll().index

                if (check[now]) continue
                check[now] = true

                for (next in adjList[now]) {
                    if (route[routeInfo[i]][next.index] > route[routeInfo[i]][now] + next.distance) {
                        route[routeInfo[i]][next.index] = route[routeInfo[i]][now] + next.distance
                        queue.add(edge(next.index, route[routeInfo[i]][next.index]))
                    }
                }
            }
        }
    }

    dijkstra(intArrayOf(0, via1, via2, vertex - 1), vertex)

    val way1 = search(via1, via2, vertex - 1)
    val way2 = search(via2, via1, vertex - 1)

    if (way1 == -1 && way2 == -1)
        println(-1)
    else if (way1 == -1 || way2 == -1)
        println(way1.coerceAtLeast(way2))
    else
        println(way1.coerceAtMost(way2))
}

/*
import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.min

const val INFF = 100000000
fun main(args: Array<String>) {
    val br=BufferedReader(InputStreamReader(System.`in`))
    val (N,E)=br.readLine()!!.split(" ").map { it.toInt() }
    val d=Array(N+1){IntArray(N+1){INFF}}
    repeat(E){
        val (s,e,v)=br.readLine()!!.split(" ").map { it.toInt() }
        d[s][e]=v
        d[e][s]=v
    }
    val (fir,sec)=br.readLine()!!.split(" ").map { it.toInt() }
    for(k in 1..N){
        for(i in 1..N){
            for(j in 1..N){
                    if (d[i][j] > d[i][k] + d[k][j]) d[i][j] = d[i][k] + d[k][j]
            }
        }
    }
    d[fir][fir]=0
    d[sec][sec]=0
    val res=min(d[1][fir]+d[fir][sec]+d[sec][N],d[1][sec]+d[sec][fir]+d[fir][N])
    println(if(res<INFF) res else -1)
}
*/


