package BOJ01

import java.util.*

/*
 제로 (가장 최근에 쓴 수를 지우는 문제)
*/

fun main() {
    val input = readLine()!!.toInt()
    val stack = Stack<Int>()

    repeat(input) {
        val number = readLine()!!.toInt()
        if(stack.isNotEmpty() && number == 0) stack.pop()
        else stack.push(number)
    }

    println(stack.fold(0) {
        sum, next -> sum + next
    })
}