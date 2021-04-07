package BOJ_2021_02월

/*
 한수는 지금 (x, y)에 있다. 직사각형의 왼쪽 아래 꼭짓점은 (0, 0)에 있고, 오른쪽 위 꼭짓점은 (w, h)에 있다.
 사각형의 경계선까지 가는 거리의 최솟값을 구하기
*/

fun main() {
    val input = readLine()!!.split(" ").map { it.toInt() }
    // [0] = x, [1] = y, [2] = w, [3] = y
    val list = listOf(input[0] - 0, input[1] - 0, input[2] - input[0], input[3] - input[1])
    print(list.minByOrNull { it })
}