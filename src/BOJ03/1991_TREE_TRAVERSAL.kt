package BOJ03

import java.util.HashMap
import java.util.ArrayList

// 이진 트리 전위, 중위, 후위

fun main() {
    val n = readLine()!!.toInt()
    val map = HashMap<String, List<String>>()

    for (i in 0 until n) {
        val tmp = readLine()!!.split("\\s".toRegex()).toTypedArray()
        val list: MutableList<String> = ArrayList()
        list.add(tmp[1])
        list.add(tmp[2])
        map[tmp[0]] = list
    }

    fun preorder(v: String) {
        if (v == ".") return
        print(v)
        preorder(map[v]!![0])
        preorder(map[v]!![1])
    }

    fun inorder(v: String) {
        if (v == ".") return
        inorder(map[v]!![0])
        print(v)
        inorder(map[v]!![1])
    }

    fun postorder(v: String) {
        if (v == ".") return
        postorder(map[v]!![0])
        postorder(map[v]!![1])
        print(v)
    }

    preorder("A")
    println()
    inorder("A")
    println()
    postorder("A")
}

/*
fun main(args:Array<String>) {
    val n = readLine()!!.toInt()
    val tree = Array<Pair<Int,Int>>(n){ Pair(-1, -1) }
    repeat(n) {
        val (x,l,r) = readLine()!!.split(" ").map{ it[0].toInt() - 65 }
        tree[x] = Pair(l, r)
    }
    fun f1(u: Int): String = if(u < 0 || u >= n) "" else f1(tree[u].first) + f1(tree[u].second) + (u+65).toChar().toString()
    fun f2(u: Int): String = if(u < 0 || u >= n) "" else f2(tree[u].first) + (u+65).toChar().toString() + f2(tree[u].second)
    fun f3(u: Int): String = if(u < 0 || u >= n) "" else (u+65).toChar().toString() + f3(tree[u].first) + f3(tree[u].second)
    println(f3(0))
    println(f2(0))
    println(f1(0))
}
*/