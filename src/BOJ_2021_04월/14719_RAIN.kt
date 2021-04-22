package BOJ_2021_04월

fun main() {
    val (h, w) = readLine()!!.split(" ").map { it.toInt() }
    val array = readLine()!!.split(" ").map { it.toInt() }
    var sum = 0

    for(i in 0 until w) {
        var (r, l) = i to i
        for(j in i downTo 0)
            if(array[j] > array[l]) l = j
        for(j in i until w)
            if(array[j] > array[r]) r = j
        val temp = array[l].coerceAtMost(array[r]) - array[i]
        if(temp > 0) sum += temp
    }

    print(sum)
}