package kakao.practice_level3

fun main() {
    fun solution(n: Int): Array<IntArray> {
        val array = ArrayList<IntArray>()

        fun go(n: Int, a: Int, b: Int, c: Int) {
            if(n == 1) {
                array.add(intArrayOf(a, b))
                return
            } else {
                go(n - 1, a, c, b)
                array.add(intArrayOf(a, b))
                go(n - 1, c, b, a)
            }
        }

        go(n, 1, 3, 2)

        val answer = Array(array.size) { IntArray(2) }
        for(i in array.indices) {
            answer[i][0] = array[i][0]
            answer[i][1] = array[i][1]
        }

        return answer
    }
    print(solution(2))
}