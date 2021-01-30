package BOJ01

import java.lang.StringBuilder
import java.util.*
import kotlin.math.abs

/*
 절댓값 힙
 배열에 정수 x를 넣는다 -> 가장 작은 값 출력, 그 값을 제거. 가장 작은 값 여러개일 경우 가장 작은 수 출력, 그 값을 제거한다.
*/

fun main() {
    val input = readLine()!!.toInt()
    val queue = PriorityQueue { a: Int, b: Int -> if (abs(a) == abs(b)) (a).compareTo(b) else abs(a).compareTo(abs(b)) }

    val sb = StringBuilder()
    for(i in 0 until input) {
        val number = readLine()!!.toInt()
        if(number == 0) sb.append("${if(queue.size == 0) 0 else queue.poll()}\n")
        else queue.add(number)
    }
    print(sb.toString())
}