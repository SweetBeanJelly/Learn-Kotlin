package kakao.practice_level1

fun main() {
    fun solution(x: Int, n: Int): LongArray {
        var answer = longArrayOf()
        val X = x.toLong()
        for(i in 1..n)
            answer += X * i
        return answer
    }
    print(solution(2, 5))
}