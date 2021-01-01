package sort
/*
모든 요소를 앞에서부터 차례대로
이미 정렬된 배열 부분과 비교하여 자신의 위치 삽입

장_속도 빠름
단_역순일 때 느림
 */
fun main() {
    var list = arrayOf(56,1,8,22,17,5,30,2)
    for(i in 1 until list.count()) {
        val temp = list[i]
        var j = i
        while (j > 0 && temp < list[j-1]) {
            list[j] = list[j-1]
            j--
        }
        list[j] = temp
        println("$i : ${list.toList()}")
    }
    println("결과 -> ${list.toList()}")
}