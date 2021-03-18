package BOJ03

import java.util.*
import kotlin.collections.ArrayList

/*
 트리의 지름을 구하는 프로그램을 작성
*/

fun main() {
    val N = readLine()!!.toInt()
    val tree = arrayOfNulls<ArrayList<IntArray>>(N + 1)
    val visit = BooleanArray(N + 1)

    repeat(N) {
        val str = StringTokenizer(readLine()!!)
        val a = str.nextToken().toInt()
        tree[a] = ArrayList()
        while(true) {
            val b = str.nextToken().toInt()
            if(b == -1) break
            val c = str.nextToken().toInt()
            tree[a]!!.add(intArrayOf(b, c))
        }
    }

    visit[1] = true
    var radius = 0

    fun diameter(n: Int): Int {
        var max = 0
        val arr = IntArray(tree[n]!!.size)
        for (i in 0 until tree[n]!!.size) {
            val node: IntArray = tree[n]!![i]
            if (!visit[node[0]]) {
                visit[node[0]] = true
                val d: Int = node[1] + diameter(node[0])
                arr[i] = d
                if (max < d) max = d
            }
        }
        if (tree[n]!!.size > 1) {
            Arrays.sort(arr)
            val temp = arr[arr.size - 1] + arr[arr.size - 2]
            if (radius < temp) radius = temp
        }
        if (radius < max) radius = max
        return max
    }

    diameter(1)
    println(radius)
}

/*
 fun main(args: Array<String>) {
  val V = readLine()!!.toInt()
  val gph = List(V+1) { mutableListOf<Pair<Int,Int>>() }
  repeat(V) {
    val tok = readLine()!!.split(" ").map{ it.toInt() }
    val u = tok[0]
    for(i in 1 until tok.size-1 step 2) {
      val v = tok[i]
      val c = tok[i+1]
      gph[u].add(Pair(v, c))
    }
  }

  val tb = LongArray(V+1) { 0 }

  fun go(u: Int, p: Int = -1) {
    for((v, c) in gph[u]) if(v != p) {
      tb[v] = tb[u] + c
      go(v, u)
    }
  }

  go(1)
  val u = (1..V).maxBy{ tb[it] }!!
  (1..V).forEach{ tb[it] = 0 }
  go(u)
  println(tb.max()!!)
}
*/