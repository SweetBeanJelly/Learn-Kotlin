import java.util.PriorityQueue

fun main() {
    /*
    class Food(var number: Int, var amount: Int)

    fun solution(food_times: IntArray, k: Long): Int {
        val list = LinkedList<Food>()
        var n: Int = food_times.size
        var tmp = k

        for (i in 0 until n) list.add(Food(i + 1, food_times[i]))

        list.sortWith { f0, f1 -> f0.amount.compareTo(f1.amount) }

        var time = 0

        for ((index, f) in list.withIndex()) {
            val diff = (f.amount - time).toLong()
            if (diff != 0L) {
                val spend = diff * n
                if (spend <= tmp) {
                    tmp -= spend
                    time = f.amount
                } else {
                    tmp %= n
                    list.subList(index, food_times.size).sortWith { o1, o2 -> o1.number - o2.number }
                    return list[index + tmp.toInt()].number
                }
            }
            n--
        }
        return -1
    }
    */
    fun solution(food_times: IntArray, k: Long): Int {
        var answer = -1
        var k = k
        val q = PriorityQueue<IntArray> { arg0, arg1 -> arg0[0].compareTo(arg1[0]) }

        for (i in food_times.indices) q.add(intArrayOf(food_times[i], i))

        var ctime: Long = 0
        loop@ while (!q.isEmpty()) {
            val cur = q.peek()
            val stime = (cur[0] - ctime) * q.size
            if (k < stime) {
                k %= q.size
                k++
                var count = 0
                for (i in food_times.indices) {
                    if (food_times[i] != 0) {
                        count++
                        if (count.toLong() == k) {
                            answer = i + 1
                            break@loop
                        }
                    }
                }
            } else {
                k -= stime
                food_times[cur[1]] = 0
                ctime = cur[0].toLong()
                q.poll()
            }
        }
        return answer
    }

    val test = intArrayOf(3,1,2)
    print(solution(test, 5))
}

/*
    fun solution(food_times: IntArray, k: Long): Int {
        var(cnt,foodLeft,cum)=Triple<Long,Int,Int>(k,food_times.size,0)
        val st = (0 until foodLeft).toHashSet()
        food_times.mapIndexed { index, i -> Pair(i, index) }
                .groupBy { it.first }
                .toSortedMap()
                .forEach {
                    if (cnt < foodLeft.toLong() * (it.key-cum)) {
                        return st.sorted().toList()[(cnt % foodLeft).toInt()] + 1
                    } else {
                        cnt -= foodLeft * (it.key-cum)
                        foodLeft -= it.value.size
                        it.value.forEach { st.remove(it.second) }
                        cum = it.key
                    }
                }
        return -1
    }
*/
/*
    fun solution(food_times: IntArray, k: Long): Int {
        val queue = LinkedList(food_times.indices.groupBy { food_times[it] }.toSortedMap().toList())
        var time = 0L
        var remaining = food_times.size
        var prev = 0

        while (queue.isNotEmpty()) {
            val currentFood = queue.peekFirst()
            val next = time + (currentFood.first - prev).toLong() * remaining.toLong()
            if (next > k) break
            time = next
            remaining -= currentFood.second.size
            prev = currentFood.first
            queue.removeFirst()
        }

        return if (queue.isEmpty()) -1
        else ArrayList<Int>().apply { queue.forEach { times -> times.second.forEach { add(it + 1) } } }.sorted()[((k - time) % remaining).toInt()]
    }
*/