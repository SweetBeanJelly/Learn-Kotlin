package kakao.practice_level3

fun main() {
    fun solution(n: Int): Long {
        var answer = 0L
        when(n) {
            1 -> return 1
            2 -> return 2
            else -> answer = solution(n - 1) + solution(n - 2)
        }
        return answer
    }
    print(solution(4))
}