package kakao.Dev_Matching_21

// https://programmers.co.kr/learn/courses/30/lessons/77484

fun main() {
    fun solution(lottos: IntArray, win_nums: IntArray): IntArray {
        val answer = intArrayOf(6, 6, 5, 4, 3, 2, 1)
        var (count, z) = 0 to 0

        for(i in lottos) {
            if(i == 0) z++
            if(win_nums.contains(i)) count++
        }

        return intArrayOf(answer[count + z], answer[count])
    }
    print(solution(intArrayOf(44, 1, 0, 0, 31, 25), intArrayOf(31, 10, 45, 1, 6, 19)).joinToString())
}