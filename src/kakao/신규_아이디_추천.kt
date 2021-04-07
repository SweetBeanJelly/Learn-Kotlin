fun main() {
    fun solution(new_id: String): String {
        var answer = new_id
        //1 소문자
        answer = answer.toLowerCase()

        val r1 = Regex("[a-z0-9-_.]")
        val r2 = Regex("[.]{2,}")

        //2 r1 만족
        var temp = ""

        for(i in answer.indices)
            if(r1.containsMatchIn(answer[i].toString()))
                temp += answer[i]
        answer = temp

        //3 r2 만족
        answer = answer.replace(r2, ".")

        //4 . 처음 끝 제거
        if(answer.isNotEmpty() && answer.first() == '.')
            answer = answer.removeRange(0, 1)
        if(answer.isNotEmpty() && answer.last() == '.')
            answer = answer.removeRange(answer.length - 1, answer.length)

        //5 빈 문자열
        if(answer.isEmpty()) answer = "a"

        //6 길이 16이상
        if(answer.length >= 16) {
            answer = answer.substring(0..14)
            if(answer.last() == '.')
                answer = answer.removeRange(answer.length - 1, answer.length)
        }

        //7 길이 2이하
        while(answer.length <= 2) {
            answer = answer.plus(answer[answer.length - 1])
        }

        return answer
    }
}