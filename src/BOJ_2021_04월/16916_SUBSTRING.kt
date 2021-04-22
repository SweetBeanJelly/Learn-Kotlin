package BOJ_2021_04월

fun main() {
    val (a, b) = readLine()!! to readLine()!!
    var result = 0

    fun get(b: String): IntArray {
        val c = IntArray(b.length)
        var j = 0
        for (i in 1 until b.length) {
            while (j > 0 && b[i] != b[j]) {
                j = c[j - 1]
            }
            if (b[i] == b[j]) c[i] = ++j
        }
        return c
    }

    fun go(a: String, b: String) {
        val c: IntArray = get(b)
        var j = 0
        for (i in a.indices) {
            while (j > 0 && a[i] != b[j]) j = c[j - 1]
            if (a[i] == b[j])
                if (j == b.length - 1) {
                    result = 1
                    break
                } else j++
        }
    }

    go(a, b)
    println(result)
}