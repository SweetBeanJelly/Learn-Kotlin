package kakao.practice_level1

fun main() {
    fun solution(n: Long): Long = n.toString().toList().sortedDescending().joinToString( "","","").toLong()
    print(solution(118372))
}