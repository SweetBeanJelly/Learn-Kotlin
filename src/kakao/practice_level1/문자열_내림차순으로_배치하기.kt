package kakao.practice_level1

fun main() {
    fun solution(s: String): String = String(s.toCharArray().sortedArrayDescending())
    /*
    fun solution(s: String): String {
        return s.split("").sorted().reversed().joinToString("")
    }
    */
    print(solution("Zbcdefg"))
}