package BOJ_2021_01월

import java.util.*

/*
 필요한 M 미터의 나무를 집에 가져가기 위해 나무 절단기에 설정할 수 잇는 높이의 최댓값 구하기
*/

fun main() = with(Scanner(System.`in`)) {
    val N = nextInt()
    val M = nextInt()
    val tree = IntArray(N)

    var start = 0
    var end = 1
    var result = 0

    for (i in tree.indices) {
        tree[i] = nextInt()
        start = start.coerceAtLeast(tree[i])
    }

    while (start >= end) {
        var sum: Long = 0
        val pivot = (0L + start + end) / 2
        for (i in tree.indices) {
            val len = tree[i] - pivot
            if (len > 0) sum += len
        }
        if (sum >= M) {
            end = (pivot + 1).toInt()
            result = result.coerceAtLeast(pivot.toInt())
        } else start = (pivot - 1).toInt()
    }
    println(result)
}