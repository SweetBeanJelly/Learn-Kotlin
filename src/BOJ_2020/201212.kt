package BOJ_2020

/*
 1. 통계학
 2. 소트인사이드
*/

fun main() {
    // 1
    /*
    val number = readLine()!!.toInt()
    val list = emptyList<Int>().toMutableList()

    for(i in 0 until number) {
        list.add(readLine()!!.toInt())
    }

    list.sort()

    var sum = 0.0

    list.forEach { sum+= it.toDouble()}
    sum/=(number.toDouble())

    println(sum.roundToInt()) // 평균
    println(list[(list.size)/2]) // 중앙
    val group = list.groupBy { it }
    val max = (group.values.maxBy{ it.size })!!.size
    val new = group.filter{it.value.size == max }.values.map{it[0]}.sorted()
    val freq = if(new.size > 1) new[1] else new[0]
    println(freq) // 최빈
    println(list.max()!!.toInt() - list.min()!!.toInt()) // 범위
    */
    // 2
    /*
    var str = readLine()!!

    for(i in 9 downTo 0) {
        for(j in str.indices) {
            if(str[j].toString().toInt() == i) print(i)
        }
    }
    */
}