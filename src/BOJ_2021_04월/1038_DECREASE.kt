package BOJ_2021_04월

import java.util.ArrayList

fun main() {
    val n = readLine()!!.toInt()
    val list = ArrayList<Long>()

    fun go(num: Long, digit: Int, b: ArrayList<Long>): ArrayList<Long> {
        if (digit > 10) return b
        b.add(num)
        for (i in 0..9)
            if (num % 10 > i) go(num * 10 + i, digit + 1, b)
        return b
    }

    for(num in 0..9) go(num.toLong(), 1, list)
    list.sort()
    if(n >= 1023) println(-1) else println(list[n])
}

/*
fun main(args: Array<String>) {
    val a = (1 until (1 shl 10)).map{ state -> (9 downTo 0).filter{ (state shr it) and 1 == 1 }.joinToString("").toLong() }.sorted()
    val sc = java.util.Scanner(System.`in`)
    val n = readLine()!!.toInt()
    println(if(n<a.size) a[n] else -1)
}
*/