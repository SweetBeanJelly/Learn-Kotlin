package kakao.practice_level2

fun main() {
    fun solution(s: String): String {
        val answer = s.toLowerCase().toCharArray()
        for(i in 1 until answer.size)
            if(answer[i].isLowerCase())
                if(answer[i - 1] == ' ') answer[i] = answer[i].toUpperCase()
        answer[0] = answer[0].toUpperCase()
        return String(answer)
    }
}