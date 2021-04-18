fun main() {
    fun check(r: Long, map: HashMap<Long, Long>): Long {
        if(!map.containsKey(r)) {
            map[r] = r + 1
            return r
        }
        val c = check(map[r]!!, map)
        map[r] = c
        return c
    }

    fun solution(k: Long, room_number: LongArray): LongArray {
        var answer = LongArray(room_number.size)
        val map = HashMap<Long, Long>()

        for (i in room_number.indices)
            answer[i] = check(room_number[i], map)

        return answer
    }
}