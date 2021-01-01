package basic

fun main() {

    var sum_1 = sum(5, 8)
    var sum_2 = sum(2.8,3.5)
    var sum_3 = sum(1, 5 ,3)
    println("sum_1: $sum_1 , sum_2: $sum_2 , sum_3: $sum_3")

    // when ( JAVA -> switch-case )
    print("입력: ")
    var i:Int = readLine()!!.toInt()

    when (i) {
        1 -> println("입력 숫자는 1")
        2,3 -> println("입력 숫자는 2 혹은 3")
        in 4..7 -> println("입력 숫자는 4부터 7사이의 수")
        !in 8..10 -> println("입력 숫자는 8부터 10사이가 아니다")
        else -> {
            println("입력 숫자는 1이나 2가 아닌 다른 수")
        }
    }

    val number1 = 10
    val number2 = when (number1 % 2) {
        0 -> "짝수"
        else -> "홀수"
    }

    print(number2)

    // in..
    val array = arrayOf(1,2,3,4)
    for (n in array) {
        println(n)
    }

    for (m in 1..4) {
        println(m)
    }

    for (i in 0..10 step 2) {
        println(i)
    }

    for (j in 10 downTo 0 step 2) {
        print(j)
    }

    //
    val sum = Sum()
    println(sum.one(5,4,3))
    println(sum.two(8))

    var c = 'h'
    print(test_in(c))

    // while
    var hi = 5
    while (hi > 0) {
        hi --
        println("count $hi")
    }

    // do-while
    do {
        hi++
        println("count "+hi)

    } while(hi < 10)

    // break, continue
    var happy = 0
    while (happy < 10) {
        happy++
        if (happy == 8) break
        if (happy%2 == 0) continue
        println(happy)
    }

    // for
    happy@for (i in 0..5) {
        for (j in 0..5) {
            println("합 구하기 ${i+j}")
            if (i+j >= 4) break@happy
        }
    }
    for (i in 0 until 10) println(i)

}

// 반환값이 있는 함수
fun sum(a:Int, b:Int):Int {
    return a+b
}
// Overloading
fun sum(a:Double, b:Double):Double {
    return a+b
}
fun sum(a:Int, b:Int, c:Int):Int {
    return a+b+c
}

// in..
fun test_in(c:Char) = when (c) {
    in '0'..'9' -> "number !"
    in 'a'..'z', in 'A'..'Z' -> "letter !"
    else -> "error"
}

class Sum {
    fun one(a:Int, b:Int)=a+b
    fun two(a:Int, b:Int)=a-b
}

// Sum 클래스의 확장 함수
fun Sum.one(a:Int,b:Int,c:Int) = one(a,b)+c
fun Sum.two(a:Int) = -a