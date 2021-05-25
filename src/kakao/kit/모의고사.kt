package kakao.kit

// https://programmers.co.kr/learn/courses/30/lessons/42840

fun main() {
    fun solution(answers: IntArray): IntArray {
        val s1 = arrayOf(1,2,3,4,5)
        val s2 = arrayOf(2,1,2,3,2,4,2,5)
        val s3 = arrayOf(3,3,1,1,2,2,4,4,5,5)

        val list = arrayOf(0, 0, 0)

        for(i in answers.indices) {
            if(answers[i] == s1[i % s1.size]) list[0]++
            if(answers[i] == s2[i % s2.size]) list[1]++
            if(answers[i] == s3[i % s3.size]) list[2]++
        }

        var answer = intArrayOf()

        for(i in list.indices)
            if(list[i] >= list.maxOrNull()!!) answer += i + 1

        return answer
    }
    print(solution(intArrayOf(1,2,3,4,5)).contentToString())
}