package BOJ

/*
 1. 단어 정렬
 2. 나이순 정렬
*/

fun main() {
    // 1
    /*
    var number = readLine()!!.toInt()

    var set = hashSetOf<String>()

    for(i in 0 until number) set.add(readLine()!!)

    var list = ArrayList<String>(set)

    list.sortWith { a, b ->
        when {
            a.length > b.length -> 1
            a.length < b.length -> -1
            else -> a.compareTo(b)
        }
    }

    list.forEach { println(it) }
    */
    // 2
    /*
    var number = readLine()!!.toInt()
    var array = Array(number) { arrayOfNulls<String>(2) }

    for(i in 0 until number) {
        var str = StringTokenizer(readLine(), " ")
        array[i][0] = str.nextToken()
        array[i][1] = str.nextToken()
    }

    array.sortWith { a, b ->
        a[0]!!.toInt() - b[0]!!.toInt()
    }

//    println(array.contentDeepToString())
    var sb = StringBuilder()
    for(i in 0 until number) sb.append("${array[i][0]} ${array[i][1]}\n")
    print(sb)
    */
}