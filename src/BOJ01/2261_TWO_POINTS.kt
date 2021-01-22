package BOJ01

import java.awt.Point
import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder
import java.util.*

/*
 2차원 평면상의 n개의 점들 중 가장 가까운 두 점 구하기
*/

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val number = readLine().toInt()
    val array = ArrayList<Point>()
    for (i in 0 until number) {
        val str = StringTokenizer(readLine())
        array.add(Point(str.nextToken().toInt(), str.nextToken().toInt()))
    }
    array.sortWith { p, q -> p.x - q.x }

    val sb = StringBuilder()
    sb.append("${getResult(array, 0, number - 1)}\n")
    print(sb)
}

fun dist(p: Point, q: Point): Int {
    return (p.x - q.x) * (p.x - q.x) + (p.y - q.y) * (p.y - q.y)
}

fun bruteForce(array: ArrayList<Point>, start: Int, end: Int): Int {
    var minDist = Int.MAX_VALUE
    for (i in start until end) {
        for (j in i+1 .. end) {
            val k = dist(array[i], array[j])
            minDist = k.coerceAtMost(minDist)
        }
    }
    return minDist
}

fun getResult(array: ArrayList<Point>, start: Int, end: Int): Int {
    val n = end - start + 1
    if (n <= 3) return bruteForce(array, start, end)

    val mid = (start + end) / 2

    var d = getResult(array, start, mid).coerceAtMost(getResult(array, mid + 1, end))

    val points: ArrayList<Point> = ArrayList<Point>()
    for (i in start..end) {
        val t: Int = array[mid].x - array[i].x
        if (t * t < d) points.add(array[i])
    }

    points.sortWith { p1, p2 -> p1.y - p2.y }

    for (i in 0 until points.size-1) {
        for (j in i+1 until points.size) {
            val t = points[j].y - points[i].y
            d = if (t * t < d) d.coerceAtMost(dist(points[i], points[j])) else break
        }
    }
    return d
}

/*
fun main() {
    val n = readLine()!!.toInt()
    val points = Array(n) { Pair(0, 0) }
    for (i in 0 until n) {
        val str = StringTokenizer(readLine())
        points[i] = Pair(str.nextToken().toInt(), str.nextToken().toInt())
    }

    val map = mutableMapOf<Pair<Int, Int>, Int>()
    map[Pair(points[0].second, points[0].first)] = 1
    map[Pair(points[1].second, points[1].first)] = 1

    print(map.toList())

    //...
}

fun getDist(A: Pair<Int, Int>, B: Pair<Int, Int>): Double {
    val X = A.first - B.first
    val Y = A.second - B.second
    return (X * X + Y * Y).toDouble()
}

*/

/* 시간 초과
fun main() = with(Scanner(System.`in`)) {
    var result = Long.MAX_VALUE
    val points = HashMap<Int, Point>()

    val n = nextInt()
    for (i in 0 until n) {
        points[i] = Point(nextInt(), nextInt())
    }

    for (i in 0 until n) {
        val prePoint = points[i]!!
        for (j in 0 until n) {
            if (i != j) {
                val nextPoint = points[j]!!
                val distX = ((nextPoint.X - prePoint.X) * (nextPoint.X - prePoint.X)).toLong()
                val distY = ((nextPoint.Y - prePoint.Y) * (nextPoint.Y - prePoint.Y)).toLong()
                result = result.coerceAtMost(distX + distY)
            }
        }
    }
    println(result)
}

private class Point(var X: Int, var Y: Int)
*/