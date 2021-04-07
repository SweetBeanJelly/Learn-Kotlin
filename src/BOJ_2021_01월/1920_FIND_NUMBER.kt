package BOJ_2021_01월

/*
 N개의 정수 안에 X라는 정수가 존재하는지
*/

/*
fun main() {
    val n = readLine()!!.toInt()
    val N = mutableListOf<Int>()

    var str = StringTokenizer(readLine())
    for(i in 0 until n)
        N.add(str.nextToken().toInt())

    val m = readLine()!!.toInt()
    val M = mutableListOf<Int>()

    str = StringTokenizer(readLine())
    for(i in 0 until m)
        M.add(str.nextToken().toInt())

    N.sort()

    val sb = StringBuilder()
    for(i in M)
        sb.append("${binary(N, i, 0, n - 1)}\n")
    print(sb)
}

fun binary(array: MutableList<Int>, number: Int, start: Int, end: Int): Int {
    if(start > end) return 0

    val mid: Int = (start + end) / 2

    return when {
        array[mid] > number -> binary(array, number, start, mid - 1)
        array[mid] < number -> binary(array, number, mid + 1, end)
        else -> 1
    }
}
*/

/*
fun main() {
    val n = readLine()!!.toInt()
    val N = mutableSetOf<Int>()

    var str = StringTokenizer(readLine())
    for(i in 0 until n)
        N.add(str.nextToken().toInt())

    val m = readLine()!!.toInt()
    val M = mutableSetOf<Int>()

    str = StringTokenizer(readLine())
    for(i in 0 until m)
        M.add(str.nextToken().toInt())

    val sb = StringBuilder()
    for(i in M)
        if(i in N) sb.append("1\n") else sb.append("0\n")

    print(sb)
}
*/