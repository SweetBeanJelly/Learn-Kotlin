package BOJ_2021_04월

fun main() {
    val (N, K) = readLine()!!.split(" ").map { it.toInt() }
    val array = ArrayList<Int>()
    val plug = readLine()!!.split(" ").map { it.toInt() }
    var result = 0

    for (i in 0 until K) {
        if (array.contains(plug[i])) continue
        if (array.size < N) {
            array.add(plug[i])
            continue
        }
        val check = IntArray(N)
        for (j in 0 until N) check[j] = K

        for (j in 0 until N)
            for (k in i + 1 until K)
                if (plug[k] == array[j]) {
                    check[j] = k
                    break
                }

        var (temp, idx) = 0 to 0
        for (j in 0 until N)
            if (idx < check[j]) {
                idx = check[j]
                temp = j
            }

        array[temp] = plug[i]
        result++
    }
    println(result)
}

/*
fun main(args: Array<String>) {
  val (N, K) = readLine()!!.split(" ").map{ it.toInt() }
  val A = readLine()!!.split(" ").map{ it.toInt() }.toList()
  val cur = mutableSetOf<Int>()
  var ans = 0
  A.forEachIndexed { i, x ->
    if(x !in cur) {
      if(cur.size == N) {
        cur.remove(cur.maxBy{ v -> (i+1 until K).find{ A[it] == v } ?: K }!!)
        ans += 1
      }
      cur.add(x)
    }
  }
  println(ans)
}
*/