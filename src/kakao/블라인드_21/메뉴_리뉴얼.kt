import java.util.Arrays
import kotlin.collections.ArrayList


fun main() {
    fun solution(orders: Array<String>, course: IntArray): ArrayList<String> {
        var map = HashMap<String, Int>()
        val answer = arrayListOf<String>()

        for (i in orders.indices) {
            val charArr = orders[i].toCharArray()
            Arrays.sort(charArr)
            orders[i] = String(charArr)
        }

        fun combi(str: String, sb: StringBuilder, idx: Int, cnt: Int, n: Int) {
            if (cnt == n) {
                map[sb.toString()] = map.getOrDefault(sb.toString(), 0) + 1
                return
            }

            for (i in idx until str.length) {
                sb.append(str[i])
                combi(str, sb, i + 1, cnt + 1, n)
                sb.delete(cnt, cnt + 1)
            }
        }

        for (i in course.indices) {
            map = HashMap()
            var max = Int.MIN_VALUE
            for (j in orders.indices) {
                val sb = StringBuilder()
                if (course[i] <= orders[j].length)
                    combi(orders[j], sb, 0, 0, course[i])
            }

            for ((_, value) in map) {
                max = max.coerceAtLeast(value)
            }
            for ((key, value) in map) {
                if (max >= 2 && value == max) answer.add(key)
            }
        }
        answer.sort()

        return answer
    }
}

/*
class Solution {
    fun solution(orders: Array<String>, course: IntArray): Array<String> {
        val candidateList = mutableListOf<String>()

    // r = 뽑을 갯수
    fun combination(list: List<Char>, r: Int, startIndex: Int = 0, candidates: String = ""): Unit = when (r) {
        0 -> {
            candidateList.add(candidates)
            Unit
        }
        else -> {
            for (i in startIndex until list.count()) {
                combination(list, r - 1, i + 1, candidates + list[i])
            }
        }
    }

    orders.forEach { order ->
        course.forEach { course ->
            combination(order.toList().sorted(), course)
        }
    }


    val answer = mutableListOf<String>()

    candidateList.groupingBy { it }.eachCount().toList().groupBy { it.first.length }.forEach { _, pair ->
        val maxCount = pair.maxBy { it.second }?.second ?: 0
        answer.addAll(pair.filter { it.second >= 2 && it.second == maxCount }.map { it.first })
    }
    return answer.sorted().toTypedArray()
    }
}
*/

/*
class Solution {

    var answerMap = TreeMap<String, Int>()
    var countMap = HashMap<Int, Int>()

    fun solution(orders: Array<String>, course: IntArray): Array<String> {
        var answer: MutableList<String> = ArrayList()

        orders.forEach { s ->
            var _a = s.split("").toTypedArray()
            _a.sort()
            setMenu(_a.joinToString("","",""), "", 0, course)
        }
        answerMap.forEach { k, v -> if (v > 1) if (countMap[k.length] == v) answer.add(k) }
        return answer.toTypedArray()
    }

    fun setMenu( menu: String, answer: String, index: Int, course: IntArray) {
        for (i in index until menu.length) {
            var _answer = answer+menu[i]
            if (course.indexOf(_answer.length) != -1) {
                answerMap.put(_answer, answerMap.getOrDefault(_answer, 0)+1)
                countMap.put(_answer.length, max(countMap.getOrDefault(_answer.length, 0),answerMap.get(_answer)!!) )
            }
            setMenu(menu, _answer, i+1, course)
        }
    }
}
*/

/*
fun solution(orders: Array<String>, course: IntArray): Array<String> {
        val answer = mutableListOf<String>()
        val courseMap = mutableMapOf<Int, MutableMap<String, Int>>()

        for(order in orders) {
            val menu = order.toCharArray().sortedArray()

            for(i in 0 until (1 shl menu.size)) {
                val com = StringBuilder()
                for(j in menu.indices) {
                    if((i and (1 shl j) != 0)) com.append(menu[j])
                }
                val key = com.toString()
                courseMap[key.length] = (courseMap[key.length] ?: mutableMapOf()).also { it[key] = (it[key] ?: 0) + 1 }
            }
        }

        for(count in course) {
            val max = courseMap[count]?.values?.max() ?: 0
            if(max < 2) continue

            courseMap[count]!!.entries.forEach { if(it.value == max) answer.add(it.key) }
        }

        answer.sort()
        return answer.toTypedArray()
}
*/