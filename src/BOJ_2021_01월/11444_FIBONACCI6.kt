package BOJ_2021_01월

/*
 n이 주어졌을 때 n번째 피보나치 수 구하기
*/

fun main() {
    var input = readLine()!!.toLong()
    val mat: Array<Array<Long>> = arrayOf(arrayOf(1,1), arrayOf(1,0))
    val res: Array<Array<Long>> = arrayOf(arrayOf(1,0), arrayOf(0,1))

    while (input > 0) {
        if(input % 2 == 1L) fibonacci(res, mat)

        input /= 2
        fibonacci(mat, mat)
    }

    print(res[1][0])
}

fun fibonacci(a: Array<Array<Long>>, b: Array<Array<Long>>) {
    val temp_array = Array(2) {Array(2) {0L}}

    for(i in 0..1)
        for(j in 0..1) {
            var temp = 0L
            for(k in 0..1)
                temp += (a[i][k] * b[k][j])
            temp_array[i][j] = temp % 1000000007
        }

    for(i in 0..1)
        for(j in 0..1)
            a[i][j] = temp_array[i][j]

    return
}

