package BOJ02

/*
 자연수 M과 N
 M이상 N이하 자연수 중 소수인 것을 모두 골라 소수의 합, 최솟값 구하기
*/

fun main() {
    val (M, N) = readLine()!!.toInt() to readLine()!!.toInt()
    val array = ArrayList<Int>(2)

    for(i in M until N + 1)
        if(i == 2) array.add(i) else {
            for(j in 2 until i)
                if(i % j == 0) break
                else if(j == i - 1) array.add(i)
        }
    if(array.size == 0) print(-1)
    else {
        println(array.sum())
        println(array.minOrNull())
    }
}
