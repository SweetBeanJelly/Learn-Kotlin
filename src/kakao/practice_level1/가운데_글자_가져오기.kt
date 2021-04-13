package kakao.practice_level1

fun main() {
    fun solution(s: String) = s.slice((s.length - 1) / 2 .. s.length / 2)
    print(solution("awer"))
}