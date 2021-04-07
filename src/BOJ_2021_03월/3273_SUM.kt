package BOJ_2021_03월

fun main() {
    val N = readLine()!!.toInt()
    val array = readLine()!!.split(" ").map { it.toInt() }.toIntArray().sorted()
    val M = readLine()!!.toInt()

    var count = 0
    var (start, end) = 0 to N - 1
    while(start < end) {
        val sum = array[start] + array[end]
        if(sum == M) count++
        if(sum <= M) start++ else end--
    }
    print(count)
}

/*
fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val a = readLine()!!.split(" ").map{ it.toInt() }
    val x = readLine()!!.toInt()
    val f = a.groupBy{ it }.map{ (a, b) -> a to b.size }.toMap()
    println(f.map{ (y, c) ->  c.toLong() * f.getOrElse(x - y) { 0 } }.sum() / 2)
}
*/