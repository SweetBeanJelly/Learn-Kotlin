package kakao.practice_level1

fun main() {
    fun solution(n: Int): Int {
        val list = n.toString()
        var answer = 0

        for(i in list.indices)
            answer += list[i].toInt() - 48

        return answer
        /*
        var answer = 0

        for (nn in n.toString()) {
            answer += (nn.toString()).toInt()
        }

        return answer
        */
    }
    print(solution(987))
}