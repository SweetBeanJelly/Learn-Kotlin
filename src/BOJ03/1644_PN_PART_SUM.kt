package BOJ03

fun main() {
    val N = readLine()!!.toInt()
    val array1 = BooleanArray(4000001)
    val array2 = IntArray(2000001)
    for(i in 2..N) {
        if(array1[i]) continue
        var j = 2 * i
        while (j <= N) {
            array1[j] = true
            j += i
        }
    }
    var (p, sum) = 0 to 0
    var (m, l) = 0 to 0
    var result = 0
    for(i in 2..N)
        if(!array1[i]) array2[p++] = i
    while(true) {
        if(sum >= N) sum -= array2[l++]
        else if(m == p) break
        else sum += array2[m++]
        if(sum == N) result++
    }

    print(result)
}