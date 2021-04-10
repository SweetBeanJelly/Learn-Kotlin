package kakao.kit

// https://programmers.co.kr/learn/courses/30/lessons/42747

fun main() {
    fun solution(citations: IntArray): Int {
        citations.sortDescending()
        for(i in citations.indices)
            if(citations[i] <= i) return i

        return citations.size
    }
    print(solution(intArrayOf(3,0,6,1,5)))
}