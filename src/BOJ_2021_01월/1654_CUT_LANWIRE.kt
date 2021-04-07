package BOJ_2021_01월

import java.util.*

/*
 N개의 랜선 길이 만큼 K개의 랜선을 자르기, 만들 수 있는 최대 랜선의 길이 구하기
*/

fun main() {
    val input = StringTokenizer(readLine()!!)
    val K = input.nextToken().toInt()
    val N = input.nextToken().toInt()

    val cut = IntArray(K)
    for (i in 0 until K) cut[i] = readLine()!!.toInt()
    Arrays.sort(cut)

    var start: Long = 1
    var end = cut[K - 1].toLong()

    while (start <= end) {
        var cnt: Long = 0
        val mid = (start + end) / 2
        for (i in 0 until K) cnt += cut[i] / mid
        if (cnt < N) end = mid - 1 else if (cnt >= N) start = mid + 1
    }
    print(end)
}