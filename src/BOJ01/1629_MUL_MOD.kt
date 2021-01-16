package BOJ01

import java.util.*

/*
 A를 B번 곱한 수를 C로 나눈 나머지를 출력
*/

fun main() {
    val input = StringTokenizer(readLine()!!, " ")

    val a = input.nextToken().toLong()
    val b = input.nextToken().toLong()
    var mod = input.nextToken().toLong()

    //val r = (a.toDouble().pow(b)) % mod
    print(func(a,b,mod))
}

fun func(A: Long, B: Long, C: Long): Long {
    return if (B == 0L) {
        1
    } else {
        var value = func(A, B / 2, C)
        value = value * value % C
        if (B % 2 == 0L) {
            value
        } else {
            value * A % C
        }
    }
}