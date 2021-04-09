package BOJ_2021_04월

import java.util.*

fun main() {
    val (n, w, l) = readLine()!!.split(" ").map { it.toInt() }
    var (time, weight) = 0 to 0
    val truck = readLine()!!.split(" ").map { it.toInt() }

    val q = LinkedList<Int>()

    for(i in 0 until n)
        while(true) {
            if(q.isEmpty()) {
                q.offer(truck[i])
                time++
                weight += truck[i]
                break
            }
            else if(q.size == w) weight -= q.remove()
            else {
                if(weight + truck[i] > l) {
                    q.offer(0)
                    time++
                } else {
                    q.offer(truck[i])
                    time++
                    weight += truck[i]
                    break
                }
            }
        }
    print(time + w)
}

/*
  val (N, W, L) = readLine()!!.split(" ").map{ it.toInt() }
  val queue: java.util.Queue<Pair<Int, Int>> = java.util.ArrayDeque<Pair<Int,Int>>()

  var curTime = 1
  var curWeight = 0
  readLine()!!.split(" ").map{ it.toInt() }.forEach { a ->
    while(!queue.isEmpty() && queue.peek().first + W <= curTime) {
      curWeight -= queue.poll().second
    }
    while(queue.size >= W || curWeight + a > L) {
      val (t, v) = queue.poll()
      curTime = t + W
      curWeight -= v
    }
    queue.add(Pair(curTime, a))
    curTime += 1
    curWeight += a
  }

  while(!queue.isEmpty()) {
    curTime = queue.poll().first + W
  }

  println(curTime)
*/