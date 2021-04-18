fun main() {
    fun solution(N: Int, stages: IntArray): IntArray {
        val answer = IntArray(N)

        val p = mutableMapOf<Int, Int>()
        val fail = mutableMapOf<Int, Double>()

        stages.forEach {
            when(p.containsKey(it)) {
                true -> p[it] = p.getValue(it) + 1
                false -> p[it] = 1
            }
        }

        var size = stages.size
        for(i in 1..N) {
            when(p.containsKey(i)) {
                true -> {
                    fail[i] = p.getValue(i) / size.toDouble()
                    size -= p.getValue(i) }
                false -> fail[i] = 0.0
            }
        }

        val list = fail.toList().sortedByDescending { (_, value) -> value }

        for(i in 0 until N) answer[i] = list[i].first

        return answer
    }

    val test = intArrayOf(2,1,2,6,2,4,3,3)
    print(solution(5, test).toList())
}