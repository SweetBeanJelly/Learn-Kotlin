package kakao.kit

// https://programmers.co.kr/learn/courses/30/lessons/42577

fun main() {
    fun solution(phone_book: Array<String>): Boolean {
        val check = phone_book[0]
        for(i in 1 until phone_book.size)
            if(phone_book[i].startsWith(check)) return false
        return true
    }

    val test1 = arrayOf("119", "97674223", "1195524421")
    val test2 = arrayOf("123", "456", "789")
    val test3 = arrayOf("12", "123", "1235", "567", "88")
    print("${solution(test1)}\n${solution(test2)}\n${solution(test3)}\n")
}