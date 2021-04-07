package BOJ_2021_01월

import java.lang.StringBuilder
import java.util.*

/*
 덱
*/

fun main() {
    var deque = LinkedList<Int>()
    var sb = StringBuilder()

    repeat(readLine()!!.toInt()) {
        val str = readLine()!!.split(" ")
        when(str[0]) {
            "push_front" -> deque.offerFirst(str[1].toInt())
            "push_back" -> deque.offerLast(str[1].toInt())
            "pop_front" -> if(deque.isEmpty()) sb.append("-1\n") else sb.append("${deque.pollFirst()}\n")
            "pop_back" -> if(deque.isEmpty()) sb.append("-1\n") else sb.append("${deque.pollLast()}\n")
            "size" -> sb.append("${deque.size}\n")
            "empty" -> if(deque.isEmpty()) sb.append("1\n") else sb.append("0\n")
            "front" -> if(deque.isEmpty()) sb.append("-1\n") else sb.append("${deque.peekFirst()}\n")
            "back" -> if(deque.isEmpty()) sb.append("-1\n") else sb.append("${deque.peekLast()}\n")
        }
    }

    print(sb)
}