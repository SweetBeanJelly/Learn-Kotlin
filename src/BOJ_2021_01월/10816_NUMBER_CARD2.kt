package BOJ_2021_01월

import java.lang.StringBuilder
import java.util.*
import kotlin.collections.HashMap

/*
 정수 하나가 적혀 있는 카드 N이 있다. M개의 정수가 주어졌을 때 N이 적힌 카드가 몇 개 있는지 구하기
*/

fun main() {
    val hashMap = HashMap<Int, Int>()
    val n = readLine()!!.toInt()

    var str = StringTokenizer(readLine())
    for(i in 0 until n) {
        val number = str.nextToken().toInt()
        if(hashMap.containsKey(number)) hashMap.replace(number, hashMap[number]!! + 1)
        else hashMap[number] = 1
    }

    val m = readLine()!!.toInt()

    val sb = StringBuilder()
    str = StringTokenizer(readLine())
    for(i in 0 until m) {
        val number = str.nextToken().toInt()
        if(hashMap.containsKey(number)) sb.append("${hashMap[number]} ") else sb.append("0 ")
    }

    println(sb)
}