package BOJ_2021_04월

fun main() {
    val (n, k) = readLine()!!.split(" ").map { it.toInt() }
    var count = 0


    for(i in 1..n) {
        if(n % i == 0) count++
        if(count == k) {
            print(i)
            break
        }
    }

    if(count < k) print(0)
}

/*
    val (n, k) = readLine()!!.split(" ").map { it.toInt() }
    val a = (1 .. n).filter { n % it == 0 }.toTypedArray()
    println(if(k <= a.size) a[k-1] else 0)
*/