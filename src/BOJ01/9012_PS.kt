package BOJ01

import java.util.*

/*
 괄호 문자열이 올바르면 YES 아니면 NO
*/

fun main() {
    val input = readLine()!!.toInt()

    repeat(input) {
        val stack = Stack<Char>()
        val str = readLine()!!

        var flag = true

        for (i in str.toCharArray()) {
            if(i == '(') stack.push(')')
            else {
                if(stack.isEmpty()) {
                    flag = false
                    break
                }
                stack.pop()
            }
        }

        if(flag && stack.isEmpty()) println("YES")
        else println("NO")
    }

}

