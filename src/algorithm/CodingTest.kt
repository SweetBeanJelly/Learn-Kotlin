package algorithm

class Solution {
    fun solution(info: Array<String>, query: Array<String>): IntArray {
        var answer: IntArray = intArrayOf()
        return answer
    }
}

fun main() {
    var info = arrayOf("java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50")
    var query = arrayOf("java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150")

    for(i in info.indices) {
        var splitInfo = info[i].split(" ")
        var splitQuery = query[i].split("and"," ")

        var s: String = splitQuery.toString().replace(" ,","")

        var check = false

        println("dd $splitInfo")
        println("dd $s")

        for(j in 0..5) {
            var c: Int
            if(splitInfo[j] == s[j].toString() || splitQuery[j] == "-") {
                check = true
                if(splitInfo.indexOf(j.toString()) == 4 ) {
                    if(splitInfo[4] <= splitQuery[4]) {
                        check = false
                    }
                }
            }
        }

    }

}



//
//class Solution {
//    fun solution(orders: Array<String>, course: IntArray): Array<String> {
//var answer: Array<String> = arrayOf<String>()
//        answer.sorted()
//        return answer
//    }
//}
//
//fun main() {
//    val list = arrayOf("ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH")
//    val course = arrayOf(2,3,4)
//
//    var letter = 'A'..'Z'
//
//    for(i in list.indices) {
//        if(list[i].length >= 2) {
//            var check = list[i].toString()
//            println("check = $check")
//
//            if(check.indexOf("AA") != -1) {
//
//            }
//
//        }
//    }
//
//}
//
//fun check ()