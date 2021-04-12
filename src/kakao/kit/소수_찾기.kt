package kakao.kit

// https://programmers.co.kr/learn/courses/30/lessons/42839

fun main() {
    fun solution(numbers: String): Int {
        fun check(n: Int): Boolean{
            for(i in 2 .. n - 2)
                if(n % i == 0) return false
            if(n <= 1) return false
            return true
        }

        val flag = BooleanArray(numbers.length)
        val answer = mutableSetOf<Int>()

        fun go(n: Int, str: String){
            if(n == numbers.length){
                if(str == "") return
                if(check(str.toInt())) answer.add(str.toInt())
                return
            }

            for(i in numbers.indices){
                if(!flag[i]) {
                    flag[i] = true
                    go(n + 1, str + numbers[i])
                    flag[i] = false
                    go(n + 1, str)
                }
            }
        }

        go(0,"")

        return answer.size
    }
    print(solution("17"))
}