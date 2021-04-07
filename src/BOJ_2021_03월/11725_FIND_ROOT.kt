package BOJ_2021_03월

/*
 루트 없는 트리가 주어진다. 이때, 트리의 루트를 1이라고 정했을 때, 각 노드의 부모를 구하는 프로그램을 작성
*/

fun main() {
    val N = readLine()!!.toInt()
    val visit = BooleanArray(N + 1)
    val list = arrayOfNulls<ArrayList<Int>>(N + 1)
    val array = IntArray(N + 1)

    for(i in 1..N) list[i] = ArrayList()
    for(i in 1 until N) {
        val (a, b) = readLine()!!.split(" ").map { it.toInt() }
        list[a]!!.add(b)
        list[b]!!.add(a)
    }

    fun dfs(n: Int) {
        visit[n] = true
        for(i in list[n]!!)
            if(!visit[i]) {
                array[i] = n
                dfs(i)
            }
    }

    dfs(1)
    for(i in 2..N) println(array[i])
}

/*
fun main(args: Array<String>) {
  val n = readLine()!!.toInt()
  val gph = List(n+1) { mutableListOf<Int>() }
  repeat(n-1) {
    val (u, v) = readLine()!!.split(" ").map{ it.toInt() }
    gph[u].add(v)
    gph[v].add(u)
  }
  val par = IntArray(n+1)
  fun go(u: Int, p: Int) {
    par[u] = p
    for(v in gph[u].filter{ it != p }) go(v, u)
  }
  go(1, -1)
  println(par.toList().subList(2, n+1).joinToString("\n"))
}
*/