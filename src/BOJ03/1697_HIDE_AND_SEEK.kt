package BOJ03

import java.util.*

fun main() {
    val (N, K) = readLine()!!.split(" ").map { it.toInt() }
    val max = N.coerceAtLeast(K)
    val list = IntArray(max + 2) {0}

    fun bfs(n: Int) {
        val q = LinkedList<Int>()
        q.add(n)
        list[n] = 1

        while(q.isNotEmpty()) {
            val now = q.poll()
            if (list[K] != 0) break
            if (now + 1 in 0..max + 1 && list[now + 1] == 0) {
                q.add(now + 1)
                list[now + 1] = list[now] + 1
            }
            if (now - 1 in 0..max + 1 && list[now - 1] == 0) {
                q.add(now - 1)
                list[now - 1] = list[now] + 1
            }
            if (now * 2 in 0..max + 1 && list[now * 2] == 0) {
                q.add(now * 2)
                list[now * 2] = list[now] + 1
            }
        }
        print(list[K] - 1)
    }

    bfs(N)
}

/*
fun main(args: Array<String>) = with(Scanner(System.`in`)) {
    val n = nextInt()
    val k = nextInt()

    val dp = IntArray(100001) { if (it <= n) n - it else 2100000000 }

    for (i in 0..100000) {
        if (i != 0) dp[i] = Math.min(dp[i - 1] + 1, dp[i])
        if (i != 100000) dp[i] = Math.min(dp[i + 1] + 1, dp[i])
        if (2 * i in n + 1..100000) dp[2 * i] = Math.min(dp[i] + 1, dp[2 * i])
    }

    println(dp[k])
}
*/

/*
fun main() {
    val (n, k) = readLine()!!.split(' ').map { it.toInt() }
    val visited = BooleanArray(max(k, n) * 2 + 1) { false }
    val deq = ArrayDeque<Pair<Int, Int>>()
    deq.add(n to 0)
    visited[n] = true
    while (deq.isNotEmpty()) {
        val (pos, level) = deq.removeFirst()
        if (pos == k) {
            println(level)
            return
        }
        for (i in intArrayOf(pos + 1, pos - 1, pos * 2)) {
            if (visited.getOrNull(i) == false) {
                visited[i] = true
                deq.add(i to level + 1)
            }
        }
    }
}
*/