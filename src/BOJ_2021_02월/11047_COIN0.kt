package BOJ_2021_02월

/*
 N 종류의 코인을 합쳐 K 로 만드려고한다. 이 때 필요한 동전 개수의 최솟값
*/

fun main() {
    var (N: Int, K: Int) = readLine()!!.split(" ").map { it.toInt() }
    val list = mutableListOf<Int>()

    repeat(N) {
        list.add(readLine()!!.toInt())
    }

    var count = 0
    for(i in list.reversed()) {
        if(K >= i) {
            repeat(K / i) {
                K -= i
                count++
            }
        }
        if(K == 0) break
    }
    print(count)
}