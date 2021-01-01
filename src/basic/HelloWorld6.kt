package basic

fun main() {
    val sum = {i:Int, j:Int -> i+j}
    print(sum(5,5))

//    Sum(5,4)

    Sum(4) {it * it} // 매개 변수 이름 생략
    Sum(3) {a -> a * a}

    year { print("2020") }

    Sum(5,4,::plus)
    val minus: (Int, Int) -> Int = {a, b -> a - b}
}
fun Sum(a:Int, b:Int, s:(Int, Int) -> Int) {
    print("$a + $b = ${s(a,b)}")
}
fun Sum(a:Int, b:(Int) -> Int) {
    println("$a -> ${b(a)}")
}
fun year(n:()->Unit) {
    print("year : ")
    n()
}
fun plus(a:Int, b:Int) = a+b