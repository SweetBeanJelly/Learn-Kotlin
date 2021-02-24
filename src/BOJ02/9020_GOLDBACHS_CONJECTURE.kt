package BOJ02

/*
 골드바흐의 추측
*/

fun main() {
    val N = 10001
    val array = BooleanArray(N) { true }
    for(i in 2 until N)
        if(array[i]) for(j in 2 * i until N step i) array[j] = false
    val M = readLine()!!.toInt()
    repeat(M) {
        val number = readLine()!!.toInt()
        var index = 0
        while (true) {
            if(array[number / 2 - index] and array[number / 2 +  index]) {
                println("${number / 2 - index} ${number / 2 + index}")
                break
            }
            index++
        }
    }
}