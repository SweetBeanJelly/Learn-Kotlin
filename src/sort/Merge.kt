package sort
/*
리스트를 두개로 분할하는 과정을 재귀적으로 수행 후
다시 각각 정렬하며 합쳐지는 과정을 수행
분할 할 때는 정렬 X 전부 분할 후 다시 분할된 부분 합치며 정렬 수행
*/
fun main() {
    val list = arrayOf(30,64,54,88,52,10,1,6)
    merge(list, 0, list.size-1)
    list.forEach {
        println(it)
    }
}
fun merge(list: Array<Int>, p: Int, q: Int, r: Int) {

    var left = list.copyOfRange(p, q + 1)
    var right = list.copyOfRange(q + 1, r + 1)
    var i = 0
    var j = 0

    for (k in p..r) {
        if ((i <= left.size - 1) && ((j >= right.size) || (left[i] <= right[j]))) {
            list[k] = left[i];
            i++;
        } else {
            list[k] = right[j];
            j++;
        }
    }
}

fun merge(list: Array<Int>, p: Int, r: Int) {
    if (p < r) {
        var q = (p + r) / 2
        merge(list, p, q)
        merge(list, q + 1, r)
        merge(list, p, q, r)
    }
}