package BOJ_2021_02월

/*
 주어진 세변의 길이로 삼각형이 직각인지 아닌지 구분
*/

fun main() {
    while(true) {
        val array = readLine()!!.split(" ").map { it.toInt() }
        when {
            array[0] == 0 && array[1] == 0 && array[2] == 0 -> break
            array[0] * array[0] == array[1] * array[1] + array[2] * array[2] -> println("right")
            array[1] * array[1] == array[0] * array[0] + array[2] * array[2] -> println("right")
            array[2] * array[2] == array[0] * array[0] + array[1] * array[1] -> println("right")
            else -> println("wrong")
        }
    }
}

/*
fun main() {
    while(true) {
        val s=readLine()!!
        if(s=="0 0 0") break
        println(if(s.split(" ").map{it.toInt()}.run{sumBy{it*it}==2*max()!!*max()!!})"right" else "wrong")}
    }
*/