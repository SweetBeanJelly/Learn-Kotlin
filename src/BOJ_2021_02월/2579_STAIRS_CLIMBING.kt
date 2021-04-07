package BOJ_2021_02월

/*
 계단 오르기 게임에서 얻을 수 있는 총 점수의 최댓값 구하기
 1. 계단은 한 번에 한 계단, 두 계단씩 오를 수 있다.
 2. 연속된 세 개의 계단을 모두 밟아서는 안 된다. 단, 시작점은 계단에 포함되지 않는다.
 3. 마지막 도착 계단은 반드시 밟아야 한다.
*/

fun main() {
    val N = readLine()!!.toInt()
    val array = IntArray(301)
    val dp = IntArray(301)

    for (i in 0 until N) array[i] = readLine()!!.toInt()

    dp[0] = array[0]
    dp[1] = array[0].coerceAtLeast(array[0] + array[1])
    dp[2] = (array[1] + array[2]).coerceAtLeast(array[0] + array[2])

    for (i in 3 until N) dp[i] = (array[i] + dp[i - 2]).coerceAtLeast(array[i] + array[i - 1] + dp[i - 3])

    print(dp[N - 1])
}