package BOJ

/*
 1. 팩토리얼
 2. 피보나치 수 5
 3. 별찍기 10
 4. 하노이의 탑
*/

/*
var sb = StringBuilder()
var count = 0
*/

/*
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    // 1
    /*
    var input = readLine().toInt()
    var sum = 1

    while(input != 0) {
        sum *= input
        input--
    }

    print(sum)
    */
    /*
    var input = readLine().toInt()
    var sum = factorial(input)

    print(sum)
    */
    // 2
    /*
    var input = readLine().toInt()
    print(fibonacci(input))
    */
    // 3
    /*
    var input = readLine().toInt()


    for(n in 0 until input) {
        for(m in 0 until input) {
            star(n, m, input)
        }
        sb.append('\n')
    }
    print(sb)
    */
    // 4
    /*
    var input = readLine().toInt()
    hanoi(input, 1, 2, 3)
    println(count)
    print(sb)
    */
}
*/

/*
fun factorial(number: Int): Int {
    if(number <= 1) return 1
    return number * factorial(number - 1)
}
*/
/*
fun fibonacci(number: Int): Int {
    if(number <= 1) return number
    return fibonacci(number - 2) + fibonacci(number - 1)
}
*/
/*
fun star(i: Int, j: Int, k:Int) {
    if(i % 3 == 1 && j % 3 == 1) {
        sb.append(' ')
    } else if(k == 1) {
        sb.append('*')
    }
    else star(i / 3, j / 3, k / 3)
}
*/
/*
fun hanoi(number: Int, a: Int, b: Int, c: Int) {
    count += 1
    if(number == 1) {
        sb.append("$a $c\n")
        return
    } else {
        hanoi(number - 1, a, c, b) // 1 -> 2
        sb.append("$a $c\n") // 1 -> 3
        hanoi(number - 1, b, a, c) // 2 -> 3
    }
}
*/