package kakao.kit

import java.util.LinkedList


fun main() {
    fun solution(n: Int, edge: Array<IntArray>): Int {
        val array = IntArray(n + 1)
        val list = Array(n + 1) { BooleanArray(n + 1) }

        for (i in edge.indices) {
            list[edge[i][1]][edge[i][0]] = true
            list[edge[i][0]][edge[i][1]] = list[edge[i][1]][edge[i][0]]
        }

        val q = LinkedList<Int>()
        q.add(1)

        var maxDist = 0
        while (!q.isEmpty()) {
            val i = q.poll()
            for (j in 2..n) {
                if (array[j] == 0 && list[i][j]) {
                    array[j] = array[i] + 1
                    q.add(j)
                    maxDist = maxDist.coerceAtLeast(array[j])
                }
            }
        }

        var answer = 0
        for (d in array) if (maxDist == d) answer++

        return answer
    }
    print(solution(6, arrayOf(intArrayOf(3,6), intArrayOf(4,3), intArrayOf(3, 2), intArrayOf(1,3), intArrayOf(1,2), intArrayOf(2,4), intArrayOf(5,2))))
}