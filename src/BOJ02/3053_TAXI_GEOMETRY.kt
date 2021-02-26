package BOJ02

/*
 택시 기하학.
 반지름 R이 주어졌을 때, 유클리드 기하학에서 원의 넓이와, 택시 기하학에서 원의 넓이를 구하기
*/

fun main() {
    val input = readLine()!!.toDouble()
    println(input * input * Math.PI)
    println(2 * input * input)
}