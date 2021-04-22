package BOJ_2021_04월

fun main() {
    val array = IntArray(1001)
    var count = 0
    for(i in array.indices)
        for(j in 0 until i)
            if(count < 1000) array[count++] = i

    val (n1, n2) = readLine()!!.split(" ").map { it.toInt() }
    var sum = 0

    for(i in n1 - 1 until n2)
        sum += array[i]

    print(sum)
}

/*
fun main(args: Array<String>) = with(Scanner(System.`in`)) {
    val arr = Array(1001) { 0 }

    var x = 1
    loop@ for (i in 1..100) for (j in 0 until i) {
        arr[x] = i
        x++
        if (x == 1001) break@loop
    }

    println((nextInt()..nextInt()).sumBy { arr[it] })
}
*/