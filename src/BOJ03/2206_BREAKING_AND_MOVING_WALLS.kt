package BOJ03

import java.util.LinkedList

/*
 맵이 주어졌을 때, 최단 경로를 구해 내는 프로그램을 작성
*/

fun main() {
    val (n, m) = readLine()!!.split(" ").map { it.toInt() }
    val arr = Array(n) { readLine()!!.map { x -> x.toInt() - '0'.toInt() }.toIntArray() }
    val queue = LinkedList<Triple<Pair<Int, Int>, Int, Int>>()
    val hashMap = HashMap<Pair<Int, Int>, Int>()
    val dx = intArrayOf(0, 1, 0, -1)
    val dy = intArrayOf(1, 0, -1, 0)
    queue.add(Triple(Pair(0, 0), 1, 0))
    var result = -1
    while (!queue.isEmpty()) {
        val tri = queue.poll()
        if (tri.first.first == n - 1 && tri.first.second == m - 1) { result = tri.second; break }

        for (i in 0..3) {
            val nx = tri.first.first + dx[i]
            val ny = tri.first.second + dy[i]
            if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue
            val nc = tri.third + arr[nx][ny]
            val np = Pair(nx, ny)
            if (nc > 1 || hashMap.getOrDefault(np, 2) <= nc) continue
            hashMap[np] = nc
            queue.add(Triple(np, tri.second + 1, nc))
        }
    }
    println(result)
}

/*
fun main() {
    val (n, m) = readLine()!!.split(" ").map{ it.toInt() }
    val map = Array(n) { IntArray(m) }
    val visit = Array(n) { IntArray(m) }
    val len = Array(n) { IntArray(m) }

    var ans = -1

    val q: Queue<Node> = LinkedList<Node>()

    for (i in 0 until n) {
        val s = readLine()!!
        for (j in 0 until m) {
            map[i][j] = s[j] - '0'
        }
    }

    q.add(Node(0, 0))
    visit[0][0] = 1
    len[0][0] = 1

    while (!q.isEmpty()) {
        val dx = intArrayOf(-1, 0, 1, 0)
        val dy = intArrayOf(0, 1, 0, -1)
        val node: Node = q.poll()

        if (node.x == n - 1 && node.y == m - 1) {
            ans = len[node.x][node.y]
            break
        }
        for (i in 0..3) {
            val nx: Int = node.x + dx[i]
            val ny: Int = node.y + dy[i]
            if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                if (map[nx][ny] == 0 && (visit[nx][ny] == 0 || visit[nx][ny] > visit[node.x][node.y])) {
                    visit[nx][ny] = visit[node.x][node.y]
                    len[nx][ny] = len[node.x][node.y] + 1
                    q.add(Node(nx, ny))
                } else if (map[nx][ny] == 1 && visit[node.x][node.y] <= 1) {
                    visit[nx][ny] = visit[node.x][node.y] + 1
                    len[nx][ny] = len[node.x][node.y] + 1
                    q.add(Node(nx, ny))
                }
            }
        }
    }
    println(ans)
}

class Node internal constructor(var x: Int, var y: Int)
*/