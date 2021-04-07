package BOJ_2021_02월

/*
 한 개의 회의실에 N 개의 회의실 사용표를 만드려한다.
*/

fun main() {
    val N = readLine()!!.toInt()
    val list = mutableListOf<Meetingroom>()
    repeat(N) {
        val (start: Int, end: Int) = readLine()!!.split(" ").map { it.toInt() }
        list.add(Meetingroom(start, end))
    }
    list.sort()
    var count = 1
    var temp = list[0].end
    for(i in 1 until N) {
        if(list[i].start >= temp) {
            temp = list[i].end
            count++
        }
    }
    print(count)
}

data class Meetingroom(val start: Int, val end: Int): Comparable<Meetingroom> {
    override fun compareTo(other: Meetingroom): Int {
        return if(this.end == other.end) this.start - other.end else this.end - other.end
    }
}