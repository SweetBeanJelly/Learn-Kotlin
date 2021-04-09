package kakao.kit

// https://programmers.co.kr/learn/courses/30/lessons/42579

fun main() {
    fun solution(genres: Array<String>, plays: IntArray): IntArray {
        return genres.indices
            .groupBy { genres[it] }
            .toList()
            .sortedByDescending { it.second.sumBy { plays[it] } }
            .map { it.second.sortedByDescending { plays[it] }.take(2) }
            .flatten().toList().toIntArray()
    }
    print(solution(arrayOf("classic", "pop", "classic", "classic", "pop"), intArrayOf(500, 600, 150, 800, 2500)).toList())
}