package BOJ_2021_02월

/*
 포도주 잔을 선택 시 그 잔의 포도주는 모두 마시며 마신 후 원래 위치에 놓는다.
 연속으로 3잔을 모두 마실 수는 없다.
 최대로 마실 수 있는 포도주 구하기
*/

fun main() {
    val N = readLine()!!.toInt()
    val wine = IntArray(N + 1)
    val dp = IntArray(N + 1) { i -> i }
    for(i in 1..N) wine[i] = readLine()!!.toInt()

    if(N == 1) dp[1] = wine[1]
    else {
        dp[1] = wine[1]
        dp[2] = wine[1] + wine[2]
    }
    for(i in 3..N) dp[i] = dp[i - 1].coerceAtLeast((dp[i - 2] + wine[i]).coerceAtLeast(dp[i - 3] + wine[i - 1] + wine[i]))
    print(dp[N])
}

/*
    val num = readLine()!!.toInt()

    val dp = mutableListOf(0, 0, 0)
    var prev = 0
    var now = 0
    for (i in 3..num + 2){
        now = readLine()!!.toInt()
        dp.add(maxOf(dp[i - 1], dp[i - 2] + now, dp[i - 3] + prev + now))
        prev = now
    }
    println(dp[num + 2])
*/

