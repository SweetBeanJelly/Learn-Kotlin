/*
한 번에 한 명씩 신청 순서대로 방 배정
고객은 투숙하기 원하는 방 번호 제출
고객이 원하는 방 비어 있다면 즉시 배정
고객이 원하는 방 이미 배정되어 있다면 원하는 방보다 번호가 크면서 비어있는 방 중 가장 번호가 작은 방 배정
각 고객에게 배정되는 방 번호 순서대로 배열에 담아 return
*/

/*
 MAP 사용. find() 함수 만들어 재귀적으로 사용.
 key , value 둘 다 Long type. key = 방 번호, value = 뒤늦게 들어온 사람이 갈 방 번호
 주어진 입력 순서대로 containsKey 함수 사용하여 해당 방 번호 있는지 check
 방 번호 들어있지 않으면 방 배정. -> [방 번호+1] 값을 value 으로.
 뒤늦게 들어오려는 고객 있는 경우 MAP 탐색해 대응하는 value 값 으로.
*/

class Hotel_room {
    fun solution(key : Long, value : LongArray) : LongArray {

        val map = mutableMapOf<Long, Long>()
        val answer = LongArray(value.size)

        fun find(room : Long) : Long {
            if (!map.containsKey(room)) {
                map[room] = room + 1
                return room
            }
            map[room] = find(map[room]!!)
            return map[room]!!
        }

        value.forEachIndexed { i, room ->
            answer[i] = find(room)
        }

        return answer
    }
}