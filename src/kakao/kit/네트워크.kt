package kakao.kit

// https://programmers.co.kr/learn/courses/30/lessons/43162

fun main() {
    fun solution(n: Int, computers: Array<IntArray>): Int {
        var answer = 0
        val check = Array(n) { BooleanArray(n) }

        fun go(index: Int) {
            for(i in 0 until n)
                if(computers[index][i] == 1 && !check[index][i]) {
                    check[i][index] = true
                    check[index][i] = check[i][index]
                    go(i)
                }

        }

        for(i in 0 until n)
            if(!check[i][i]) {
                answer++
                go(i)
            }

        return answer
    }
    print(solution(3, arrayOf(intArrayOf(1,1,0), intArrayOf(1,1,0), intArrayOf(0,0,1))))
}