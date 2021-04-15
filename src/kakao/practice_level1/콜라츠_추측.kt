package kakao.practice_level1

fun main() {
    fun solution(num: Int): Int {
        var temp = num.toLong()
        var count = 0
        while(count < 500 && temp > 1) {
            count++
            temp = if(temp % 2 == 0L) temp / 2 else temp * 3 + 1
        }

        return if(count == 500) -1 else count
    }
    print(solution(626331))
}