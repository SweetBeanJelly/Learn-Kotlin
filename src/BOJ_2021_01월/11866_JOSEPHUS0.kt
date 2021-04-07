package BOJ_2021_01월

import java.lang.StringBuilder
import java.util.*

/*
 요세푸스(조세퍼스) 순열을 구하는 문제
*/

fun main() = with(Scanner(System.`in`)) {
    val n1 = nextInt()
    val n2 = nextInt()
    var q = LinkedList<Int>()

    var sb = StringBuilder()
    sb.append("<")

    for(i in 1..n1) q.offer(i)
    while (q.size > 1) {
        repeat(n2-1) {
            q.offer(q.poll())
        }
        sb.append("${q.poll()}, ")
    }
    sb.append("${q.poll()}>")
    print(sb)
}