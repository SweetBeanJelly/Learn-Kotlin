package kakao.practice_level1

fun main(args: Array<String>) {
    val (a, b) = readLine()!!.split(' ').map(String::toInt)
    repeat(b) {
        for(i in 0 until a) print('*')
        println()
    }
    println(a + b)
}