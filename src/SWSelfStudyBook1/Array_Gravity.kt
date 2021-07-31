package SWSelfStudyBook1

/*
테스트 케이스 1
가로 9 세로 8
높이 7 4 2 0 0 6 0 7 0
*/

fun main() {
    fun result(t: Int, n: Int, m: Int, arr: IntArray): Int {
        var max = 0
        for(tc in 1..t) {
            val a = Array(n) { IntArray(n) }
            val b = Array(n) { IntArray(n) }

            for(i in 0 until n)
                for(j in 0 until arr[i])
                    a[i][j] = 1

            for(i in 0 until n)
                for(j in 0 until n) {
                    if(a[i][j] == 1) {
                        var c = 0
                        for(k in i+1 until n)
                            if(a[k][j] == 0) c++
                        b[i][j] = c // 결과
                        max = c.coerceAtLeast(max)
                    }
                }
        }
        return max
    }
    println(result(1, 9, 8, intArrayOf(7,4,2,0,0,6,0,7,0)))
}