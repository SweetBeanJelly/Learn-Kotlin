package kakao.인턴_19

fun main() {
    fun solution(s: String): IntArray {
        return Regex("[0-9,]+").findAll(s).map { it.value }.filter { it != "," }.toList()
            .map { it.split(",").map { i -> i.toInt() } }.sortedBy { it.size }
            .fold<List<Int>, Set<Int>>(setOf()) { it, list -> it.union(list) }.toIntArray()
    }
    print(solution("{{2},{2,1},{2,1,3},{2,1,3,4}}").joinToString())
}

/*
class Solution {
    fun solution(s: String): IntArray = arrayListOf<Int>().apply {
        s.split("{", "}", ",")
            .groupBy { it }
            .toList()
            .sortedByDescending { it.second.count() }
            .also {
                it.takeLast(it.size - 1)
                    .forEach { add(it.first.toInt()) }
            }
    }.toIntArray()
}
*/