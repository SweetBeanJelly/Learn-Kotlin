package kakao.kit

import java.util.*

// https://programmers.co.kr/learn/courses/30/lessons/42626

fun main() {
    fun solution(scoville: IntArray, K: Int): Int {
        val list = PriorityQueue(scoville.toList())
        var answer = 0

        while(list.count { it > K } != list.size) {
            answer++
            list.add(list.poll() + (list.poll() * 2))
        }

        return answer
    }
    print(solution(intArrayOf(1,2,3,9,10,12), 7))
}