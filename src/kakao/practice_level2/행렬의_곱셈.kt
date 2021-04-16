package kakao.practice_level2

fun main() {
    fun solution(arr1: Array<IntArray>, arr2: Array<IntArray>): Array<IntArray> {
        val answer = Array(arr1.size) { IntArray(arr2[0].size) }
        for(i in arr1.indices)
            for(j in arr2[0].indices)
                for(k in arr1[0].indices)
                    answer[i][j] += arr1[i][k] * arr2[k][j]
        return answer
    }
    print(solution(arrayOf(intArrayOf(1,4), intArrayOf(3,2), intArrayOf(4,1)), arrayOf(intArrayOf(3,3), intArrayOf(3,3))))
}