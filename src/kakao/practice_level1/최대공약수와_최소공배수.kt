package kakao.practice_level1

fun main() {
    fun solution(n: Int, m: Int): IntArray {
        var min = n
        var max = m
        val temp = max * min
        while(min > 0) {
            val temp = max % min
            max = min
            min = temp
        }

        return intArrayOf(max, temp / max)
    }
    print(solution(3,12))
}