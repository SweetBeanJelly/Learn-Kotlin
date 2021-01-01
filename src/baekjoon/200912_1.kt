
fun main() {
    /*

    1. 두 수를 비교한 결과를 출력
    2. 시험 점수를 성적으로 바꾸는 문제
    3. 윤년을 판별하는 문제
    4. 점이 어느 사분면에 있는지 알아내는
    5. 시간 뺄셈 문제

    // 1

    var (i, j) = readLine()!!.split(" ").map(String::toInt)

    when {
        i > j -> print('>')
        i < j -> print('<')
        i == j -> print("==")
    }

    */
    // 2
    /*

    var num = readLine()!!.toInt()

    when(num) {
        in 90..100 -> print('A')
        in 80..89 -> print('B')
        in 70..79 -> print('C')
        in 60..69 -> print('D')
        else -> print('F')
    }

    */
    // 3
    /*

    var year = readLine()!!.toInt()

    if(year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) {
        print(1)
    } else print(0)

    */
    // 4
    /*

    var i:Int = readLine()!!.toInt()
    var j:Int = readLine()!!.toInt()

    if(i > 0 && j > 0) print(1)
    if(i < 0 && j > 0) print(2)
    if(i < 0 && j < 0) print(3)
    if(i > 0 && j < 0) print(4)

    */
    // 5
    /*
    현재 시간이 45분보다 크면 45분 뺀다.
    현재 시간이 45분보다 작다면 60분 빌려와서 계산. 시간은 -1
    0시일 경우 23시가 되어야 한다.

    var (hour, min) = readLine()!!.split(" ").map(String::toInt)

    min -= 45
    if(min < 0) {
        min += 60
        hour -= 1
        if(hour < 0) hour = 23
    }
    print("$hour $min")

    */
}