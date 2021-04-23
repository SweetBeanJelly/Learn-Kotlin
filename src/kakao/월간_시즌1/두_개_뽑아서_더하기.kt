package kakao.월간_시즌1

fun main() {
    fun solution(numbers: IntArray): IntArray {
        var answer = mutableSetOf<Int>()
        for(i in numbers.indices)
            for(j in i + 1 until numbers.size)
                answer.add(numbers[i] + numbers[j])

        return answer.sorted().toIntArray()
    }
    print(solution(intArrayOf(2,1,3,4,1)).joinToString())
}