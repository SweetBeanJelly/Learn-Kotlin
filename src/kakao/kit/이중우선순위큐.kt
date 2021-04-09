package kakao.kit

import java.util.*

// https://programmers.co.kr/learn/courses/30/lessons/42628

fun main() {
    fun solution(operations: Array<String>): IntArray {
        val min = PriorityQueue<Int> { a, b -> a - b }
        val max = PriorityQueue<Int> { a, b -> b - a }
        operations.forEach {
            val (check, str) = it.split(" ")
            when(check) {
                "I" -> {
                    min.add(str.toInt())
                    max.add(str.toInt())
                }
                "D" -> {
                    if(str.toInt() == 1) min.remove(max.poll())
                    if(str.toInt() == -1) max.remove(min.poll())
                }
            }
        }

        return if(min.count() == 0) intArrayOf(0, 0)
        else intArrayOf(max.poll(), min.poll())
    }
    print(solution(arrayOf("I 16", "D 1", "I 7", "I 5", "D -1", "I 20")).toList())
}