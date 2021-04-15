package kakao.practice_level1

fun main() {
    fun solution(phone_number: String): String = "*".repeat(phone_number.length - 4) + phone_number.slice(phone_number.length - 4 until phone_number.length)
    print(solution("027778888"))
}