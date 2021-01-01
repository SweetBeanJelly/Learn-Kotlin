package sort

fun main() {

    val list = listOf(50,46,32,1,78)
    // 작은 값 부터 큰 값으로 정렬 (오름차순)
    println(list.sorted())
//    println("최소값 -> ${list[0]}")
//    println("최대값 -> ${list[list.size-1]}")
    // 큰 값 부터 작은 값으로 정렬 (내림차순)
    println(list.sortedDescending())

}
