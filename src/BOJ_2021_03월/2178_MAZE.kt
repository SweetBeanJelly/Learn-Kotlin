package BOJ_2021_03월

import java.util.*

/*
 N×M크기의 배열로 표현되는 미로
*/

fun main() {
    val (N, M) = readLine()!!.split(" ").map { it.toInt() }
    val array = Array(N) { IntArray(M) }.map { readLine()!!.map { it.toInt() - 48 }.toIntArray()}.toTypedArray()
    val flag = Array(N) { BooleanArray(M) {false} }

    fun bfs(x: Int, y: Int) {
        val dx = intArrayOf(1, -1, 0, 0)
        val dy = intArrayOf(0, 0, -1, 1)
        val list = LinkedList<data>()

        list.add(data(x, y))
        while(list.isNotEmpty()) {
            val r = list.poll()
            for(i in 0 until 4) {
                val nx = r.x + dx[i]
                val ny = r.y + dy[i]

                if(nx !in 0 until N || ny !in 0 until M) continue
                if(array[nx][ny] == 0 || flag[nx][ny]) continue

                list.add(data(nx, ny))
                array[nx][ny] = array[r.x][r.y] + 1
                flag[nx][ny] = true
            }
        }
    }

    flag[0][0] = true
    bfs(0, 0)
    println(array[N - 1][M - 1])
}

data class data(val x: Int, val y: Int)

/*
fun main(args: Array<String>) {
  val (N, M) = readLine()?. split(" ") ?. map { it.toInt() } ?: return
  val A = (0 until N).map{ readLine()?. toCharArray() ?. map { it == '1' } ?: return }

  val d = Array< IntArray > (N) { IntArray(M) { -1 } }

  val que: Queue< Pair<Int, Int> > = ArrayDeque< Pair<Int, Int> >()
  que.add( Pair(0, 0) )
  d[0][0] = 1
  while(!que.isEmpty()) {
    val (x, y) = que.remove()
    for((nx, ny) in arrayOf< Pair<Int, Int> >(Pair(x, y-1), Pair(x, y+1), Pair(x-1, y), Pair(x+1, y))) {
      if(0 <= nx && nx < N && 0 <= ny && ny < M && A[nx][ny] && d[nx][ny] == -1) {
        d[nx][ny] = d[x][y] + 1
        que.add( Pair(nx, ny) )
      }
    }
  }
  println(d[N-1][M-1])
}
*/