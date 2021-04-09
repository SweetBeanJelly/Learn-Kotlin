package kakao.kit

import java.util.*

// https://programmers.co.kr/learn/courses/30/lessons/42583

fun main() {
    data class truck(val weight: Int, var couont: Int)
    fun solution(bridge_length: Int, weight: Int, truck_weights: IntArray): Int {
        val q1 = LinkedList<truck>()
        val q2 = LinkedList<truck>()

        for(i in truck_weights) q2.add(truck(i, bridge_length))

        var answer = 0
        while(q1.isNotEmpty() || q2.isNotEmpty()) {
            answer++
            if(q1.isNotEmpty() && q1.peekFirst().couont < 2) q1.poll()
            if(q1.isNotEmpty()) q1.forEach { it.couont -= 1 }
            if(q2.isNotEmpty() && q1.sumBy { it.weight } + q2.peek().weight <= weight) q1.add(q2.poll())
        }
        return answer
    }
    println(solution(2, 10, intArrayOf(7,4,5,6)))
}