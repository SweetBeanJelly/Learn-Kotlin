package kakao.월간_시즌1

fun main() {
    fun solution(arr: Array<IntArray>): IntArray {
        val tmp = intArrayOf(0, 0)

        fun go(a: Int, b: Int, c: Int, d: Int): IntArray {
            var cnt = 0
            for(i in a until b)
                for(j in c until d)
                    if(arr[j][i] == 1) cnt++
            when (cnt) {
                (b - a) * (d - c) -> tmp[1]++
                0 -> tmp[0]++
                else -> {
                    val i = (a + b) / 2
                    val j = (c + d) / 2
                    go(a, i, c, j)
                    go(a, i, j, d)
                    go(i, b, c, j)
                    go(i, b, j, d)
                }
            }
            return tmp
        }

        return go(0, arr.size, 0, arr.size)
    }
    print(solution(arrayOf(intArrayOf(1,1,0,0), intArrayOf(1,0,0,0), intArrayOf(1,0,0,1), intArrayOf(1,1,1,1))).joinToString())
}






