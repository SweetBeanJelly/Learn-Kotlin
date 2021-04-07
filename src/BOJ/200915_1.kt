package BOJ

import java.util.*

/*
 1. 최솟값과 최댓값을 찾는 문제
 2. 최댓값이 어디에 있는지 찾는 문제
 3. 각 숫자가 몇 번 나왔는지 저장하기 위해 일차원 배열을 만드는 문제
 4. 서로 다른 나머지 값의 개수를 세는 문제 (중복 저장X)
 5. 평균 조작
*/

fun main() = with(Scanner(System.`in`)) {
    // 1
    /*
    val size = nextInt()
    val list = ArrayList<Int>(size)

    for (i in 0 until size) {
        val number = nextInt()
        list.add(number)
    }
    close()
    print("${list.min()} ${list.max()}")
    */
    // 2
    /*
    val list = ArrayList<Int>(9)
    for(i in 1..9) {
        val number = nextInt()
        list.add(number)
    }
    println(list.max())
    println(list.indexOf(list.max()) + 1)
    */
    // 3
    /*
    var result = (nextInt() * nextInt() * nextInt())
    var count = Array<Int>(10){0}
    close()

    while (result > 0) {
        count[result % 10] ++
        result /= 10
    }
    for(i in count) {
        println(i)
    }
    */
    // 4
    /*
    var h = HashSet<Int>()

    for (i in 0..9) {
        h.add(nextInt() % 42)
    }
    close()
    println(h.size)
    */
    // 5
    /*
    var array = DoubleArray(nextInt())

    for(i in array.indices) {
        array[i] = nextDouble()
    }
    close()

    var sum: Double = 0.0
    Arrays.sort(array)

    for(j in array.indices) {
        sum += ( ( array[j] / array[array.size-1] ) * 100 )
    }
    println(sum/array.size)
    */
}