package kakao.practice_level1

fun main() {
    fun solution(num: Int): String = if(num % 2 == 0) "Even" else "Odd"
    print(solution(4))
}