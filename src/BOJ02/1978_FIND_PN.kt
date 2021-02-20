package BOJ02

/*
 주어진 수 N개 중에서 소수가 몇 개인지 찾기
*/

fun main() {
    readLine()!!
    val result = readLine()!!.split(" ").map { it.toInt() }.count {
        var flag = true
        if(it == 1) flag = false
        else for(i in 2 until it) if(it % i == 0) flag = false
        flag
    }
    print(result)
}