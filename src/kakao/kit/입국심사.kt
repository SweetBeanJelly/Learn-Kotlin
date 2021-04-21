package kakao.kit

import sort.right

fun main() {
    fun solution(n: Int, times: IntArray): Long {
        var answer: Long = 0
        times.sort()
        var (a, b) = 0L to (n * times[times.size - 1]).toLong()

        while(a <= b) {
            val mid = (a + b) / 2
            var sum = 0L
            for(i in times.indices) sum += mid / times[i]

            if(sum < n) a = mid + 1
            else {
                b = mid - 1
                answer = mid
            }
        }

        return answer
    }
    print(solution(6, intArrayOf(7,10)))
}