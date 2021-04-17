package kakao.practice_level3

fun main() {
    fun solution(s: String): Int {
        val answer = 1
        val array = s.toCharArray()

        for(i in s.length downTo 1)
            for(j in 0 until s.length - i) {
                var check = true
                for(k in 0 until i / 2)
                    if(array[k + j] != array[j + i - 1 - k]) {
                        check = false
                        break
                    }
                if(check) return i
            }

        return answer
    }
    print(solution("abcdcba"))
}