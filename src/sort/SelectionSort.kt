package sort
/*
주어진 리스트 중 최소값 찾음
맨 앞에 위치한 값과 교체, 나머지 같은 방법으로 교체

장_데이터 양 적을 때
단_속도 느림
*/
fun main() {
    var list = arrayOf(9,5,7,11,1,23,8)

    for(i in list.indices) {
        var min = i
        for(j in i+1 until list.size) if(list[min] > list[j]) min = j
        swap(list, i, min)
        println("${i+1} : ${list.toList()}")
    }
    println("결과 -> ${list.toList()}")
}

fun swap(array: Array<Int>,i: Int,j: Int) {
    var temp = array[i]
    array[i] = array[j]
    array[j] = temp
}