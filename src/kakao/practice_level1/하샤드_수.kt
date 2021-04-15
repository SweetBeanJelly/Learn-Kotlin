package kakao.practice_level1

fun main() {
    fun solution(x: Int): Boolean {
        val list = x.toString()
        var answer = 0

        for(i in list.indices)
            answer += list[i].toInt() - 48

        return if(x % answer == 0) return true
        else false
        /*
        var sum = 0
        var num = x

        while (num > 0) {
            sum += num % 10
            num /= 10
        }

        return (x % sum == 0)
        */
    }
    print(solution(11))
}