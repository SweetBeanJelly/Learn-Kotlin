package BOJ_2021_04월

fun main() {
    var sum = 0
    var max = 0
    for(i in 0 until 10) {
        val (n, k) = readLine()!!.split(" ").map { it.toInt() }
        sum += (k - n)
        max = max.coerceAtLeast(sum)
    }
    print(max)
}