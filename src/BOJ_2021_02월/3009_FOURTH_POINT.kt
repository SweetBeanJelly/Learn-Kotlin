package BOJ_2021_02월

/*
 축에 평행한 직사각형을 만들기 위해서 필요한 네 번째 점을 찾기
*/

fun main() {
    val x = IntArray(3)
    val y = IntArray(3)

    repeat(3) {
        val str = readLine()!!.split(" ")
        x[it] = str[0].toInt()
        y[it] = str[1].toInt()
    }

    val xt = if (x[1] == x[2]) x[0] else if (x[0] == x[1]) x[2] else x[1]
    val yt = if (y[1] == y[2]) y[0] else if (y[0] == y[1]) y[2] else y[1]

    print("$xt $yt")
}

/* Scanner 컴파일 에러
fun main() = with(Scanner(System.`in`)) {
    val x = IntArray(1001)
    val y = IntArray(1001)

    repeat(3) {
        x[nextInt()]++
        y[nextInt()]++
    }

    var (xt, yt) = 0 to 0

    for(i in 1 until 1001) {
        if(x[i] % 2 == 1) xt = i
        if(y[i] % 2 == 1) yt = i
    }

    print("$xt $yt")
}
*/