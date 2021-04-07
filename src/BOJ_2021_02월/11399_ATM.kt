package BOJ_2021_02월

/*
 각 사람이 돈을 인출하는데 걸리는 시간 구하기.
*/

fun main() {
    var sum = 0
    var time = 0

    readLine()!!
    readLine()!!.split(" ").map{ it.toInt() }.sorted().forEach {
        time += it
        sum += time
    }
    print(sum)
}