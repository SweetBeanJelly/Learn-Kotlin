package BOJ01

/*
 오큰수 구하기
*/

import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder
import java.util.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val input = readLine().toInt()

    var array = IntArray(input)
    var result = IntArray(input)

    var str = readLine().split(" ")

    for(i in 0 until input) array[i] = str[i].toInt()

    var stack = Stack<Int>()
    stack.push(0)

    for(j in 0 until input) {
        if(stack.isEmpty()) stack.push(j)
        while(stack.isNotEmpty() && array[stack.peek()] < array[j]) {
            result[stack.pop()] = array[j]
        }

        stack.push(j)
    }

    while (stack.isNotEmpty()) {
        result[stack.pop()] = -1
    }

    var sb = StringBuilder()
    for(k in 0 until input) sb.append("${result[k]} ")
    println(sb)
}