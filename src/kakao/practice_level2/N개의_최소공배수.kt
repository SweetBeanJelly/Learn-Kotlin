package kakao.practice_level2



fun main() {
    fun lcs(a: Int, b: Int): Int {
        return if (a % b == 0) return b
        else lcs(b, (a % b))
    }
    fun solution(arr: IntArray): Int {
        var answer = 1
        for(i in arr)
            answer = (answer * i ) / lcs(answer, i)

        return answer
    }
    print(solution(intArrayOf(2,6,8,14)))
}