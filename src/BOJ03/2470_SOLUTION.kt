package BOJ03

import kotlin.math.abs

fun main() {
    readLine()
    val array = readLine()!!.split(" ").map { it.toInt() }.toIntArray().sorted()

    var min = array[0] + array[array.size - 1]

    var (start, end) = 0 to array.size - 1
    var (mins, maxe) = start to end

    while(start < end) {
        val sum = array[start] + array[end]
        if(abs(sum) < abs(min)) {
            mins = start
            maxe = end
            min = sum
        }
        if(sum < 0 ) start++ else end--
    }
    println("${array[mins]} ${array[maxe]}")
}

/*
fun main(args: Array<String>) {
  val N = readLine()!!.toInt()
  val A = readLine()!!.split(" ").map{ it.toInt() }.sorted()

  var ans = Triple(Math.abs(A[0] + A[1]), A[0], A[1])

  for(a in A) {
    val i = Math.abs(A.binarySearch(-a))
    for(j in i-2..i+2) if(j in 0 until N && A[j] != a) {
      val cand = Triple(Math.abs(a + A[j]), Math.min(a, A[j]), Math.max(a, A[j]))
      if(cand.first < ans.first) ans = cand
    }
  }

  println("${ans.second} ${ans.third}")
}
*/