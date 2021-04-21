package BOJ_2021_04월

fun main() {
    val n = readLine()!!

    for(i in n.indices) {
        print(n[i])
        if(i % 10 == 9) println()
    }
}