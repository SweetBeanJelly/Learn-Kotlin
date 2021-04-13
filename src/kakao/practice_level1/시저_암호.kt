package kakao.practice_level1

fun main() {
    fun solution(s: String, n: Int): String {
        val answer = s.toCharArray()
        for((i, j) in answer.withIndex()) {
            if(j in 'A'..'Z')
                answer[i] = ((j - 'A' + n) % 26 + 'A'.toInt()).toChar()
            else if(j in 'a'..'z')
                answer[i] = ((j - 'a' + n) % 26 + 'a'.toInt()).toChar()
        }
        return String(answer)
        /*
        s.toList().joinToString(separator = "") {
            when (it) {
                in 'A'..'Z' -> ('A'.toInt() + (it.toInt() - 'A'.toInt() + n) % ('Z' - 'A' + 1)).toChar()
                in 'a'..'z' -> ('a'.toInt() + (it.toInt() - 'a'.toInt() + n) % ('z' - 'a' + 1)).toChar()
                else -> it
            }.toString()
        }
        */
    }
    print(solution("a B z", 4))
}