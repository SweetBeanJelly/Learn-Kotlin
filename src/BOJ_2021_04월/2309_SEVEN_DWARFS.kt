package BOJ_2021_04월

fun main() {
    val array = IntArray(9)
    array.forEachIndexed { index, _ ->
        array[index] = readLine()!!.toInt()
    }
    val sum = array.sum()
    array.sort()

    var check = false
    for(i in 0 until 9) {
        if(check) break
        for(j in 0 until 9) {
            if(i == j) continue
            if(sum - array[i] - array[j] == 100) {
                array[i] = 0
                array[j] = 0
                check = true
                break
            }
        }
    }

    for(i in 0 until 9)
        if(array[i] != 0) println(array[i])
}

/*
fun main(args: Array<String>) {
  val a = IntArray(9) { readLine() ?. toInt() ?: return }.sorted()
  for(i in 0 until 9) {
    for(j in 0 until i) {
      if(a.sum() - (a[i] + a[j]) == 100) {
        for(k in 0 until 9) {
          if(i != k && j != k) println(a[k])
        }
        return
      }
    }
  }
}
*/