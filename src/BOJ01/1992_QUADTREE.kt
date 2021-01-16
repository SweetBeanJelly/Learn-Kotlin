package BOJ01

import java.lang.StringBuilder
import java.util.*

/*
 흰 점을 나타내는 0 검은 점을 나타내는 1 으로 이루어진 영상(2차원 배열)에서
 같은 숫자의 점들이 한 곳에 몰려있다면 이를 압축하여 간단히 표현할 수 있다.
 압축 결과 출력
*/

var sb = StringBuilder()
lateinit var array: Array<Array<Int>>

fun main() {
    val input = readLine()!!.toInt()
    array = Array(input) { Array(input) { 0 } }
    for(i in 0 until input) {
        val c = readLine()!!.toCharArray()
        for(j in c.indices) array[i][j] = c[j] - '0'
    }
    quad(0,0,input)
    print(sb.toString())
}

fun quad(x: Int, y: Int, n: Int) {
    val check = array[x][y]
    var flag = true
    for(i in x until x+n) {
        for (j in y until y + n) {
            if (check != array[i][j]) {
                sb.append('(')
                quad(x, y, n / 2)
                quad(x, y + n / 2, n / 2)
                quad(x + n / 2, y, n / 2)
                quad(x + n / 2, y + n / 2, n / 2)
                sb.append(')')
                flag = false
                break
            }
        }
        if(!flag) break
    }
    if(flag) {
        if (check == 0) sb.append(0)
        else sb.append(1)
    }
}