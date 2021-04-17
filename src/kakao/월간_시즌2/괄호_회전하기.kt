package kakao.월간_시즌2

import java.util.*

fun main() {
    fun check(s: String): Boolean {
        val stack = Stack<Char>()
        for(i in s.indices) {
            when {
                s[i] == '(' || s[i] == '{' || s[i] == '[' -> stack.push(s[i])
                stack.isEmpty() -> return false
                else -> stack.pop()
            }
        }
        return stack.isEmpty()
    }
    fun solution(s: String): Int {
        var count = 0
        var temp = s
        for(i in s.indices) {
            if(check(temp)) count++
            temp = temp.substring(1, s.length) + temp[0]
        }
        return count
    }
    print(solution("}]()[{"))
}