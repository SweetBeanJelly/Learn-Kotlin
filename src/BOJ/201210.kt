package BOJ

import java.io.BufferedReader
import java.io.InputStreamReader

/*
 1. 수 정렬하기
 2. 수 정렬하기 2
 3. 수 정렬하기 3
*/

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    // 1
    /*
    var n = readLine()!!.toInt()
    var array = IntArray(n)

    for(i in array.indices) array[i] = readLine()!!.toInt()

    for(j in 0 until n-1) {
        for(k in j+1 until n) {
            if(array[j] > array[k]) {
                var temp = array[k]
                array[k] = array[j]
                array[j] = temp
            }
        }
    }

    array.forEach { println(it) }
    */
    // 2
    /*
    var n = readLine().toInt()
    var array = ArrayList<Int>()

    for(i in 0 until n) array.add(readLine().toInt())

    array.sort()

    var bw = BufferedWriter(OutputStreamWriter(System.out))

    for(j in array.indices) {
        bw.write("${array[j]}\n")
    }
    bw.flush();
    */
    // 3
    /*
    var n = readLine().toInt()
    var count = IntArray(10001)

    for(i in 0 until n) count[readLine().toInt()]++

    var bw = BufferedWriter(OutputStreamWriter(System.out))

    for(i in count.indices) {
        if(count[i] > 0) {
            for(j in 0 until count[i]) bw.write("$i\n")
        }
    }
    bw.flush();
    */
}