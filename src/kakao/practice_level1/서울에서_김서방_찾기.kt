package kakao.practice_level1

fun main() {
    fun solution(seoul: Array<String>): String = "김서방은 ${seoul.indexOf("Kim")}에 있다"
    print(solution(arrayOf("Jane", "Kim")))
}