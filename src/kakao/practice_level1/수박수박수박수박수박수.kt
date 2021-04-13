package kakao.practice_level1

fun main() {
    fun solution(n: Int): String = String(CharArray(n) {
        i -> if(i % 2 == 0) '수' else '박'
    })
    print(solution(3))
}