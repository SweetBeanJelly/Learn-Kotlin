package BOJ_2021_01월

import java.util.*

fun main() {
    val number = readLine()!!.toInt()
    var sb = StringBuilder()
    var stack = Stack<Int>()

    var count = 0

    try {
        repeat(number) {
            var input = readLine()!!.toInt()
            while (count < input) {
                count++
                stack.add(count)
                sb.append("+\n")
            }
            if(stack.peek() == input) {
                stack.pop()
                sb.append("-\n")
            } else throw Exception()
        }

        if(stack.isEmpty()) print(sb)
        else println("NO")

    } catch (e: Exception) {
        println("NO")
    }
}