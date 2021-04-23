package kakao.월간_시즌1

fun main() {
    fun solution(a: IntArray, b: IntArray): Int {
        var answer: Int = 0
        for(i in a.indices)
            answer += a[i] * b[i]
        return answer
    }
}