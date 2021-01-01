package basic

fun main() {
    // collection
    val list = arrayListOf("a", "bc", "def", "hello", "bye", "opqr", "stu", "hit")
    println(list.size)
    println(list.contains("bc"))
    println(list[3])
    println(list.get(2))
    println(list.indexOf("hello"))
    println(list.isEmpty())
    println(list.subList(0,3))

    var a = list.all { it.startsWith("b") }
    var b = list.any { it.startsWith("b")}
    print(a)
    print(b)

    var revers = list.asReversed()
    print(revers)

    var check = list.containsAll(listOf("a","bc"))
    print(check)

    var count = list.count { it.startsWith("b")}
    print(count)

    var f = list.drop(3)
    var l = list.dropLast(1)

    print("앞 제외 -> $f , 끝 제외 -> $l")

    var filter = list.filter { it.startsWith("b") }
    print(filter)
    var notfilter = list.filterNot { it.startsWith("b") }
    print(notfilter)

    var findf = list.find { it.startsWith("h") }
    var findl = list.findLast { it.startsWith("b") }

    print("첫 번째 $findf , 마지막 $findl")

    var foreach = list.forEach { print("$it ") }
    print(foreach)
    var forteachi = list.forEachIndexed { index, s -> print("$index = $s ") }
    print(forteachi)

    var maptest = list.map { it + "얍" }
    print(maptest)
    maptest = list.mapIndexed { index, s -> "$s = ${index*2}" }
    print(maptest)
}