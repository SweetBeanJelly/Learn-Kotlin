package graph

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

/*
너비 우선 탐색 BFS
넓이 우선 탐색 DFS
*/

var visited = booleanArrayOf()
var matrix: Array<IntArray> = arrayOf()
var input: List<Int> = listOf()

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    input = readLine().split(" ").map { it.toInt() } // 정점의 개수, 간선의 개수, 탐색 시작할 정점 번호
    matrix = Array(input[0]) { IntArray(input[0]) }
    visited = BooleanArray(input[0])

    repeat(input[1]) {
        val ab = readLine().split(" ").map { it.toInt() } // 간선이 연결하는 두 정점의 번호 (양방향)
        matrix[ab[0] - 1][ab[1] - 1] = 1
        matrix[ab[1] - 1][ab[0] - 1] = 1
    }

    println("\nDFS")
    visited.fill(false)
    depth(input[2] - 1)
    println("\nBFS")
    visited.fill(false)
    breadth(input[2] - 1)
}

fun breadth(number: Int) {
    val list: LinkedList<Int> = LinkedList()
    list.add(number)
    visited[number] = true
    print("${number + 1} ")

    while(list.isNotEmpty()) {
        val temp = list.poll()
        for(i in 0 until input[0]) {
            if(matrix[temp][i] == 1 && !visited[i]) {
                list.add(i)
                visited[i] = true
                print("${i + 1} ")
            }
        }
    }
}

fun depth(number: Int) {
    visited[number] = true
    print("${number + 1} ")

    for(i in 0 until input[0]) {
        if(matrix[number][i] == 1 && !visited[i]) depth(i)
    }
}