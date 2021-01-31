package BOJ01

import java.lang.StringBuilder
import java.util.*

/*
 여러 정수 중 중간 값. 정수가 짝수개 라면 중간에 있는 두 수중에서 작은 수
*/

fun main() {
    val input = readLine()!!.toInt()
    val min = PriorityQueue { a: Int, b: Int -> a - b }
    val max = PriorityQueue { a: Int, b: Int -> b - a }

    val sb = StringBuilder()
    for(i in 0 until input) {
        val number = readLine()!!.toInt()
        if(min.size == max.size) max.offer(number) else min.offer(number)
        if(min.isNotEmpty() && max.isNotEmpty()) {
            if(min.peek() < max.peek()) {
                val temp = min.poll()
                min.offer(max.poll())
                max.offer(temp)
            }
        }
        sb.append("${max.peek()}\n")
    }
    print(sb)
}