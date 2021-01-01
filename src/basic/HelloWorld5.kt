package basic

import java.util.*

fun main() {

    // collection

    // list
    // 변경 X
    val food: List<String> = listOf("두끼", "응떡", "신전")
    val drug = listOf("텐텐", "게보린") // 자료형 생략 가능
    // 변경 O
    val name = mutableListOf("너구리", "여우", "팬더")
    println("1 LIST $name")
    name.add("오리") // 맨 뒤에 추가
    println("2 LIST $name")
    name.removeAt(0) // 너구리 삭제 (인덱스 값 제거)
    println("3 LIST $name")
    name[0] = "늑대" // 여우 변경 (인덱스 값 변경)
    println("4 LIST $name")

    val string_list = arrayListOf("Hello", ",", "World", "!")
    for (list in string_list) println(list)

    // map
    val map1 = mapOf("key1" to 1, "key2" to 2, "key3" to 3, "key4" to 2)
    val map2 = mutableMapOf('1' to "hello", '2' to "world", '3' to "!")

    map2['2'] = "move"

    for((key, value) in map2) {
        println("key[$key] -> value[$value]")
    }

    // key, value
    for ((index, value) in string_list.withIndex()) println("$index -> $value")

    val string_map = TreeMap<String, String>()
    string_map["name"] = "JinYeonGyeong"
    string_map["age"] = "25"
    string_map["email"] = "daum.net"

    for ((key, value) in string_map) println("$key -> $value")

    // set
    val weather = mutableSetOf("sun", "cloud", "rain")

    weather.add("Lightning")
    weather.remove("sun")
    println(weather.size)
    println(weather.contains("fog"))

    val test1 = mutableSetOf(7, 1, 3, 3, 5)
    println(test1)
    val test2 = hashSetOf(6, 4, 2, 1)
    println(test2)
}