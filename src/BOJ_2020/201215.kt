package BOJ_2020

/*
 1. 좌표 정렬하기
 2. 좌표 정렬하기 2
*/

fun main() {
    // 1
    /*
    val number = readLine()!!.toInt()
    var array = Array(number) { arrayOfNulls<String>(2) }

    for(i in 0 until number) {
        var str = StringTokenizer(readLine(), " ")
        array[i][0] = str.nextToken()
        array[i][1] = str.nextToken()
    }

    array.sortWith{ a, b ->
        when {
            a[0] == b[0] -> a[1]!!.toInt() - b[1]!!.toInt()
            else -> a[0]!!.toInt() - b[0]!!.toInt()
        }
    }

    var sb = StringBuilder()
    for(i in 0 until number) sb.append("${array[i][0]} ${array[i][1]}\n")
    print(sb)
    */
    // 2
    /*
    val number = readLine()!!.toInt()
    var array = Array(number) { arrayOfNulls<String>(2) }

    for(i in 0 until number) {
        var str = StringTokenizer(readLine(), " ")
        array[i][1] = str.nextToken()
        array[i][0] = str.nextToken()
    }

    array.sortWith{ a, b ->
        when {
            a[0] == b[0] -> a[1]!!.toInt() - b[1]!!.toInt()
            else -> a[0]!!.toInt() - b[0]!!.toInt()
        }
    }

    var sb = StringBuilder()
    for(i in 0 until number) sb.append("${array[i][1]} ${array[i][0]}\n")
    print(sb)
     */
}