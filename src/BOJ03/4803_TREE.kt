package BOJ03

import java.lang.StringBuilder
import java.util.*

fun main() {
    val sb = StringBuilder()
    var check = 1

    while(true){
        var count = 0
        val (n, m) = readLine()!!.split(" ").map { it.toInt() }
        if(n ==0 && m == 0) break

        val tree = Array(n + 1) { ArrayList<Int>() }
        val visitMap = BooleanArray(tree.size)

        repeat(m){
            val (from,to) = readLine()!!.split(" ").map{it.toInt()}
            tree[from].add(to)
            tree[to].add(from)
        }

        fun dfs(tree: Array<ArrayList<Int>>, start: Int, before: Int, visitMap: BooleanArray): Boolean {
            visitMap[start] = true

            for(i in 0 until tree[start].size){
                if(tree[start][i] == before) continue
                if(visitMap[tree[start][i]]) return false
                if(!dfs(tree,tree[start][i],start,visitMap)) return false
            }
            return true
        }

        for(i in 1 until tree.size){
            if(!visitMap[i])
                if(dfs(tree,start = i,before = 0,visitMap)) count += 1
        }

        when(count){
            0-> sb.append("Case $check: No trees.\n")
            1-> sb.append("Case $check: There is one tree.\n")
            else -> sb.append("Case $check: A forest of $count trees.\n")
        }
        check++
    }
    print(sb)
}


/*
fun main() {
    class Area {
        var isPath = false
        var isWent = false
        fun initVars() {
            isPath = false
            isWent = false
        }
    }

    val visited = BooleanArray(501)
    val graph = Array(501) { arrayOfNulls<Area>(501) }

    var nodes = 0
    var edges = 0

    val sc = Scanner(System.`in`)
    val result = StringBuilder()

    var n = sc.nextInt()
    var m = sc.nextInt()

    for (i in 1..500) {
        for (j in 1..500) graph[i][j] = Area()
        visited[i] = false
    }

    var count = 0
    var caseCount = 1

    fun resetGlobalVars() {
        for (i in 1..n) {
            for (j in 1..n) graph[i][j]!!.initVars()
            visited[i] = false
        }
    }

    fun searchTree(node: Int) {
        if (!visited[node]) {
            visited[node] = true
            nodes++
        }
        for (i in 1..n) {
            if (graph[node][i]!!.isPath && !graph[node][i]!!.isWent) {
                edges++
                graph[node][i]!!.isWent = true
                graph[i][node]!!.isWent = true
                searchTree(i)
            }
        }
    }

    while (n != 0 || m != 0) {
        for (i in 0 until m) {
            val parentNode: Int = sc.nextInt()
            val childNode: Int = sc.nextInt()
            graph[parentNode][childNode]!!.isPath = true
            graph[childNode][parentNode]!!.isPath = true
        }
        for (i in 1..n) {
            nodes = 0
            edges = 0
            if (!visited.get(i)) {
                searchTree(i)
                if (nodes == edges + 1) count++ // 트리의 조건을 이용해 트리여부 판단
            }
        }
        result.append("Case $caseCount: ")
        when (count) {
            0 -> result.append("No trees.\n")
            1 -> result.append("There is one tree.\n")
            else -> result.append(
                "A forest of $count trees.\n"
            )
        }
        resetGlobalVars()
        count = 0
        caseCount++
        n = sc.nextInt()
        m = sc.nextInt()
    }

    print(result.toString())
}
*/

/*
fun main() {
    val graph = ArrayList<ArrayList<Int>>()
    val sb = StringBuilder()

    while (true) {
        val (n, m) = readLine()!!.split(" ").map { it.toInt() }
        if (n == 0 && m == 0) break

        for (i in 0..n)
            graph.add(ArrayList())

        for (i in 0 until m) {
            val (a, b) = readLine()!!.split(" ").map { it.toInt() }
            graph[a].add(b)
            graph[b].add(a)
        }

        var count = 0
        val visited = BooleanArray(n + 1)

        fun checkTree(start: Int): Int {
            val q: Queue<Int> = LinkedList()
            q.offer(start)
            var node = 0
            var edge = 0
            while (!q.isEmpty()) {
                val cur = q.poll()
                node += 1
                visited[cur] = true
                for (next in graph[cur]) {
                    edge += 1
                    if (!visited[next])
                        q.offer(next)
                }
            }
            return if (edge / 2 + 1 == node) 1 else 0
        }

        for (i in 1..n)
            if (!visited[i])
                count += checkTree(i)

        when (count) {
            0 -> {
                sb.append("Case 3: No trees.\n")
            }
            1 -> {
                sb.append("Case 2: There is one tree.\n")
            }
            else -> {
                sb.append("Case 1: A forest of $count trees.\n")
            }
        }
    }

    print(sb.toString())
}
*/