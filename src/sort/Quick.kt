package sort
/*
평균적으로 가장 빠름
pivot 값 세우고 이 값 기준으로 작으면 왼쪽, 크면 오른쪽으로 나눈다.
2개로 분할한 리스트에서 각 정렬 후 합침

분할 후 합치는 방식으로 divide and conquer 라고 부른다.
merge 와 다르게 리스트를 균등하지 않게 분할
*/
fun main() {

    val names = listOf("iOS", "web", "android", "kotlin", "java", "swift")

    val sort =  quick(names)
    println(sort)

}

fun <T: Comparable<T>> quick(items: List<T>): List<T> {

    if (items.count() < 2) {
        return items
    }

    val pivot = items[items.count()/2]
    val equal = items.filter { it == pivot }
    val less = items.filter { it < pivot }
    val greater = items.filter { it > pivot }

    return quick(less) + equal + quick(greater)
}