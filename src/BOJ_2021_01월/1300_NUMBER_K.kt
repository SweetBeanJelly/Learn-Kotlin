package BOJ_2021_01월

/*
 크기가 N*N인 배열 A, 이 수를 일차원 배열 B에 넣고 오름차순 정렬
*/

fun main() {
    val N: Long = readLine()!!.toLong()
    val K: Long = readLine()!!.toLong()

    var start: Long = 1
    var end = K
    var result: Long = 0

    while (start <= end) {
        var cnt: Long = 0
        val mid = (start + end) / 2
        for (i in 1..N) cnt += (mid / i).coerceAtMost(N)
        if (cnt < K) start = mid + 1
        else {
            end = mid - 1
            result = mid
        }
    }

    println(result)
}