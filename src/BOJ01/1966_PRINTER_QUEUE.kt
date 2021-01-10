package BOJ01

import java.util.*

/*
 중요도가 높은 순서대로 인쇄하는 프린터
*/

fun main() {
    val number = readLine()!!.toInt()
    var str: StringTokenizer

    repeat(number) {
        str = StringTokenizer(readLine())
        val n = str.nextToken().toInt()
        val m = str.nextToken().toInt()

        str = StringTokenizer(readLine())
        val q: Queue<Pair<Int,Int>> = LinkedList()
        val printq = PriorityQueue<Int>(Collections.reverseOrder())
        var count = 0

        for(i in 0 until n) {
            val k = str.nextToken().toInt()
            q.offer(Pair(i, k))
            printq.offer(k)
        }

        while (q.isNotEmpty()) {
            val t = q.poll()
            if(t.second == printq.peek()) {
                count++
                printq.poll()
                if(t.first == m) break
            } else q.offer(t)
        }

        println(count)
    }
}
