package BOJ_2021_01월

import java.util.*

/*
 행렬 곱셈 ( 두 행렬을 곱하기 )
*/

var scanner = Scanner(System.`in`)
lateinit var a: Array<Array<Int>>
lateinit var b: Array<Array<Int>>
lateinit var result: Array<Array<Int>>

fun main() {
    var n = scanner.nextInt(); var m = scanner.nextInt()
    a = Array(n) { Array(m) { 0 } }
    a = getArray(n, m, a)

    m = scanner.nextInt(); var k = scanner.nextInt()
    b = Array(m) { Array(k) { 0 } }
    b = getArray(m, k, b)

    result = Array(n) { Array(k) { 0 } }
    result = getResult(n, k, m)

    for(array in result) {
        for (r in array) {
            print("$r ")
        }
        println()
    }
}

fun getArray(n1: Int, n2: Int, array: Array<Array<Int>>): Array<Array<Int>> {
    for(i in 0 until n1) {
        for(j in 0 until n2)
            array[i][j] = scanner.nextInt()
    }
    return array
}

fun getResult(n: Int, k: Int, m: Int): Array<Array<Int>> {
    for(i in 0 until n)
        for(j in 0 until k)
            for(z in 0 until m)
                result[i][j] += a[i][z] * b[z][j]
    return result
}