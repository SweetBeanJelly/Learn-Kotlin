
import java.lang.StringBuilder
import java.util.HashMap
import java.util.ArrayList

fun main() {
    fun solution(info: Array<String>, query: Array<String>): IntArray {
        val map: MutableMap<String, MutableList<Int>> = HashMap()
        for (z in info) {
            val split = z.split(" ".toRegex()).toTypedArray()
            val score = split[4].toInt()

            for (i in 0 until (1 shl 4)) {
                val key = StringBuilder()
                for (j in 0..3)
                    if (i and (1 shl j) > 0) key.append(split[j])
                map.computeIfAbsent(key.toString()) { ArrayList() }.add(score)
            }
        }
        for ((_, value) in map)
            value.sort()

        val answer = IntArray(query.size)
        for (i in query.indices) {
            val splits = query[i].replace("-", "").replace(" and ", "").split(" ")
            val key = splits[0]
            val score = splits[1].toInt()
            val list: List<Int> = map.getOrDefault(key, ArrayList())
            var start = 0
            var end = list.size
            while (start < end) {
                val mid = (start + end) / 2
                if (list[mid] < score) start = mid + 1 else end = mid
            }
            answer[i] = list.size - start
        }
        return answer
    }
}
/*
fun solution(info: Array<String>, query: Array<String>): IntArray {
        val hashMap = hashMapOf("java" to 0, "python" to 1, "cpp" to 2, "backend" to 0, "frontend" to 1, "junior" to 0, "senior" to 1, "pizza" to 0, "chicken" to 1)
        val idx = arrayOf(intArrayOf(0, 1, 2), intArrayOf(0, 1), intArrayOf(0, 1), intArrayOf(0, 1))
        val map = Array(3) {
            Array(2) {
                Array(2) {
                    Array(2) {
                        IntArray(100001)
                    }
                }
            }
        }
        fun search(str: List<String>, num: IntArray, index: Int): Int {
            var sum = 0
            fun operate(j: Int) {
                num[index] = j
                sum += search(str, num, index + 1)
            }
            return if (index == 4)
                map[num[0]][num[1]][num[2]][num[3]][str[4].toInt()]
            else {
                if (str[index] == "-") {
                    for (i in idx[index].indices)
                        operate(i)
                } else
                    hashMap[str[index]]?.let { operate(it) }
                sum
            }
        }
        for (i in info.indices) {
            info[i].split(" ").also { (a, b, c, d, e) ->
                map[hashMap[a]!!][hashMap[b]!!][hashMap[c]!!][hashMap[d]!!][e.toInt()]++
            }
        }
        for (i in 0..2) {
            for (j in 0..1) {
                for (k in 0..1) {
                    for (l in 0..1) {
                        var sum = 0

                        for (s in 100000 downTo 1) {
                            sum += map[i][j][k][l][s]
                            map[i][j][k][l][s] = sum
                        }
                    }
                }
            }
        }
        return mutableListOf<Int>().apply {
            for (i in query.indices) {
                query[i].replace("[0-9]|\\sand".toRegex(), "").trim().split(" ").also { (a, b, c, d) ->
                    add(search(listOf(a, b, c, d, query[i].replace("[^0-9]".toRegex(), "")), IntArray(4), 0))
                }
            }
        }.toIntArray()
}
*/