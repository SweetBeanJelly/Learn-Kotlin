package kakao.practice_level1

fun main() {
    fun solution(arr: IntArray): Double = arr.sum().toDouble() / arr.size
    print(solution(intArrayOf(1,2,3,4)))
}