package BOJ_2021_01월

import java.util.*


/*
 정수 배열 연산을 하기 위해 만든 새로운 언어.
 R : 뒤집기 (배열에 있는 숫자의 순서 뒤집기)
 D : 버리기 (첫 번째 숫자 버리기, 배열이 비어있을 때 사용한 경우 에러 발생)
*/

fun main() {
    val input = readLine()!!.toInt()
    repeat(input) {
        val operation = readLine()!!
        readLine()!!
        val array = readLine()!!
        val deque = LinkedList<Int>()

        for(i in array.substring(1, array.length -1).split(","))
            if(i != "") deque.add(i.toInt())
        println(ac(deque, operation))
    }
}

fun ac(deque: Deque<Int>, operation: String): String {
    var reverse = false
    for (i in operation.toCharArray()) {
        if (i == 'R') reverse = !reverse else {
            if (deque.size == 0) return "error"
            if (reverse) deque.removeLast() else deque.removeFirst()
        }
    }
    val sb = StringBuilder("[")
    while (!deque.isEmpty()) {
        sb.append(if (reverse) deque.removeLast() else deque.removeFirst())
        if (deque.size != 0) sb.append(',')
    }
    sb.append("]")
    return sb.toString()
}