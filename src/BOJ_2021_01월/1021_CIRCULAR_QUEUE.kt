package BOJ_2021_01월

import java.util.*


/*
 회전하는 큐
 1. 첫 번째 원소 뽑기
 2. 왼쪽 한칸 이동
 3. 오른쪽 한칸 이동
 양방향 순환 큐에서 뽑아내려고 할 때 2, 3번 연산의 최솟값 출력.
*/

fun main() {
    var str = StringTokenizer(readLine()," ")
    val n = str.nextToken().toInt()
    val m = str.nextToken().toInt()
    
    val q = arrayListOf<Int>()
    repeat(n) {
        q.add(it+1)
    }
    
    var flag: Boolean
    var result = 0

    str = StringTokenizer(readLine()," ")
    for (i in 0 until m) {
        val position = str.nextToken().toInt()
        flag = false
        while (!flag) {
            if (q[0] == position) {
                q.removeAt(0)
                flag = true
            } else {
                if (q.indexOf(position) <= q.size / 2) q.add(q.size - 1, q.removeAt(0)) else q.add(0, q.removeAt(q.size - 1))
                result++
            }
        }
    }
    println(result)
}