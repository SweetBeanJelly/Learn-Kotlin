package search
/*
중간값 기준으로 반으로 나누어 비교
정렬된 배열에서 사용 가능
*/
fun main() {
    val list = listOf(1,2,3,4,5,6,7)
    println(list.binarySearch(3))
    println(list.binarySearch(2))

    println(list.binarySearch(0))
    println(list.binarySearch(10))
    /*
    주어진 값이 배열에 없다면 들어가야하는 위치를 리턴해줌
    */
}