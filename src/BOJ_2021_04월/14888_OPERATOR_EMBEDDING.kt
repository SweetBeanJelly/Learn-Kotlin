package BOJ_2021_04월

fun main() {
    val n = readLine()!!.toInt()
    val array = readLine()!!.split(" ").map { it.toInt() }
    val op = readLine()!!.split(" ").map { it.toInt() }.toIntArray()

    var (max, min) = Int.MAX_VALUE to Int.MIN_VALUE

    fun dfs(a: Int, b: Int) {
        if(a == n) {
            max = max.coerceAtMost(b)
            min = min.coerceAtLeast(b)
        }
        for(i in op.indices) {
            if(op[i] != 0) {
                op[i]--
                when(i) {
                    0 -> dfs(a + 1, b + array[a])
                    1 -> dfs(a + 1, b - array[a])
                    2 -> dfs(a + 1, b * array[a])
                    3 -> dfs(a + 1, b / array[a])
                }
                op[i]++
            }
        }
    }

    dfs(1, array[0])

    println(min)
    println(max)
}

/*
fun main(args: Array<String>) {
  val n = readLine()!!.toInt()
  val a = readLine()!!.split(" ").map{ it.toInt() }.toList()
  val f = readLine()!!.split(" ").map{ it.toInt() }.toList()
  /*val s = "+-*/".mapIndexed{ i, c -> List<Char>(f[i]) { c } }.flatten()

var amin = 2147483647
var amax = -2147483647
repeat(6000000) {
    val t = s.shuffled()
    val cur = a.reduceIndexed{ i, f, v -> when(t[i-1]) {
        '+' -> f + v
        '-' -> f - v
        '*' -> f * v
        else -> f / v
    } }
    if(amin > cur) amin = cur
    if(amax < cur) amax = cur
}

println(amax)
println(amin)

}
*/