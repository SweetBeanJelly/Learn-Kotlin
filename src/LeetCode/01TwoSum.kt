package LeetCode

/*
 주어진 배열에서 숫자 찾기
*/

fun main() {
    val nums = intArrayOf(2, 7, 11, 15)
    print(solution(nums, 9).contentToString())
}

fun solution(number: IntArray, nSum: Int): IntArray {

    for(i in 0..number.size-2) {
        for(j in i+1 until number.size) {
            if(number[i] + number[j] == nSum) return intArrayOf(i, j)
        }
    }
    return number
}