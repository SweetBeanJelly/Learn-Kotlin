package BOJ01

import java.lang.Exception
import java.lang.StringBuilder
import java.util.*

/*
 균형잡힌 세상
 (문자열에 포함되는 괄호 "()" , "[]" 와 문자열이 균형을 이루는 문제)
*/

fun main() {
    while (true) {
        val input = readLine()!!
        if(input == ".") break

        val stack = Stack<Char>()

        try {
            input.forEach { when(it) {
                '(','[' -> stack.push(it)
                ']' -> if(stack.peek() == '[') stack.pop() else throw Exception()
                ')' -> if(stack.peek() == '(') stack.pop() else throw Exception()
            } }
            if(stack.isEmpty()) println("YES")
            else println("NO")
        } catch (e: Exception) {
            println("NO")
        }
    }
}

/*
fun main() {
    val sb = StringBuilder()

    while (true) {
        val input = readLine()!!
        if(input == ".") {
            print(sb)
            return
        }

        val stack = Stack<Char>()
        input.forEach { when(it) {
            '(','[' -> stack.push(it)
            ']' -> if(stack.isEmpty() || stack.peek() != '[') else stack.pop()
            ')' -> if(stack.isEmpty() || stack.peek() != '(') else stack.pop()
        } }

        if(stack.isEmpty()) sb.append("YES\n")
        else sb.append("NO\n")
    }
}
*/