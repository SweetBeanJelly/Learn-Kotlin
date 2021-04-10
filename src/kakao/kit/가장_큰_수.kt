package kakao.kit

// https://programmers.co.kr/learn/courses/30/lessons/42746

fun main() {
    fun solution(numbers: IntArray): String {
        val answer = numbers
            .map { it.toString() }
            .sortedWith { a, b -> (b + a).toInt() - (a + b).toInt() }
            .joinToString ("") { it }
        return if (answer.startsWith('0')) '0'.toString() else answer
    }
    print(solution(intArrayOf(3,30,34,5,9)))
}

/*
//1
        var answer = ""
        numbers.sortedWith(Comparator({num1: Int, num2: Int -> "$num2$num1".compareTo("$num1$num2")})).forEach { answer += it }
        if ("(0*)".toRegex().replace(answer, "").isEmpty()) {
            answer = "0"
        }
        return answer
//2
    var answer = ""
    numbers.sortedByDescending {it.toString().padEnd(4,'%').replace("%",it.toString())}.forEach{answer += it}

    var patten = "[1-9]".toRegex()
    if(patten.containsMatchIn(answer) == false){
        answer = "0"
    }
    return answer
    }
*/