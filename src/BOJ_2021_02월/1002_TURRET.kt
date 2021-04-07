package BOJ_2021_02월

import kotlin.math.abs
import kotlin.math.pow
import kotlin.math.sqrt

fun main() {
    for(i in 0 until readLine()!!.toInt()) {
        val array = readLine()!!.split(" ").map { it.toInt() }
        val temp = sqrt((array[3] - array[0]).toDouble().pow(2.0) + (array[4] - array[1]).toDouble().pow(2.0))
        when {
            array[0] == array[3] && array[1] == array[4] && array[2] == array[5] -> { println(-1); continue }
            temp > array[2] + array[5] || temp < abs(array[2] - array[5]) -> { println(0); continue }
            temp == (array[2] + array[5]).toDouble() || temp == (abs(array[2] - array[5])).toDouble() -> { println(1); continue }
        }
        println(2)
    }
}

/*
fun main()=repeat(readLine()!!.toInt()) {
    readLine()!!.split(' ').map { it.toFloat() }.let { n ->
        val l = (n[0]-n[3]).pow(2) + (n[1]-n[4]).pow(2)
        val r1 = (n[2]+n[5]).pow(2)
        val r2 = (n[2]-n[5]).pow(2)
        println(when {
            l == 0f && r2 == 0f -> -1
            r2 < l && l < r1    -> 2
            r1 == l || r2 == l  -> 1
            else                -> 0
        }) } }
*/