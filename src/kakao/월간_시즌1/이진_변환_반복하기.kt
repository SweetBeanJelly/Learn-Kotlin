package kakao.월간_시즌1

fun main() {
    fun solution(s: String): IntArray {
        var answer = IntArray(2)
        var temp = s

        while(true) {
            var array = ""
            for (i in temp.indices)
                if (temp[i] == '1') array += 1 else answer[1]++

            temp = array.length.toString(2)
            answer[0]++

            if(array.length == 1) break
        }

        return answer
    }
    print(solution("01110"))
}

/*
        var answer: IntArray = intArrayOf(0, 0)
        var str = s
        while(str != "1") {
            answer[0]++
            val one = str.count{ it == '1' }
            answer[1] += str.length - one
            str = one.toString(2)
        }
        return answer
*/