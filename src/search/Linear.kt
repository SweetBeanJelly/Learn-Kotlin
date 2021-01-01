package search
/*
가장 왼쪽 부터 시작하여 찾으려는 값을 요소와 비교
찾으려는 값 발견 시 배열의 해당 인덱스 반환
실제로 거의 사용하지 않는다.
*/

fun main() {
    val list = listOf(9,6,0,7,2,3)
    println(linearSearch(list, 3))
    println(linearSearch(list, 10))
}

fun linearSearch(list: List<Any>, key: Any): String {

    for ((index, value) in list.withIndex()) {
        if (value == key){
            return "찾은 값의 위치 -> $index"
        }
    }

    return "값을 찾을 수 없음"
}
