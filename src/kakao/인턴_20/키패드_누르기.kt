package kakao.인턴_20

import java.awt.Point
import kotlin.math.abs

fun main() {
    fun solution(numbers: IntArray, hand: String): String {
        var answer = ""
        val array = arrayOfNulls<Point>(10)
        array[0] = Point(3, 1)
        array[1] = Point(0, 0)
        array[2] = Point(0, 1)
        array[3] = Point(0, 2)
        array[4] = Point(1, 0)
        array[5] = Point(1, 1)
        array[6] = Point(1, 2)
        array[7] = Point(2, 0)
        array[8] = Point(2, 1)
        array[9] = Point(2, 2)

        val l = Point(3, 0)
        val r = Point(3, 2)

        for (num in numbers) {
            if (num == 1 || num == 4 || num == 7) {
                l.x = array[num]!!.x
                l.y = array[num]!!.y
                answer += "L"
            } else if (num == 3 || num == 6 || num == 9) {
                r.x = array[num]!!.x
                r.y = array[num]!!.y
                answer += "R"
            } else {
                val a = abs(l.x - array[num]!!.x) + abs(l.y - array[num]!!.y)
                val b = abs(r.x - array[num]!!.x) + abs(r.y - array[num]!!.y)
                if (a == b) {
                    if (hand == "right") {
                        r.x = array[num]!!.x
                        r.y = array[num]!!.y
                        answer += "R"
                    } else {
                        l.x = array[num]!!.x
                        l.y = array[num]!!.y
                        answer += "L"
                    }
                } else {
                    if (b < a) {
                        r.x = array[num]!!.x
                        r.y = array[num]!!.y
                        answer += "R"
                    } else {
                        l.x = array[num]!!.x
                        l.y = array[num]!!.y
                        answer += "L"
                    }
                }
            }
        }
        return answer
    }
    print(solution(intArrayOf(1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5), "right"))
}