package BOJ02

/*
 0과 1로 이루어진 타일
*/

fun main() {
    val input = readLine()!!.toInt()
    val array = IntArray(input + 2)
    array[1] = 1; array[2] = 2
    for(i in 3..input) array[i] = (array[i - 2] + array[i - 1]) % 15746
    print(array[input])
}