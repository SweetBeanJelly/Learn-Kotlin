package BOJ_2021_02월

/*
 정수 N이 주어졌을 때, 소인수분해
*/

fun main() {
    var (N, M) = readLine()!!.toInt() to 2
    while (N != 1) {
        if(N % M == 0) {
            N /= M
            println(M)
        } else M += 1
    }
}