package BOJ_2021_02월

/*
 바이토닉 수열이면서 가장 긴 수열의 길이를 구하기
*/

fun main() {
    val N = readLine()!!.toInt()
    val array = readLine()!!.split(" ").map { it.toInt() }
    val a = IntArray(N) {0}
    val b = IntArray(N) {0}

    for(i in array.indices) {
        for(j in 0 until i) if (array[i] > array[j] && a[i] < a[j]) a[i] = a[j]
        a[i] += 1
    }
    for(i in N - 1 downTo 0) {
        for (j in N - 1 downTo i) if (array[i] > array[j] && b[i] < b[j]) b[i] = b[j]
        b[i] += 1
    }
    val sum = IntArray(N)
    for(i in sum.indices) sum[i] = a[i] + b[i]
    print(sum.maxOrNull()?.minus(1))
}