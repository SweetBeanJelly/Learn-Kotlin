package BOJ_2021_01월

import java.util.*
import kotlin.properties.Delegates

/*
 행렬 제곱
*/

var n by Delegates.notNull<Int>()

fun main() {
    val str = StringTokenizer(readLine(), " ")
    n = str.nextToken().toInt()
    val b = str.nextToken().toLong()
    var array = Array(n) { Array(n) { 0 } }
    array.forEach {
        var str = StringTokenizer(readLine()!!)
        it.forEachIndexed { index, _ -> it[index] = str.nextToken().toInt() }
    }

    val result = solution(array, b)

    for(i in 0 until n) {
        for (j in 0 until n) {
            print("${result[i][j] % 1000} ")
        }
        println()
    }
}

fun square(a1: Array<Array<Int>>, a2: Array<Array<Int>>): Array<Array<Int>> {
    val temp = Array(n) { Array(n) { 0 } }
    for(i in 0 until n) {
        for(j in 0 until n) {
            var sum = 0
            for(k in 0 until n)
                sum += a1[i][k] * a2[k][j]
            temp[i][j] = sum % 1000
        }
    }
    return temp
}

fun solution(a: Array<Array<Int>>, b: Long): Array<Array<Int>> {
    return when {
        b == 1L -> a
        b % 2 == 0L -> {
            val temp = solution(a, b/2)
            square(temp, temp)
        }
        else -> square(solution(a, b - 1), a)
    }
}