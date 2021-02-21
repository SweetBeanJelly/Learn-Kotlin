package BOJ02

import kotlin.math.sqrt

/*
 M이상 N이하의 소수를 모두 출력
*/

fun main() {
    val (N, M) = readLine()!!.split(" ").map { it.toInt() }
    for(i in N until M + 1) if(prime(i)) println(i)
}

fun prime(number: Int): Boolean {
    if(number <= 1) return false
    for(i in 2 until sqrt(number.toDouble()).toInt() + 1)
        if(number % i == 0) return false
    return true
}