package BOJ_2021_04월

import java.util.*

fun main() = with(Scanner(System.`in`)) {
    val n = nextInt()
    val m = Array(n) { IntArray(n) }
    for(i in 0 until n)
        for(j in 0 until n)
            m[i][j] = nextInt()

    var r = 0

    fun go(a: Int, b: Int, c: Int) {
        if(a == n - 1 && b == n - 1) {
            r++
            return
        }
        if(c == 0 || c == 2)
            if(b + 1 < n && m[a][b + 1] == 0) go(a, b + 1, 0)
        if(c == 1 || c == 2)
            if(a + 1 < n && m[a + 1][b] == 0) go(a + 1, b, 1)
        if(a + 1 < n && b + 1 < n && m[a + 1][b] == 0 && m[a + 1][b + 1] == 0 && m[a][b + 1] == 0)
            go(a + 1, b + 1, 2)
    }

    go(0, 1, 0)
    print(r)
}