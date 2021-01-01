package sort
/*
인접한 두 원소 비교

장_단순함
단_다른 정렬에 비해 연산 시간 오래 걸림
*/
fun main() {
    var list = arrayListOf(258,64,128,2,4,8,32).bubbleSort()
    list.forEach {
        println(it)
    }
}

fun ArrayList<Int>.bubbleSort(): ArrayList<Int> {
    var swap = true
    while(swap) {
        swap = false
        for(i in 0 until this.indices.last) {
            if(this[i] > this[i+1]) {
                val temp = this[i]
                this[i] = this[i+1]
                this[i+1] = temp
                swap = true
            }
        }
    }
    return this
}