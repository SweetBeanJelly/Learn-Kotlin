package kakao.월간_시즌1

fun main() {
    fun solution(n: Int): IntArray {
        val answer = Array(n) { IntArray(n) }
        var (a, b) = 0 to -1

        for(i in 1 .. n)
            for(j in 0 until n - i + 1) {
                val t = (n - i + 2..n).sum() + j + 1
                when(i % 3) {
                    1 -> b++
                    2 -> a++
                    else -> {
                        b--
                        a--
                    }
                }
                answer[b][a] = t
            }

        return answer.flatMap { it.filter { i -> i != 0 } }.toIntArray()
    }
    print(solution(4))
}