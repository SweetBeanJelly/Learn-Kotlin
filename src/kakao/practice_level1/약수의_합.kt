package kakao.practice_level1

fun main() {
    fun solution(n: Int): Int = (1 .. n / 2).filter { n % it == 0 }.sum()
    print(solution(5))
}