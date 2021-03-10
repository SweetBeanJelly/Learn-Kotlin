package BOJ03

import java.util.*
import java.util.ArrayList

/*
 그래프가 입력으로 주어졌을 때, 이 그래프가 이분 그래프인지 아닌지 판별
*/

fun main() {
    val sc = Scanner(System.`in`)
    var t = sc.nextInt()
    while (t-- > 0) {
        val n = sc.nextInt()
        val e = sc.nextInt()
        val d = arrayOfNulls<ArrayList<Int>>(n + 1)
        val check = IntArray(n + 1)
        var rt = false
        for (i in 1..n) d[i] = ArrayList()
        for (i in 0 until e) {
            val u = sc.nextInt()
            val v = sc.nextInt()
            d[u]!!.add(v)
            d[v]!!.add(u)
        }

        fun dfs(d: Array<ArrayList<Int>?>, c: IntArray, x: Int, cnt: Int): Boolean {
            c[x] = cnt
            for (i in d[x]!!)
                if (c[i] == 0)
                    if (!dfs(d, c, i, 3 - cnt))
                        return false
            return true
        }

        for (i in 1..n)
            if (check[i] == 0)
                rt = dfs(d, check, i, 1)

        for (i in 1..n)
            for (x in d[i]!!)
                if (check[i] == check[x])
                    rt = false

        println(if (rt) "YES" else "NO")
    }
}

/*
repeat(readLine()!!.toInt()) {
    val (V, E) = readLine()!!.split(" ").map{ it.toInt() }
    val gph = List(V+1) { mutableListOf<Int>() }
    repeat(E) {
      val (u, v) = readLine()!!.split(" ").map{ it.toInt() }
      gph[u].add(v)
      gph[v].add(u)
    }

    val chk = Array(V+1) { false }
    val color = Array(V+1) { false }

    fun go(u: Int): Boolean {
      chk[u] = true
      for(v in gph[u]) {
        if(chk[v]) {
          if(color[u] == color[v]) return false
        }else {
          color[v] = !color[u]
          if(!go(v)) return false
        }
      }
      return true
    }

    var ans = true

    for(u in 1 .. V) {
      if(!chk[u]) {
        ans = ans && go(u)
      }
    }

    println(if(ans) "YES" else "NO")
  }
*/
