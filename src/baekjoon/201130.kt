package baekjoon

import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder
import java.util.*
import kotlin.collections.ArrayList

/*
 1. 단어의 개수
 2. 상수
 3. 다이얼 전화기
 4. 크로아티아 알파벳
 5. 그룹 단어 체커
*/

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    // 1
    /*
    var st = StringTokenizer(readLine(), " ")
    println(st.countTokens())
    */
    // 2
    /*
    var st = StringTokenizer(readLine(), " ")
    var i = (StringBuilder(st.nextToken()).reverse().toString()).toInt()
    var j = (StringBuilder(st.nextToken()).reverse().toString()).toInt()
    if(i > j) print(i)
    else print(j)
    */
    // 3
    /*
    var str = readLine()
    var count = 0

    for(i in str.indices) {
        when(str[i]) {
            'A', 'B', 'C' -> count += 3
            'D', 'E', 'F' -> count += 4
            'G', 'H', 'I' -> count += 5
            'J', 'K', 'L' -> count += 6
            'M', 'N', 'O' -> count += 7
            'P', 'Q', 'R', 'S' -> count += 8
            'T', 'U', 'V' -> count += 9
            'W', 'X', 'Y', 'Z' -> count += 10

        }
    }
    print(count)
    */
    // 4
    /*
    val array = listOf("c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z=")
    var str = readLine().trim()
    for(i in array.indices) {
        if(str.contains(array[i])) {
            str = str.replace(array[i]," ")
        }
    }
    print(str.length)
    */
    // 5
    /*
    var str = readLine().toInt()
    var count = 0

    for(i in 0 until str) {
        var s = readLine()
        count += check(s)
    }

    print(count)
    close()
    */
}

fun check(str: String): Int {
    var array = IntArray(26)

    for(i in 0 until 26) array[i] = -1
    for(j in str.indices) {
        if(array[((str[j] - 97).toInt())] == -1 || j - array[(str[j] - 97).toInt()] == 1) {
            array[((str[j] - 97).toInt())] = j
        } else {
            if(j - array[(str[j] - 97).toInt()] > 1) return 0
        }
    }
    return 1
}

