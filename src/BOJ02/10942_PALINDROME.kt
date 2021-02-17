package BOJ02

/*
 자연수 N개와 질문 M개가 모두 주어졌을 때, 대답 구하기
*/

fun main() {
    val N = readLine()!!.toInt()
    val array = readLine()!!.split(" ").map { it.toInt() }.toIntArray()
    val dp = Array(N) { IntArray(N) {0} }

    for(i in 0 until N) {
        dp[i][i] = 1
        if(i < N - 1 && array[i] == array[i + 1]) dp[i][i + 1] = 1
    }

    for(i in 1 until N)
        for(j in 1 until i + 1)
            if(array[i] == array[i - j] && dp[i - j + 1][i - 1] == 1) dp[i - j][i] = 1

    val sb = StringBuilder()
    repeat(readLine()!!.toInt()) {
        val (a, b) = readLine()!!.split(" ").map { it.toInt() }
        sb.append(dp[a - 1][b - 1]).append("\n")
    }
    print(sb)
}

/*
fun main() {
    readLine()
    val array= readLine()!!.split(" ").map { it.toInt() }.toIntArray()
    val sb = StringBuilder()

    repeat(readLine()!!.toInt()) {
        val (a, b) = readLine()!!.split(" ").map { it.toInt() }
        val temp = array.copyOfRange(a - 1, b)

        if(temp.size == 1) sb.append("1\n")
        for(i in 0 until temp.size / 3) if(array[i] != array[temp.size - i - 1]) sb.append("0\n")
        else sb.append("1\n")
    }
    print(sb)
}
*/

/*
fun main() {
    val N = readLine()!!.toInt()
    val array = readLine()!!.split(" ").map { it.toInt() }.toIntArray()
    val dp = Array(N) { IntArray(N) {0} }

    for(i in 0 until N)
        for(start in 0 until N) {
            val end = start + i
            when {
                end >= N -> break
                start == end -> dp[start][end] = 1
                start + 1 == end -> {
                    if(array[start] == array[end]) dp[start][end] = 1
                    continue
                }
                array[start] == array[end] and dp[start + 1][end - 1] -> dp[start][end] = 1
            }
        }

    repeat(readLine()!!.toInt()) {
        val (a, b) = readLine()!!.split(" ").map { it.toInt() }
        println(dp[a - 1][b - 1])
    }
}

*/

/* 시간 초과
fun main() {
    readLine()
    val array= readLine()!!.split(" ").map { it.toInt() }.toIntArray()
    val sb = StringBuilder()

    fun palindrome(array: IntArray): Boolean {
        val number = array.size
        if(number == 1) return true
        for(i in 0 until number / 2)
            if(array[i] != array[number - i - 1]) return false
        return true
    }

    repeat(readLine()!!.toInt()) {
        val (a, b) = readLine()!!.split(" ").map { it.toInt() }
        val temp = array.copyOfRange(a - 1, b)

        if (palindrome(temp)) {
            sb.append("1\n")
        } else {
            sb.append("0\n")
        }
    }

    print(sb)
}
*/