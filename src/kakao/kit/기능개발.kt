package kakao.kit

import java.util.*

// https://programmers.co.kr/learn/courses/30/lessons/42586

fun main() {
    fun solution(progresses: IntArray, speeds: IntArray): IntArray {
        val array = LinkedList<Int>()
        val answer = mutableListOf<Int>()

        progresses.forEachIndexed { i, num ->
            if( (100 - num) % speeds[i] == 0 ) array.add( (100 - num) / speeds[i] )
            else array.add( (100 - num) / speeds[i] + 1)
        }

        while(array.isNotEmpty()) {

            if(array.size == 1) {
                answer.add(1)
                break
            }

            var count = 0
            run {
                array.forEach {
                    if(it <= array.peek()) count++
                    else return@run
                }
            }

            answer.add(count)
            while(count-- > 0) array.poll()
        }

        return answer.toIntArray()
    }
    print(solution(intArrayOf(93,30,55), intArrayOf(1,30,5)).toList())
}