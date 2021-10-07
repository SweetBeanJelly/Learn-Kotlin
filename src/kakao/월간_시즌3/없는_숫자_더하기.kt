package kakao.월간_시즌3

fun main() {
    fun solution(numbers: IntArray): Int {
        var answer = 45
        for(n in numbers) answer -= n
        return answer
    }

    println(solution(intArrayOf(1,2,3,4,6,7,8,0)))
}

// fun solution(numbers: IntArray): Int = (0..9).filterNot(numbers::contains).sum()