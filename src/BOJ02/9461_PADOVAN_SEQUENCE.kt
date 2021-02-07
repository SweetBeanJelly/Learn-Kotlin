package BOJ02

/*
 파도반 수열
*/

fun main() {
    val input = readLine()!!.toInt()
    for(i in 0 until input) {
        val N = readLine()!!.toInt()
        val array = LongArray(N + 1)
        array[1] = 1
        if(N >= 2) array[2] = 1
        for(j in 3 until N + 1) array[j] = array[j - 2] + array[j - 3]
        println(array[N])
    }
}