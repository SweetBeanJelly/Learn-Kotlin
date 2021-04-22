package BOJ_2021_04월

import java.util.*

fun main() {
    val (n, m) = readLine()!!.split(' ').map { it.toInt() }
    val list = Array(n + 1) { mutableListOf<Int>() }
    val array = Array(n + 1) {0}
    for(i in 1..m) {
        val (a, b) = readLine()!!.split(' ').map { it.toInt() }
        list[a].add(b)
        array[b]++
    }

    val q = LinkedList<Int>()
    for(i in 1..n)
        if(array[i] == 0)
            q.add(i)

    while(!q.isEmpty()){
        val answer = q.poll()
        print("$answer ")
        list[answer].forEach{
            if(--array[it] == 0)
                q.add(it)
        }
    }
}

/*
fun main(args:Array<String>){
    val (n,m)=readLine()!!.split(" ").map{it.toInt()}
    val gph=Array<MutableList<Int>>(n+1) { mutableListOf<Int>() }
    val indeg = IntArray(n+1) { 0 }
    repeat(m) {
        val (x,y)=readLine()!!.split(" ").map{it.toInt()}
        gph[x].add(y)
        indeg[y] += 1
    }
    val queue: java.util.Queue<Int> = java.util.ArrayDeque<Int>()
    (1..n).filter{ indeg[it] == 0 }.forEach{ queue.add(it) }
    println(IntArray(n) {
        val u = queue.remove()
        for(v in gph[u]) {
            indeg[v] -= 1
            if(indeg[v] == 0) queue.add(v)
        }
        u
    }.joinToString(" "))
}
*/