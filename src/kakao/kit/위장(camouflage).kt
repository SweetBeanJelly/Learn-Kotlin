package kakao.kit

// https://programmers.co.kr/learn/courses/30/lessons/42578

fun main() {
    fun solution(clothes: Array<Array<String>>): Int {
        return clothes.groupBy { it[1] }.values.fold(1) {
            result, next -> result + (next.size + 1)
        } - 1
    }
    val test = arrayOf(arrayOf("yellowhat", "headgear"), arrayOf("bluesunglasses", "eyewear"), arrayOf("green_turban", "headgear"))
    print(solution(test))
}