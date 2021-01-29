package BOJ01

import java.util.*


/*
 배열에 자연수 x를 넣는다 -> 배열에서 가장 큰 값 출력, 그 값을 배열에서 제거한다.
*/

fun main() {
    val input = readLine()!!.toInt()
    val queue = PriorityQueue<Int>(Collections.reverseOrder())
    for(i in 0 until input) {
        val x = readLine()!!.toInt()
        if(x == 0) {
            if(queue.isEmpty()) println(0) else println(queue.poll())
        } else {
            queue.offer(x)
        }
    }
}

/*
val heap = java.util.PriorityQueue<Int>()
    repeat(readLine()!!.toInt()) {
        val x = readLine()!!.toInt()
        if(x > 0) heap.add(-x)
        else println(if(heap.isEmpty()) 0 else -heap.poll())
    }
*/