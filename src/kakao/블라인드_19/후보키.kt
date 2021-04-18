import java.util.HashSet
import java.util.ArrayList

fun main() {
    fun check(list: List<Int>, n: Int): Boolean {
        for (i in list.indices)
            if (list[i] and n == list[i]) return false
        return true
    }
    fun solution(relation: Array<Array<String>>): Int {
        val n = relation.size
        val m = relation[0].size
        val answer: MutableList<Int> = ArrayList()
        for (i in 1 until (1 shl m)) {
            val set: MutableSet<String> = HashSet()
            for (j in 0 until n) {
                val sb = StringBuilder()
                for (k in 0 until m)
                    if (i and (1 shl k) > 0) sb.append(relation[j][k])
                set.add(sb.toString())
            }
            if (set.size == n && check(answer, i)) answer.add(i)
        }
        return answer.size
    }
    val test = arrayOf(arrayOf("100","ryan","music","2"), arrayOf("200","apeach","math","2"), arrayOf("300","tube","computer","3"),arrayOf("400","con","computer","4"), arrayOf("500","muzi","music","3"), arrayOf("600","apeach","music","2"))
    print(solution(test))
}