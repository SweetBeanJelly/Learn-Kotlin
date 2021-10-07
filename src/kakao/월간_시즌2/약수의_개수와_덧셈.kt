package kakao.월간_시즌2

fun main() {
    fun solution(left: Int, right: Int): Int {
        var answer = 0
        for(n in left .. right) {
            var c = 0
            for(k in 1 .. n) if(n % k == 0) c++
            if(c % 2 == 0) answer += n else answer -= n
        }
        return answer
    }

    println(solution(13,17))
}