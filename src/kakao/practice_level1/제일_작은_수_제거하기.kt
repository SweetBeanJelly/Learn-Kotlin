package kakao.practice_level1

fun main() {
    fun solution(arr: IntArray): IntArray = if(arr.size == 1) intArrayOf(-1) else arr.filter { it != arr.minOrNull() }.toIntArray()
    print(solution(intArrayOf(10)))
}