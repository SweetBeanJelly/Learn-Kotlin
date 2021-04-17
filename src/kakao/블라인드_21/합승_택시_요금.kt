import java.util.Arrays

fun main() {
    fun solution(n: Int, s: Int, a: Int, b: Int, fares: Array<IntArray>): Int {
        val map = Array(n + 1) { IntArray(n + 1) }
        for (i in 0..n) {
            Arrays.fill(map[i], 100000000)
            map[i][i] = 0
        }
        for (fare in fares) map[fare[0]][fare[1]] = fare[2].also {
            map[fare[1]][fare[0]] = it
        }

        for (k in 1..n)
            for (i in 1..n)
                for (j in 1..n)
                    if(map[i][j] > map[i][k] + map[k][j]) map[i][j] = map[i][k] + map[k][j]

        var answer = map[s][a] + map[s][b]

        for (i in 1..n) answer = answer.coerceAtMost(map[s][i] + map[i][a] + map[i][b])

        return answer
    }
}

/*
fun solution(n: Int, s: Int, a: Int, b: Int, fares: Array<IntArray>): Int {
        // n: 지점 갯수, s: 출발지, a: A의 집, b: B의 집, fares: [지점1, 지점2, 요금]
        var answer = Int.MAX_VALUE

        val dist = Array(n + 1) { IntArray(n + 1) { 20000001 } }
        for (i in 1..n) dist[i][i] = 0
        for (fare in fares) {
            dist[fare[0]][fare[1]] = fare[2]
            dist[fare[1]][fare[0]] = fare[2]
        }
        for (k in 1..n) {
            for (i in 1..n) {
                for (j in 1..n) {
                    dist[i][j] = kotlin.math.min(dist[i][j], dist[i][k] + dist[k][j])
                }
            }
        }
        for (i in 1..n) {
            answer = kotlin.math.min(answer, dist[s][i] + dist[i][a] + dist[i][b])
        }
        return answer
    }
*/