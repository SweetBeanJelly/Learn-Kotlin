package SWSelfStudyBook1

/*
1
5 -7 -3 -2 5 8
*/

fun main() {
    val array = intArrayOf(-7,-3,-2,5,8)
    var (sum, r) = 0 to 0

    for(i in 1..(1 shl array.size)) {
        sum = 0
        for(j in 0..array.size)
            if (i and (1 shl j) == 1) sum += array[j]
        if(sum == 0) {
            r = 1
            break
        }
    }
    if(r == 1) println("True") else println("False")
}