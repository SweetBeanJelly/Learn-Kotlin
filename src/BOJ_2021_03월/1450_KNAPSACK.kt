package BOJ_2021_03월

import java.util.ArrayList


fun main() {
    val (n, c) = readLine()!!.split(" ").map { it.toInt() }
    val arr = readLine()!!.split(" ").map { it.toInt() }

    val aSum = ArrayList<Int>()
    val bSum = ArrayList<Int>()

    var index = 0

    fun aBruteForce(i: Int, sum: Int) {
        if (sum > c) return
        if (i == n / 2) {
            aSum.add(sum)
            return
        }
        aBruteForce(i + 1, sum + arr[i])
        aBruteForce(i + 1, sum)
    }

    fun bBruteForce(i: Int, sum: Int) {
        if (sum > c) return
        if (i == n) {
            bSum.add(sum)
            return
        }
        bBruteForce(i + 1, sum + arr[i])
        bBruteForce(i + 1, sum)
    }

    fun binarySearch(start: Int, end: Int, num: Int) {
        if (start > end) return
        val mid = (start + end) / 2
        if (bSum[mid] + num <= c) {
            index = mid
            binarySearch(mid + 1, end, num)
        } else binarySearch(start, mid - 1, num)
    }

    aBruteForce(0, 0)
    bBruteForce(n / 2, 0)
    bSum.sort()

    var ans = 0
    for (i in 0 until aSum.size) {
        index = -1
        binarySearch(0, bSum.size - 1, aSum[i])
        ans += index + 1
    }

    println(ans.toString())
}

/*
fun main(args: Array<String>){
  val (N, C) = readLine()!!.split(" ").map{ it.toInt() }
  val A = readLine()!!.split(" ").map{ it.toInt() }.toList().sorted()

  val L = A.subList(0, N/2)
  val R = A.subList(N/2, N)

  val freq = mutableMapOf<Int, Int>()
  fun goL(i: Int, s: Int) {
    if(s > C) return
    if(i == L.size) {
      freq[s] = freq.getOrElse(s) { 0 } + 1
      return
    }
    goL(i+1, s)
    goL(i+1, Math.min(s+L[i], C+1))
  }
  goL(0, 0)

  val tb = java.util.TreeSet<Pair<Int,Int>>({ x, y -> (x.first - y.first) })
  freq.toSortedMap().forEach { (s, c) ->
    tb.add(Pair(s, c + (if(tb.isEmpty()) 0 else tb.last().second)))
  }

  fun goR(i: Int, s: Int): Int {
    if(s > C) return 0
    if(i == R.size) return tb.floor(Pair(C - s, 1e9.toInt()))?.second ?: 0
    return goR(i+1, s) + goR(i+1, Math.min(s+R[i], C+1))
  }

  println(goR(0, 0))
}
*/
