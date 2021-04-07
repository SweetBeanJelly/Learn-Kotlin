package BOJ_2021_01월

import java.util.*

/*
 C개의 공유기를 N개의 집에 설치. 가장 인접한 두 공유기 사이의 거리를 가능한 크게 하여 설치.
*/

fun main() {
    val input = StringTokenizer(readLine()!!)
    val N = input.nextToken().toInt()
    val C = input.nextToken().toInt()

    val location = IntArray(N)
    for (i in 0 until N) location[i] = readLine()!!.toInt()
    Arrays.sort(location)

    var start = 1
    var end = location[N - 1] - location[0]
    var result = 0

    while (start <= end) {
        var cnt = 1
        val mid = (start + end) / 2
        var value = location[0]
        for (i in 0 until N) {
            if(location[i] - value >= mid) {
                cnt++
                value = location[i]
            }
        }
        if (cnt < C) end = mid - 1
        else if (cnt >= C) {
            result = mid
            start = mid + 1
        }
    }
    println(result)
}