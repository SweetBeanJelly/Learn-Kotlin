package kakao.kit

// https://programmers.co.kr/learn/courses/30/lessons/42584

fun main() {
    fun solution(prices: IntArray): IntArray {
        val answer = IntArray(prices.size)

        for(i in prices.indices)
            for(j in i+1 until prices.size) {
                answer[i]++
                if(prices[i] > prices[j]) break
            }

        return answer
    }
    print(solution(intArrayOf(1,2,3,2,3)).toList())
}