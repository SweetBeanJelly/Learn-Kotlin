package BOJ_2021_04월

fun main() {
    val n = readLine()!!.toLong()
    var r: Long = 1
    while(r * (r + 1) / 2 <= n) r += 1
    print(r - 1)
}