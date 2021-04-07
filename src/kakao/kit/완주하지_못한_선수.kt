package kakao.kit

// https://programmers.co.kr/learn/courses/30/lessons/42576

fun main() {
    fun solution(participant: Array<String>, completion: Array<String>): String {
        var answer = ""
        participant.sort()
        completion.sort()

        for(i in participant.indices)
            if(participant[i] != completion[i]) {
                answer = participant[i]
                return answer
            }

        answer = participant[participant.size - 1]
        return answer
    }
    val test1 = arrayOf("leo", "kiki", "eden", "kiki")
    val test2 = arrayOf("kiki", "eden", "leo")
    print(solution(test1, test2))
}