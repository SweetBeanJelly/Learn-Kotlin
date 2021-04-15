package kakao.practice_level1

fun main() {
    fun solution(arr1: Array<IntArray>, arr2: Array<IntArray>): Array<IntArray> = arr1.mapIndexed { i, a1 -> a1.mapIndexed { j, a2 -> a2 + arr2[i][j]}.toIntArray()}.toTypedArray()
    print(solution(arrayOf(intArrayOf(1,2)), arrayOf(intArrayOf(3,4))))
}