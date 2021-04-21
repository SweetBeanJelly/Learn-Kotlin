package kakao.kit

fun main() {
    fun solution(n: Int, results: Array<IntArray>): Int {
        var answer = 0
        val array = Array(n + 1) { IntArray(n + 1) }

        for(i in results.indices) {
            array[results[i][0]][results[i][1]] = 1
            array[results[i][1]][results[i][0]] = -1
        }

        for(i in 1..n)
            for(j in 1..n)
                for(k in 1..n) {
                    if(j == k || array[j][k] != 0) continue
                    if(array[j][i] == array[i][k]) array[j][k] = array[j][i]
                }

        go@for(i in 1..n) {
            for(j in 1..n) {
                if(i == j) continue
                if(array[i][j] == 0) continue@go
            }
            answer++
        }

        return answer
    }
    print(solution(5, arrayOf(intArrayOf(4,3), intArrayOf(4,2), intArrayOf(3,2), intArrayOf(1,2), intArrayOf(2,5))))
}

/*
        var answer = 0
        val adj = Array(n + 1) { Array(n + 1) { false } }
        for (game in results) adj[game[0]][game[1]] = true
        for (k in 1..n) {
            for (i in 1..n) {
                for (j in 1..n) {
                    if (adj[i][k] && adj[k][j]) adj[i][j] = true
                }
            }
        }

        for (i in 1..n) {
            var count = 0
            for (j in 1..n) {
                if (adj[i][j] || adj[j][i]) count++
            }
            if (count == n - 1) answer++
        }
        return answer
*/
/*
        val graph = Array<IntArray>(n) { IntArray(n) }


        for (i in results.indices) {
            graph[results[i][0]-1][results[i][1]-1] = 1
            graph[results[i][1]-1][results[i][0]-1] = -1
        }

        for (k in 0 until n) { // 들렀다 가는곳
            for (i in 0 until n) { // 시작
                for (j in 0 until n) { // 도착
                    if (i == j || graph[i][j] != 0) continue
                    if (graph[i][k] == graph[k][j]) graph[i][j] = graph[i][k]
                }
            }
        }

        return graph.count { arr -> arr.count { it == 0 } == 1 }
*/