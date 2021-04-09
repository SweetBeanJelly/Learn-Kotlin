package kakao.kit

import java.util.*

// https://programmers.co.kr/learn/courses/30/lessons/42627?language=kotlin

fun main() {
    fun solution(jobs: Array<IntArray>): Int {
        var answer = 0
        var time = 0

        val wait = PriorityQueue<IntArray>(compareBy({it[0]}, {it[1]}))
        val work = PriorityQueue<IntArray>(compareBy({it[1]}, {it[0]}))

        jobs.forEach { wait.add(it) }

        while(wait.isNotEmpty() || work.isNotEmpty()) {
            while(wait.isNotEmpty() && wait.peek()[0] <= time) {
                work.add(wait.poll())
            }

            if(work.isNotEmpty()) {
                time += work.peek()[1]
                answer += time - work.peek()[0]
                work.poll()
            } else if(wait.isNotEmpty()) time = wait.peek()[0]
        }

        return answer / jobs.size
    }
    val test = arrayOf(intArrayOf(0,3), intArrayOf(1,9), intArrayOf(2,6))
    print(solution(test))
}