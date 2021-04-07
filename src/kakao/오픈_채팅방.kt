fun main() {
    fun solution(record: Array<String>): Array<String> {
        val uid = mutableMapOf<String, String>()

        record.forEach {
            val check = it.split(" ")
            when(check[0]) {
                "Enter" -> uid[check[1]] = check[2]
                "Change" -> uid[check[1]] = check[2]
            }
        }

        val message = record.map {
            val check = it.split(" ")
            when(check[0]) {
                "Enter" -> "${uid[check[1]]}님이 들어왔습니다."
                "Leave" -> "${uid[check[1]]}님이 나갔습니다."
                else -> ""
            }
        }.filter { it != "" }.toTypedArray()

        return message
    }

    val test = arrayOf("Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan")
    print(solution(test).toList())
}