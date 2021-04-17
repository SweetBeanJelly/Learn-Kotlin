package kakao.월간_시즌2

fun main() {
    fun solution(absolutes: IntArray, signs: BooleanArray): Int {
        var answer = 0
        var temp = intArrayOf()
        for(i in absolutes.indices) {
            temp += if (signs[i]) absolutes[i] else absolutes[i] * -1
            answer += temp[i]
        }

        return answer
    }
    print(solution(intArrayOf(4,7,12), booleanArrayOf(true, false, true)))
}