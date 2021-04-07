package BOJ_2021_01월

import java.lang.StringBuilder
import java.util.*

/*
 큐 명령어 처리
 1. push X: 정수 X를 큐에 넣는 연산이다.
 2. pop: 큐에서 가장 앞에 있는 정수를 빼고, 그 수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
 3. size: 큐에 들어있는 정수의 개수를 출력한다.
 4. empty: 큐가 비어있으면 1, 아니면 0을 출력한다.
 5. front: 큐의 가장 앞에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
 6. back: 큐의 가장 뒤에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
*/

fun main() {
    var number = readLine()!!.toInt()
    var sb = StringBuilder()
    var q = ArrayDeque<Int>()

    repeat(number) {
        var str = StringTokenizer(readLine()!!, " ")

        when(str.nextToken()) {
            "push" -> q.offer(str.nextToken().toInt())
            "pop" -> sb.append("${q.poll() ?: -1}\n")
            "size" -> sb.append("${q.size}\n")
            "empty" -> sb.append("${if(q.isEmpty()) 1 else 0}\n")
            "front" -> sb.append("${q.peek() ?: -1}\n")
            "back" -> sb.append("${q.peekLast() ?: -1}\n")
        }
    }
    print(sb)
}