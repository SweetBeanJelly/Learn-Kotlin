package BOJ02

import java.lang.StringBuilder

var dp = Array(21) { Array(21) { IntArray(21) } }

fun main() {
    val sb = StringBuilder()
    var input: String
    while ("-1 -1 -1" != readLine()!!.also { input = it }) {
        val (a, b, c) = input.split(" ").map { it.toInt() }
        sb.append("w($a, $b, $c) = ${w(a, b, c)}\n")
    }
    print(sb)
}

private fun w(a: Int, b: Int, c: Int): Int {
    if (range(a, b, c) && dp[a][b][c] != 0) return dp[a][b][c]
    return if (a <= 0 || b <= 0 || c <= 0) 1
    else if (a > 20 || b > 20 || c > 20) w(20, 20, 20).also { dp[20][20][20] = it }
    else if (b in (a + 1) until c) (w(a, b, c - 1) + w(a, b - 1, c - 1) - w(a, b - 1, c)).also { dp[a][b][c] = it }
    else ((w(a - 1, b, c) + w(a - 1, b - 1, c) + w(a - 1, b, c - 1)) - w(a - 1, b - 1, c - 1)).also { dp[a][b][c]= it }
}

private fun range(a: Int, b: Int, c: Int): Boolean {
    return a in 0..20 && b in 0..20 && c in 0..20
}