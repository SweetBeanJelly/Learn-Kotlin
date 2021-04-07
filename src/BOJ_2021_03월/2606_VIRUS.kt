package BOJ_2021_03월

/*
 1번 컴퓨터를 통해 웜 바이러스에 걸리게 되는 컴퓨터의 수를 출력하는 프로그램을 작성
*/

fun main() {
    val N = readLine()!!.toInt()
    val array = Array(N) { IntArray(N) }
    val flag = BooleanArray(N) { false }

    fun dfs(n: Int) {
        flag[n] = true
        for(i in 0 until N)
            if(array[n][i] == 1 && !flag[i]) dfs(i)
    }

    repeat(readLine()!!.toInt()) {
        val number = readLine()!!.split(" ").map { it.toInt() }
        array[number[0] - 1][number[1] - 1] = 1
        array[number[1] - 1][number[0] - 1] = 1
    }

    dfs(0)
    println(flag.count { it } - 1)
}