package kakao.practice_level2

fun main() {
    fun solution(n: Int): Int {
        var temp = intArrayOf()
        for(i in 0..n) {
            when {
                i == 0 -> temp += 0
                i == 1 -> temp += 1
                i >= 2 -> temp += (temp[i - 1] + temp[i - 2]) % 1234567
            }
        }
        return temp[n]
    }
    print(solution(5))
}