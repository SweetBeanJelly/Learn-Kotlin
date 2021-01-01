package baekjoon

import java.io.*
import java.util.*

/*
 1. OX 퀴즈 문제
 2. 평균을 넘는 학생들의 비율 반올림하는 문제
*/

// 1
/*
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    var count = readLine().toInt()

    repeat(count) {
        val q = readLine()
        var number = 0
        var sum = 0

        for(i in q.indices) {
            if(q[i] == 'O') {
                number++
                sum += number
            } else number = 0
        }

        println(sum)
    }
}
*/

// 2
/*
var sc = Scanner(System.`in`)

fun main() {
    var result = DoubleArray(sc.nextInt())

    for(i in result.indices) {
        result[i] = getAverage(sc.nextInt())
    }

    for(j in result.indices) {
        System.out.printf("%.3f", result[j])
        println("%")
    }
}

fun getAverage(number: Int): Double {
    var score = IntArray(number)
    var temp = 0
    var count = 0

    for(i in 0 until number) {
        score[i] = sc.nextInt()
        temp += score[i]
    }

    var average = (temp / number).toDouble()

    for(j in 0 until number) {
        if(score[j] > average) count++
    }

    return (100.0 * count) / number
}
*/

