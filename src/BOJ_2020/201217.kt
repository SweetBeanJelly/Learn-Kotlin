package BOJ_2020

/*
 N-Queen
*/

/*
var array = intArrayOf()
var N = 0
var count = 0

fun main() {
    N = readLine()!!.toInt()
    array = IntArray(N)

    queen(0)
    println(count)
}

fun queen(depth: Int) {
    if(depth == N) {
        count++
        return
    }
    for(i in 0 until N) {
        array[depth] = i
        if(check(depth)) queen(depth + 1)
    }
}

fun check(col: Int): Boolean {
    for(i in 0 until col) {
        if(array[col] == array[i] || (abs(col - i) == (abs(array[col] - array[i]))))
            return false
    }
    return true
}
*/