package BOJ03

/*
 중위 순회와 후위 순회가 주어졌을 때 전위 순회를 구하는 문제
*/

fun main() {
    val N = readLine()!!.toInt()
    val array1 = IntArray(N + 1)
    val str = readLine()!!.split(" ").map { it.toInt() }
    for(i in 0 until N) {
        array1[str[i]] = i
    }
    val array2 = readLine()!!.split(" ").map { it.toInt() }

    fun get(a: Int, b:Int, c: Int, d: Int) {
        if(a > b || c > d) return
        val root = array2[d]
        print("$root ")
        val left = array1[root] - a

        get(a, array1[root] - 1, c, c + left - 1)
        get(array1[root] + 1, b, c + left, d - 1)
        return
    }

    get(0, N - 1, 0, N - 1)
}