package BOJ_2021_03월

import java.lang.StringBuilder

/*
 지도를 입력하여 단지수를 출력하고, 각 단지에 속하는 집의 수를 오름차순으로 정렬하여 출력
*/

/*
fun main() {
    val n = readLine()!!.toInt()
    val arr = Array(n) { IntArray(n) }
    var count = 0

    for (i in 0 until n) {
        val s = readLine()!!
        for (j in 0 until n)
            arr[i][j] = s[j] - '0'
    }

    fun dfs(x: Int, y: Int) {
        val dx = intArrayOf(1, -1, 0, 0)
        val dy = intArrayOf(0, 0, 1, -1)
        arr[x][y] = 0
        count++
        for (i in 0..3) {
            val nx = x + dx[i]
            val ny = y + dy[i]
            if (nx in 0 until n && ny in 0 until n)
                if (arr[nx][ny] == 1)
                    dfs(nx, ny)
        }
    }

    var total = 0
    val pq = PriorityQueue<Int>()

    for (i in 0 until n)
        for (j in 0 until n)
            if (arr[i][j] == 1) {
                count = 0
                total++
                dfs(i, j)
                pq.add(count)
            }

    val sb = StringBuilder()

    sb.append("$total\n")

    while (!pq.isEmpty()) sb.append("${pq.poll()}\n")

    print(sb)
}
*/

fun main() {
    val n = readLine()!!.toInt()
    val array = Array(n) { BooleanArray(n) }
    val numbering = ArrayList<Int>()

    repeat(n) {
        array[it] = readLine()!!.map { c -> c == '1' }.toBooleanArray()
    }

    fun dfs(y: Int, x: Int): Int {
        if (y < 0 || x < 0 || y >= n || x >= n) return 0
        if (!array[y][x]) return 0

        array[y][x] = false
        return dfs(y, x + 1) + dfs(y + 1, x) + dfs(y, x - 1) + dfs(y - 1, x) + 1
    }

    for (i in 0 until n * n)
        if (array[i / n][i % n]) numbering.add(dfs(i / n, i % n))

    numbering.sort()
    val sb = StringBuilder()
    sb.append("${numbering.size}\n")
    for (complex in numbering) {
        sb.append("$complex\n")
    }
    print(sb)
}

/*
import java.util.Arrays

val isAlready = HashSet<String>()
lateinit var arr: Array<IntArray>

fun main(args : Array<String>){

	val result = ArrayList<Int>()

	val N = readLine()!!.toInt()
	arr = Array<IntArray>(N, {IntArray(N)})

	for(i in 0..(N-1)) {
		val input = readLine()!!
		for(j in 0..(input.length-1)) {
			arr[i][j] = input.substring(j, j+1).toInt()
		}
	}

	for(i in 0..(N-1)) {
		for(j in 0..(N-1)) {
			if(arr[i][j]==1 && !isAlready.contains("$i/$j")) {
				result.add(findDistrictSize(i, j))
			}
		}
	}

	println(result.size)
	result.sort()
	result.forEach{ println(it) }
}

fun findDistrictSize(y: Int, x: Int): Int {
	if(x<0 || y<0 || x>=arr.size || y>=arr.size ||
			arr[y][x] == 0 || isAlready.contains("$y/$x")) {
		return 0
	}
	isAlready.add("$y/$x")
	val result = 1 + findDistrictSize(y, x+1) + findDistrictSize(y+1, x) + findDistrictSize(y, x-1) + findDistrictSize(y-1, x)
	return result
}
*/