package BOJ_2021_01월

import java.util.*

/*
 종이의 각 칸에는 -1, 0, 1 중 하나가 저장되어있다.
 종이를 잘랐을 때 종이의 개수 구하기
*/

lateinit var array: Array<Array<Int>>
var count = intArrayOf(0,0,0)

fun main() {
    val input = readLine()!!.toInt()
    array = Array(input) { Array(input) { 0 } }
    array.forEach {
        var str = StringTokenizer(readLine()!!)
        it.forEachIndexed { index, _ -> it[index] = str.nextToken().toInt() }
    }
    paper(0,0,input)
    print("${count[0]}\n${count[1]}\n${count[2]}")
}

fun paper(x: Int, y: Int, n: Int) {
    val check = array[x][y]
    for(i in x until x+n)
        for(j in y until y+n)
            if(array[i][j] != check) {
                for (k in 0 until 3) {
                    for (l in 0 until 3)
                        paper(x + k * n / 3, y + l * n / 3, n / 3)
                }
                return
            }
    when(check) {
        -1 -> count[0]++
        0 -> count[1]++
        else -> count[2]++
    }
}