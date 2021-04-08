package BOJ_2020

/*
    1. 구구단 출력
    2. A+B를 여러 번 출력하는 문제
    3. 1부터 N 까지의 합
    5. 1부터 N까지 출력하는 문제
    6. N부터 1까지 출력하는 문제
    9. 별 찍기
    10. 오른쪽 부터 별 찍기
*/

fun main() {
    // 1
    /*
    var num = readLine()!!.toInt()

    for(i in 1..9) {
        println("$num * $i = ${num*i}")
    }
    */
    // 2
    /*
    var num = readLine()!!.toInt()
    for(i in 1..num) {
        var (A, B) = readLine()!!.split(" ").map(String::toInt)
        println(A+B)
    }
    */
    // 3
    /*
    var num = readLine()!!.toInt()
    var sum: Int = 0
    for(i in 1..num) {
        sum += i
    }
    print(sum)
    */
    // 5
    /*
    var num = readLine()!!.toInt()
    for(i in 1..num) {
        println(i)
    }
    */
    // 6
    /*
    var num = readLine()!!.toInt()
    for(i in num downTo 1) {
        println(i)
    }
    */
    // 9
    /*
    var star = Scanner(System.`in`)
    for(i in 1..star.nextInt()) {
        println("${"*".repeat(i)}")
    }
    */
    // 10
    /*
    var n = readLine()!!.toInt()

    for(i in 1..n) {
        for(j in 1..n-i)
            print(" ")
        for(s in 0 until i) {
            print("*")
        }
        println()
    }
    */
}
