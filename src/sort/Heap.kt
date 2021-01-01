package sort

/*
완전 이진 트리의 일종, 우선순위 큐를 위하여 만들어짐
최댓값, 최솟값을 쉽게 추출
*/

var heapSize = 0

fun main() {

    val list = arrayOf(5,80,66,32,1,45,41,20)

    heap(list)
    list.forEach {
        println(it)
    }

}

fun left(i: Int): Int {
    return 2 * i
}

fun right(i: Int): Int {
    return 2 * i + 1
}

fun swaps(list: Array<Int>, i: Int, j: Int) {
    var temp = list[i]
    list[i] = list[j]
    list[j] = temp
}

fun maxheap(list: Array<Int>, i: Int) {
    var l = left(i);
    var r = right(i);
    var largest: Int;

    largest = if ((l <= heapSize - 1) && (list[l] > list[i])) {
        l;
    } else
        i

    if ((r <= heapSize - 1) && (list[r] > list[l])) {
        largest = r
    }

    if (largest != i) {
        swaps(list, i, largest);
        maxheap(list, largest);
    }
}

fun maxheap(list: Array<Int>) {
    heapSize = list.size
    for (i in heapSize / 2 downTo 0) {
        maxheap(list, i)
    }
}

fun heap(list: Array<Int>) {
    maxheap(list)
    for (i in list.size - 1 downTo 1) {
        swaps(list, i, 0)
        heapSize -= 1
        maxheap(list, 0)
    }
}