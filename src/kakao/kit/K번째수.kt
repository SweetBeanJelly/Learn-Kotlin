package kakao.kit

// https://programmers.co.kr/learn/courses/30/lessons/42748

fun main() {
//    fun solution(array: IntArray, commands: Array<IntArray>): IntArray =
//        commands.map { array.sliceArray((it[0] - 1) until it[1]).apply { sort() } [it[2] - 1]}.toIntArray()
    fun solution(array: IntArray, commands: Array<IntArray>): IntArray {
        return commands.map {
            array.slice((it[0] - 1) until it[1]).sorted()[it[2] - 1]
        }.toIntArray()
    }
    val test1 = intArrayOf(1,5,2,6,3,7,4)
    val test2 = arrayOf(intArrayOf(2,5,3), intArrayOf(4,4,1), intArrayOf(1,7,3))
    print(solution(test1, test2).toList())
}