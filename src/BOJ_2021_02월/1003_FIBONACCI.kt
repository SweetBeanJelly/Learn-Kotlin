package BOJ_2021_02월

fun main() {
    val array = Array(41) { IntArray(2) }
    array[0][0] = 1
    array[1][1] = 1

    repeat(readLine()!!.toInt()) {
        val case = readLine()!!.toInt()
        for(i in 2 until case + 1)
            for(j in 0 until 2)
                array[i][j] = array[i - 1][j] + array[i - 2][j]
        println(array[case].joinToString(" "))
    }
}