package BOJ_2020

import java.io.BufferedReader
import java.io.InputStreamReader

/*
 (완전 탐색)
 1. 블랙잭
 2. 분해합
 3. 덩치
*/

/*
var n = 0
var m = 0
var result = 0
var array = IntArray(0)
*/

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    // 1
    /*
    var str = StringTokenizer(readLine(), " ")
    n = str.nextToken().toInt()
    m = str.nextToken().toInt()
    array = IntArray(n)

    str = StringTokenizer(readLine(), " ")

    for(i in 0 until n) {
        array[i] = str.nextToken().toInt()
    }

    cards(0, 0, 0)

    println(result)
    */
    // 2
    /*
    var number = readLine().toInt()

    var result = 0

    for(i in 0 until number) {
        var n = i
        var temp = 0

        while (n != 0) {
            temp += n % 10
            n /= 10
        }
        if(temp + i == number) {
            result = i
            break
        }
    }
    print(result)
    */
    // 3
    /*
    var input = readLine().toInt()
    var x = IntArray(50){0}
    var y = IntArray(50){0}

    for(i in 0 until input) {
        var str = readLine().split(" ") as ArrayList<String>
        x[i] = str[0].toInt()
        y[i] = str[1].toInt()
    }
    for(j in 0 until input) {
        var r = 0
        for(k in 0 until input) {
            if(x[j] < x[k] && y[j] < y[k]) r++
        }
        print("${r+1} ")
    }
    */
}

/*
fun cards(index: Int, count: Int, sum: Int) {
    if(count == 3 && sum <= m) {
        result = max(result, sum)
        return
    }
    if(index >= n || count > 3 || sum > m) return

    cards(index + 1, count + 1, sum + array[index])
    cards(index + 1, count, sum)
}
*/