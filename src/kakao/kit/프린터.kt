package kakao.kit

// https://programmers.co.kr/learn/courses/30/lessons/42587

fun main() {
    fun solution(priorities: IntArray, location: Int): Int {
        var answer = 1
        var array = priorities.mapIndexed { i, num ->
            Pair(num, i == location)
        }

        go@while(array.isNotEmpty()) {
            val temp = array[0]
            val list = array.subList(1, array.size)

            array = when {
                list.any { it.first > temp.first } -> list + temp
                temp.second -> break@go
                else -> {
                    answer++
                    list
                }
            }
        }

        return answer
    }
    print(solution(intArrayOf(8,2,1,5,3), 2))
}