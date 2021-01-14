package BOJ01

import java.util.*

/*
 여러개의 정사각형들로 이루어진 정사각형 모양의 종이. 각 정사각형들은 하얀색, 파란색으로 칠해져 있다.
 주어진 종이를 일정한 규칙에 따라 잘라 다양한 크기를 가진 정사각형 모양의 하얀색, 파란색 색종이를 만든다.
 전체 종이의 한 변의 길이가 주어지고 정사각형의 색이 윗줄부터 차례로 주어진다. 하얀색 0 파란색 1
*/

var white = 0
var blue = 0

fun main() {
    val input = readLine()!!.toInt()
    var array = Array(input) { Array(input) { 0 } }
    array.forEach {
        var str = StringTokenizer(readLine()!!)
        it.forEachIndexed { index, _ -> it[index] = str.nextToken().toInt() }
    }
    origami(input, 0, 0, array)
    print("$white\n$blue")
}

fun origami(h: Int, x: Int, y: Int, array: Array<Array<Int>>) {
    val check = array[y][x]
    var flag = true

    for(i in y until y+h)
        for(j in x until x+h)
            if(check != array[i][j]) {
                flag = false
                break
            }

    if(flag) {
        if(check == 0) white++
        else blue++
        return
    }

    origami(h/2, x, y, array)
    origami(h/2, x + h/2, y, array)
    origami(h/2, x, y + h/2, array)
    origami(h/2, x + h/2, y + h/2, array)
}