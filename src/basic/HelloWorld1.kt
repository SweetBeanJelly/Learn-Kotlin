package basic

fun main() {

    // 변수 var
    var a:Int = 10
    // 상수 val
    val b:Int = 20

    println("a는 변수 $a , b는 상수 $b")

    // 입력 함수 readLine() -> 어떤 입력이든 String Type
    print("이름 입력: ")
    var name = readLine()
    println(name)

    // 출력
    var content = 100
    println("가격은 "+content+"원 이다.")
    println("가격은 ${content}원 이다.")

    // Int, Double 합
    print("Int: ")
    var i:Int = readLine()!!.toInt()
    print("Double: ")
    var d:Double = readLine()!!.toDouble()
    print(i+d)

    // 한번에 여러 입력 받기
    print("변수 입력: ")
    var size:Int = readLine()!!.toInt()
    var array = Array<Int>(size) { readLine()!!.toInt() }
    var sum:Int = 0

    for (item in array) {
        println(array[item-1])
        sum += item
    }

    println("합 : $sum")

    printString()

}

// 단순 출력 함수
fun printString() {
    for (index in 1..3) {
        println(":^)")
    }
}