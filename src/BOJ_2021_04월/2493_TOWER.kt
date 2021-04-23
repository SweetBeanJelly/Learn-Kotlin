package BOJ_2021_04월

import java.util.*

fun main() {
    val st = Stack<IntArray>()
    val n = readLine()!!.toInt()
    val stt = StringTokenizer(readLine()!!)

    for (i in 1..n) {
        val v = stt.nextToken().toInt()
        while (!st.isEmpty()) {
            if (st.peek()[1] >= v) {
                print(st.peek()[0].toString() + " ")
                break
            }
            st.pop()
        }
        if (st.isEmpty()) print("0 ")
        st.push(intArrayOf(i, v))
    }
}

/*
fun main(args:Array<String>) {
    val n = readLine()!!.toInt()
    val a = ("200000000 "+ readLine()!!).split(" ").map{it.toInt()}.toTypedArray()
    val stack = java.util.Stack<Int>()
    stack.push(0)
    println((1 .. n).map{ i ->
        while(a[stack.peek()] < a[i]) {
            stack.pop()
        }
        val j = stack.peek()
        stack.push(i)
        j
    }.joinToString(" "))
}
*/