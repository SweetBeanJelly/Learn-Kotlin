package BOJ_2021_02월

import java.util.*

/*
 맨 위층 부터 아래있는 수 중 하나를 선택하여 선택된 수의 합이 최대가 되는 경로를 구하기
*/

fun main() {
    val N = readLine()!!.toInt()
    val triangle = Array(N + 1) { IntArray(N + 1) }
    var result = 0
    for(i in 1..N) {
        val str = StringTokenizer(readLine()!!, " ")
        for (j in 1..i) {
            triangle[i][j] = str.nextToken().toInt()
            triangle[i][j] = (triangle[i][j] + triangle[i - 1][j]).coerceAtLeast(triangle[i][j] + triangle[i - 1][j - 1])
            result = triangle[i][j].coerceAtLeast(result);
        }
    }
    print(result)
}