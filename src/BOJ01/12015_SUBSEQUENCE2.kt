package BOJ01

import java.util.*
import kotlin.math.abs

/*
 수열 A.
 가장 길게 증가하는 부분 수열 구하기
*/

fun main() {
    val N = readLine()!!.toInt()
    val array = IntArray(N)
    val list = IntArray(N)

    val str = StringTokenizer(readLine())
    for (i in 0 until N) array[i] = str.nextToken().toInt()
    var result = 0

    for (i in 0 until N) {
        var temp = Arrays.binarySearch(list, 0, result, array[i])
        if(temp < 0) temp = abs(temp) - 1
        list[temp] = array[i]
        if(temp == result) ++result
    }
    print(result)
}