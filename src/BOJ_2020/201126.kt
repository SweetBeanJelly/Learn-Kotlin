package BOJ_2020

/*
 1. 셀프 넘버
 2. 한수 (1보다 크거나 같고, N보다 작거나 같은 한수의 개수) 출력. (완전탐색)
*/

fun main() {
    // 1
    /*
    var check = BooleanArray(10001)
    for(i in 1 until 100001) {
        var number = d(i)
        if(number < 10001) check[number] = true
    }

    for(j in 1 until 10001) {
        if(!check[j]) {
            println(j)
        }
    }
    */
    // 2
    /*
    var sc = Scanner(System.`in`)
    print(check(sc.nextInt()))
    sc.close()
    */
}

/*
fun d(number: Int): Int {
    var sum = number
    var n = number

    while(n != 0) {
        sum += (n % 10)
        n /= 10
    }

    return sum
}
*/

/*
fun check(number: Int): Int {
    var count = 0

    for(i in 1..number) {
        if(i < 100) {
            count++
        } else if(i < 1000) {
            var t = i % 10
            var o = (i / 10) % 10
            var h = (i / 100) % 10

            if(t - o == o - h) {
                count++
            }
        }
    }
    return count
}
*/