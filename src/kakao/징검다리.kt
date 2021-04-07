import kotlin.math.max

fun main() {
    fun solution(distance: Int, rocks: IntArray, n: Int): Int {
        var answer = 0
        rocks.sort()

        var left = 1
        var right = distance
        while(left <= right) {
            var count = 0
            var p = 0
            var min = distance
            val mid = (left + right) / 2

            for(i in rocks.indices) {
                if(rocks[i] - p <= mid) count++
                else {
                    min = min.coerceAtMost(rocks[i] - p)
                    p = rocks[i]
                }
            }
            if(distance - p <= mid) count++ else min = min.coerceAtMost(distance - p)
            if(count <= n) {
                answer = max(answer, min)
                left = mid + 1
            } else right = mid - 1

        }

        return answer
    }
}