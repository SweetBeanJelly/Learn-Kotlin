import java.util.*

fun main() {
    /*

    1. 0 0이 들어올 때까지 A+B를 출력하는 문제
    2. 입력이 끝날 때까지 A+B를 출력하는 문제
    3. 원래 수로 돌아올 때까지 연산을 반복하는 문제

    */
    // 1
    /*

    while(true) {
        var (A, B) = readLine()!!.split(" ").map(String::toInt)
        if(A == 0 && B == 0) break
        println(A+B)
    }

    */
    // 2 EOF 에 대해 알아보자.
    /*

    var sc = Scanner(System.`in`)
    while(sc.hasNextInt()) {
        var A = sc.nextInt()
        var B = sc.nextInt()
        println(A+B)
    }
    sc.close()

    */

    // 3
    /*

    num 1의 자릿수는 새로운 수의 10의 자리.
    num 의 1 자릿수와 10 자릿수를 더한 값의 1 의 자릿수는 새로운 수의 1의 자리로 간다.
    만약 num 이 한 자릿수 정수라면 앞에 0 붙여 더함

    num 10 자릿수 나누기 10 하면 num 한자릿수 -> 0 그 외 -> 10 자릿수 그대로 반환
    num 1 자릿수는 나머지

    이 두개 더하고 10 나눈 나머지는 num 각 자릿수 합의 1 자릿수수

    var s = Scanner(System.`in`)
    var num = sc.nextInt()
    sc.close()

    var i = num
    var j = 0

    while (true) {
        num = ( ( num % 10) * 10) + ( ( ( num / 10) + ( num % 10 ) ) % 10)
        j++

        if(i == num) break
    }

    print(j)

     */
}