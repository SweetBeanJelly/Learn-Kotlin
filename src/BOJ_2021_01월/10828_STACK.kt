package BOJ_2021_01월

/*
 스택
*/

import java.util.*

fun main(){
    val stack = Stack<Int>()

    var sb = StringBuilder()

    repeat(readLine()!!.toInt()) {
        val input = readLine()!!.split(" ")

        when(input[0]) {
            "push" -> stack.push(input[1].toInt())
            "pop" -> sb.append("${if (stack.empty()) -1 else stack.pop()}\n")
            "size" -> sb.append("${stack.size}\n")
            "empty" -> sb.append("${if (stack.empty()) 1 else 0}\n")
            "top" -> sb.append("${if (stack.empty()) -1 else stack.peek()}\n")
        }
    }
    print(sb)
}