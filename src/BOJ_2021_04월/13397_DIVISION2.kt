package BOJ_2021_04월

fun main() {
    val (N, M) = readLine()!!.split(" ").map { it.toInt() }
    val arr = readLine()!!.split(" ").map { it.toInt() }
    var answer = Int.MAX_VALUE

    fun go(num: Int): Boolean {
        var count = 0
        var max = Int.MIN_VALUE
        var min = Int.MAX_VALUE
        for (element in arr) {
            val tmpMax = max.coerceAtLeast(element)
            val tmpMin = min.coerceAtMost(element)
            if (tmpMax - tmpMin <= num) {
                max = tmpMax
                min = tmpMin
            } else {
                count++
                max = element
                min = element
            }
        }
        return count + 1 <= M
    }

    var left = 0
    var right = arr.maxOrNull()!!

    while (left <= right) {
        val mid = (left + right) / 2
        if (go(mid)) {
            answer = answer.coerceAtMost(mid)
            right = mid - 1
        } else left = mid + 1
    }

    print(answer)
}

/*
fun go(low: Int, high: Int): Int {
    if(low > high) return 987654
    val mid = (low + high) / 2
    if(run {
      var i = 0
      var c = 0
      while(i < N) {
        var j = i
        var mn = 1987654321
        var mx = -1
        while(j < N) {
          if(A[j] < mn) mn = A[j]
          if(A[j] > mx) mx = A[j]
          if(mx - mn > mid) break
          j += 1
        }
        i = j
          c += 1
      }
      c
    } <= M) {
      return Math.min(go(low, mid-1), mid)
    }else {
      return go(mid+1, high)
    }
  }

println(go(0, 10000))
*/