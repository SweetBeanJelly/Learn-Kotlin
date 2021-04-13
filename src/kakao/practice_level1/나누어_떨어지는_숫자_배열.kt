package kakao.practice_level1

fun main() {
    fun solution(arr: IntArray, divisor: Int): IntArray {
        var answer = intArrayOf()
        for(i in arr.indices)
            if(arr[i] % divisor == 0) answer += arr[i]
        if(answer.isEmpty()) answer += -1

        return answer.sorted().toIntArray()
    }
    print(solution(intArrayOf(2,36,1,3), 1))
}