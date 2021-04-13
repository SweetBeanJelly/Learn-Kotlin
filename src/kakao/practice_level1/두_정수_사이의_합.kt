package kakao.practice_level1

fun main() {
    fun solution(a: Int, b: Int): Long {
        var answer: Long = 0
        when {
            a > b -> for(i in a downTo b) answer += i
            a < b -> for(i in a..b) answer += i
            a == b -> answer = a.toLong()
        }
        return answer
    }
    print(solution(5, 3))
}