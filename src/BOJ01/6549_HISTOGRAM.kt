package BOJ01

import java.util.*

/*
 히스토그램에서 가장 넓이가 큰 직사각형 구하기
*/

fun main() {
    while (true) {
        val str = StringTokenizer(readLine()!!)
        val n = str.nextToken().toInt()
        if (n == 0) break
        
        val array = IntArray(n)
        val stack = Stack<Int>()
        var result: Long = 0
        for (i in 0 until n) array[i] = str.nextToken().toInt()
        for (i in 0 until n) {
            while (stack.isNotEmpty() && array[stack.peek()] > array[i]) {
                val index = stack.pop()
                val temp = if (stack.isEmpty()) i else i - stack.peek() - 1
                result = result.coerceAtLeast(temp.toLong() * array[index])
            }
            stack.push(i)
        }
        
        while (stack.isNotEmpty()) {
            val index = stack.pop()
            val temp = if (stack.isEmpty()) n else n - stack.peek() - 1
            result = result.coerceAtLeast(temp.toLong() * array[index])
        }
        println(result)
    }
}
