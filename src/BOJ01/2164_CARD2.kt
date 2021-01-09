package BOJ01

import java.util.*

/*
 제일 마지막에 남게 되는 카드 구하기
*/

fun main() = with(Scanner(System.`in`)) {
    val input = nextInt()
    var q = LinkedList<Int>()

    for(i in 1..input) q.offer(i)
    while(q.size > 1) {
        q.poll()
        q.offer(q.poll())
    }
    println(q.poll())
}