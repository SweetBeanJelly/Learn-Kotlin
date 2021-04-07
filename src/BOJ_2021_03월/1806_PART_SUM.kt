package BOJ_2021_03월

fun main() {
    val (N, S) = readLine()!!.split(" ").map{ it.toInt() }
    val num = readLine()!!.split(" ").map{ it.toInt() } + 1

    var (start, end) = 0 to 0
    var sum = 0
    var max = Integer.MAX_VALUE

    while(end <= N && start <= N) {
        if(sum >= S && max > end - start) max = end - start
        if(sum < S) sum += num[end++]
        else sum -= num[start++]
    }
    println(if (max == Int.Companion.MAX_VALUE) 0 else max)
}

/*
    val sc = java.util.Scanner(System.`in`)
    val (N,S)=IntArray(2){sc.nextInt()}//readLine()!!.split(" ").map{it.toInt()}
    val A =IntArray(N){sc.nextInt()}// readLine()!!.split(" ").map{it.toInt()}.toTypedArray()
    var j = 0
    var sum = 0
    var ans = N+1
    for(i in 0 until N) {
        while(j < N && sum < S) {
            sum += A[j]
            j += 1
        }
        if(sum >= S) {
            ans = Math.min(ans, j-i)
        }
        sum -= A[i]
    }
    println(if(ans > N) 0 else ans)
*/