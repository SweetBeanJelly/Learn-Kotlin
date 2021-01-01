package baekjoon

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.math.ceil
import kotlin.math.sqrt

/*
 1. 달팽이는 올라가고 싶다
 2. ACM 호텔
 3. 부녀회장이 될테야
 4. Fly me to the Alpha Centauri
*/

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    // 1
    /*
    var str = StringTokenizer(readLine(), " ")

    var m = str.nextToken().toInt()
    var n = str.nextToken().toInt()
    var a = str.nextToken().toInt()

    var d = (a - n) / (m - n)

    if((a - n) % (m - n) != 0) d++
    print(d)
    */
    // 2
    /*
    var input = readLine().toInt()

    for(i in 0 until input) {
        var str = StringTokenizer(readLine(), " ")

        var h = str.nextToken().toInt()
        str.nextToken() //
        var n = str.nextToken().toInt()

        if(n % h == 0) {
            println(((h * 100) + (n / h)))
        } else {
            println((((n % h) * 100) + ((n / h) + 1)))
        }
    }
    */
    // 3
    /*
    var input = readLine().toInt()

    while (input-->0) {
        var i = readLine().toInt()
        var j = readLine().toInt()
        println(result(i, j))
    }
    */
    // 4
    /*
    var input = readLine().toInt()

    while(input-->0) {
        var str = StringTokenizer(readLine(), " ")
        var x = str.nextToken().toInt()
        var y = str.nextToken().toInt()
        println(result(y - x))
    }
    */
}

/*
fun result(i: Int, j: Int): Int {
    return if(i == 0) {
        j
    } else {
        var k = 0
        for(n in 1..j) k += result(i-1, n)
        k
    }
}
*/

/*
fun result(i: Int): Int {
    var n = ceil(sqrt(i.toDouble()))

    return if(i > n * n - n) {
        (2 * n - 1).toInt()
    } else {
        (2 * n - 2).toInt()
    }
}
*/