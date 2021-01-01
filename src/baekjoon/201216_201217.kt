package baekjoon

import java.lang.StringBuilder
import java.util.*

/*
 백트래킹
 1. N 과 M (1)
 2. N 과 M (2)
 3. N 과 M (3)
 4. N 과 M (4)
 */

// 1
/*
var array = intArrayOf()
var visited = booleanArrayOf()
var sb = StringBuilder()
*/
// 2
/*
var array = intArrayOf()
var N = 0
var M = 0
var sb = StringBuilder()
*/
// 3
/*
var array = intArrayOf()
var N = 0
var M = 0
var sb = StringBuilder()
*/
// 4
/*
var array = intArrayOf()
var N = 0
var M = 0
var sb = StringBuilder()
*/
fun main() {
    // 1
    /*
    var str = StringTokenizer(readLine()!!)

    val n = str.nextToken().toInt()
    val m = str.nextToken().toInt()

    array = IntArray(m)
    visited = BooleanArray(n)

    dfs(n, m, 0)
    print(sb)
    */
    // 2
    /*
    var str = StringTokenizer(readLine()!!)

    N = str.nextToken().toInt()
    M = str.nextToken().toInt()

    array = IntArray(M)
    dfs(1, 0)
    print(sb)
    */
    // 3
    /*
    var str = StringTokenizer(readLine()!!)

    N = str.nextToken().toInt()
    M = str.nextToken().toInt()

    array = IntArray(M)
    dfs(0)
    print(sb)
    */
    // 4
    /*
    var str = StringTokenizer(readLine()!!)

    N = str.nextToken().toInt()
    M = str.nextToken().toInt()

    array = IntArray(M)
    dfs(1, 0)
    print(sb)
    */
}
// 1
/*
fun dfs(N: Int, M: Int, depth: Int) {
    if(depth == M) {
        for(i in array) sb.append("$i ")
        sb.append('\n')
        return
    }
    for(j in 0 until N) {
        if(!visited[j]) {
            visited[j] = true
            array[depth] = j + 1
            dfs(N, M, depth + 1)
            visited[j] = false
        }
    }
}
*/
// 2
/*
fun dfs(number: Int, depth: Int) {
    if(depth == M) {
        for(i in array) sb.append("$i ")
        sb.append('\n')
        return
    }
    for(j in number..N) {
        array[depth] = j
        dfs(j + 1, depth + 1)
    }
}
*/
// 3
/*
fun dfs(depth: Int) {
    if(depth == M) {
        for(i in 0 until M) sb.append("${array[i]} ")
        sb.append('\n')
        return
    }
    for(j in 1..N) {
        array[depth] = j
        dfs(depth + 1)
    }
}
*/
// 4
/*
fun dfs(number: Int, depth: Int) {
    if(depth == M) {
        for(i in array) sb.append("$i ")
        sb.append('\n')
        return
    }
    for(j in number..N) {
        array[depth] = j
        dfs(j, depth + 1)
    }
}
*/