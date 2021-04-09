package basic

fun main() {
    // filter
    val test1 = listOf(1, 2, 3, 4, 5, 12, 17, 20)
    println(test1.filter { it % 2 == 0 }) // 짝수
    data class test(val name: String, val age: Int)
    val test2 = listOf(test("감자", 11), test("고구마", 20))
    println(test2.filter { it.age > 18 }) // age = 18 이상

    // map -> 원하는 형태로 변환
    println(test2.map { it.name })
    println(test2.map { test::age })

    println(test1.asSequence().map { it * it }.filter { it % 2 == 0 }.toList())

    //
    val array1 = Array(10) { i -> i.toString() }
}