package BOJ_2021_04월

import kotlin.math.max

fun main() {
    var (n, k) = readLine()!!.split(" ").map { it.toInt() }
    val array = Array(n) {""}
    val flag = BooleanArray(26)
    var sum = 0

    fun go(a: Int, b: Int) {
        if (b == k) {
            var t = 0
            for (i in 0 until n) {
                var check = true
                for (j in array[i].indices)
                    if (!flag[array[i][j] - 'a']) {
                        check = false
                        break
                    }
                if (check) t++
            }
            sum = max(sum, t)
            return
        }
        for (i in a..25) {
            if (!flag[i]) {
                flag[i] = true
                go(i, b + 1)
                flag[i] = false
            }
        }
    }

    when {
        k < 5 -> {
            println(0)
            return
        }
        k == 26 -> {
            println(n)
            return
        }
        else -> {

            flag['a' - 'a'] = true
            flag['n' - 'a'] = true
            flag['t' - 'a'] = true
            flag['i' - 'a'] = true
            flag['c' - 'a'] = true

            for(i in 0 until n) {
                val s = readLine()!!
                array[i] = s.substring(4, s.length - 4)
            }

            k -= 5

            go(0,0)
            println(sum)
        }
    }
}

/*
fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val (n, k) = br.readLine().split(" ").map(String::toInt)
    val words = mutableListOf<String>()
    val using = BooleanArray(26) { false }
    "antic".forEach { using[it - 'a'] = true }
    repeat(n) { words.add(br.readLine()) }
    var answer = 0
    fun search(cnt: Int, cur: Int) {
        if (cnt == k - 5) {
            var count = 0
            repeat(n) {
                var valid = true
                words[it].forEach { word -> if (!using[word - 'a']) valid = false }
                if (valid) count++
            }
            answer = answer.coerceAtLeast(count)
            return
        }
        for (index in cur until 26) {
            if (using[index]) continue
            using[index] = true
            search(cnt + 1, index + 1)
            using[index] = false
        }
    }
    if (k - 5 >= 0) search(0, 0)
    bw.write("$answer")
    bw.close()
}
*/