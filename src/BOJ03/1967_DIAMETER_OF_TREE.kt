package BOJ03

import java.lang.StringBuilder
import java.util.ArrayList

/*
 가중치가 있는 트리의 지름을 구하는 문제
*/

// 메모리 초과
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


