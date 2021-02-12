package BOJ02

import java.util.*

/*
 전깃줄이 모두 교차하지 않도록 없애야 하는 전깃줄의 최소 개수 구하기
*/

fun main() {
    val N = readLine()!!.toInt()

    val A = IntArray(501)
    val array = IntArray(501)
    var result = 0

    repeat(N) {
        val str = StringTokenizer(readLine())
        A[str.nextToken().toInt() - 1] = str.nextToken().toInt()
    }

    for (i in 0 until 501) {
        if (A[i] == 0) continue
        array[i] = 1
        for (j in 0 until i)
            if (A[i] > A[j] && array[i] < array[j] + 1) array[i] = array[j] + 1
        if (result < array[i]) result = array[i]
    }

    println(N - result)
}

/*
    컴파일 에러
    val N = readLine()!!.toInt()
    val array = Array(N) { IntArray(2) }

    for (i in 0 until N) array[i] = readLine()!!.split(" ").map { it.toInt() }.toIntArray()
    //Arrays.stream(readLine()!!.split(" ".toRegex()).toTypedArray()).mapToInt { s: String -> s.toInt() }.toArray()

    Arrays.sort(array, Comparator.comparing { p1: IntArray -> p1[0] })

    val result = IntArray(N)
    Arrays.fill(result, 1)

    for (i in 1 until N)
        for (j in 0 until i)
            if (array[i][1] > array[j][1])
                result[i] = result[i].coerceAtLeast(result[j] + 1)

    Arrays.sort(result)
    println(N - result[result.size - 1])
*/