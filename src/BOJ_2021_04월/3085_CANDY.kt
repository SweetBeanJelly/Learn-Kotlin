package BOJ_2021_04월

import java.util.*

fun main() = with(Scanner(System.`in`)) {
    val n = nextInt()
    val c = Array(n) { CharArray(n) }

    for (i in 0 until n)
        c[i] = next().toCharArray()

    var max = 0

    fun arrayCheck() {
        for (k in 0 until n) {
            var cnt = 1
            for (l in 0 until n - 1) {
                if (c[k][l] == c[k][l + 1]) cnt++ else cnt = 1
                if (max < cnt) max = cnt
            }
        }
        for (k in 0 until n) {
            var cnt = 1
            for (l in 0 until n - 1) {
                if (c[l][k] == c[l + 1][k]) cnt++ else cnt = 1
                if (max < cnt) max = cnt
            }
        }
    }

    for (i in 0 until n) {
        for (j in 0 until n - 1) {
            var tmp = c[i][j]
            c[i][j] = c[i][j + 1]
            c[i][j + 1] = tmp
            arrayCheck()
            tmp = c[i][j]
            c[i][j] = c[i][j + 1]
            c[i][j + 1] = tmp
        }
    }

    for (i in 0 until n) {
        for (j in 0 until n - 1) {
            var tmp: Char = c[j][i]
            c[j][i] = c[j + 1][i]
            c[j + 1][i] = tmp
            arrayCheck()
            tmp = c[j][i]
            c[j][i] = c[j + 1][i]
            c[j + 1][i] = tmp
        }
    }

    println(max)
}
