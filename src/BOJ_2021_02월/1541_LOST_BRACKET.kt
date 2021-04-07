package BOJ_2021_02월

/*
 식의 값을 최소로 만들기
*/

fun main() {
    val list1 = readLine()!!.split("\\-".toRegex()).toTypedArray()
    var result = 0
    for(i in list1.indices) {
        val list2 = list1[i].split("\\+".toRegex()).toTypedArray()
        for(j in list2.indices) {
            if(i == 0) result += list2[j].toInt()
            else result -= list2[j].toInt()
        }
    }
    print(result)
}