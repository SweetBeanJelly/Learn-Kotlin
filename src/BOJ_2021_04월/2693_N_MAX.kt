package BOJ_2021_04월

fun main() {
    repeat(readLine()!!.toInt()) {
        val array = readLine()!!.split(" ").map { it.toInt() }.sorted()
        println(array[7])
    }
}