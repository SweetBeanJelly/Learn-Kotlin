package kakao.kit

// https://programmers.co.kr/learn/courses/30/lessons/43165

fun main() {
    fun solution(numbers: IntArray, target: Int): Int {
        var answer = 0

        fun go(sum: Int, num: IntArray, index: Int, target: Int) {
            if(num.count() == index) {
                if(sum == target) answer++
            }
            else {
                go(sum + num[index], num, index + 1, target)
                go(sum + num[index] * - 1, num, index + 1, target)
            }
        }

        go(0, numbers, 0, target)

        return answer
    }
    print(solution(intArrayOf(1,1,1,1,1), 3))
}