package BOJ_2021_04월

fun main() {
    repeat(readLine()!!.toInt()) {
        val n = readLine()!!.toInt().toString(2)
        println(n)
        for(i in n.length - 1 downTo 0)
            if(n[i] == '1') print("${n.length - i - 1} ")
    }
}