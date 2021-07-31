package SWSelfStudyBook1

/*
테스트 케이스 3
667767
054060
101123
*/

fun main() {
    val input = intArrayOf(1,0,1,1,2,3)
    val array = IntArray(10)

    var (t, r) = 0 to 0

    for(i in input.indices) array[input[i]]++

    for(i in array.indices) {
        if(array[i] >= 3) { // 트리플
            array[i] -= 3
            t++
        }
        if(i - 1 >= 0 && i + 1 < array.size) { // 런
            if(array[i - 1] > 0 && array[i] > 0 && array[i + 1] > 0) {
                array[i - 1]--
                array[i]--
                array[i + 1]--
                r++
            }
        }
    }

    if(t + r == 2) println("Baby Gin") else println("Lose")
}