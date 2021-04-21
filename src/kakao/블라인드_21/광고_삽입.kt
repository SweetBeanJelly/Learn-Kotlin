package kakao.블라인드_21

import java.util.Arrays


fun main() {
    fun go(str: String): Int {
        val temp = Arrays.stream(str.split(":".toRegex()).toTypedArray()).mapToInt { s: String -> s.toInt() }.toArray()
        return temp[0] * 60 * 60 + temp[1] * 60 + temp[2]
    }
    fun solution(play_time: String, adv_time: String, logs: Array<String>): String {
        val (play_time, adv_time) = go(play_time) to go(adv_time)
        val count = LongArray(play_time + 1)

        for (i in logs) {
            val split = i.split("-".toRegex()).toTypedArray()
            count[go(split[0])]++
            count[go(split[1])]--
        }

        for (i in 1..play_time) count[i] += count[i - 1]
        for (i in 1..play_time) count[i] += count[i - 1]

        var max = count[adv_time - 1]
        var start: Long = 0

            var i = 0
            while (i + adv_time <= play_time) {
                val tmp = count[i + adv_time] - count[i]
                if (tmp > max) {
                    max = tmp
                    start = (i + 1).toLong()
                }
                i++
            }


        return String.format("%02d:%02d:%02d", start / (60 * 60), start / 60 % 60, start % 60)
    }

    print(solution("02:03:55", "00:14:15", arrayOf("01:20:15-01:45:14", "00:40:31-01:00:00", "00:25:50-00:48:29", "01:30:59-01:53:29", "01:37:44-02:02:30")))
}

/*
fun solution(play_time: String, adv_time: String, logs: Array<String>): String {
        var playTime = strToInt(play_time)
        var advTime = strToInt(adv_time)
        var times = IntArray(playTime+1)

        for(log in logs) {
            var tmp = log.split("-")
            var start = strToInt(tmp[0])
            var end = strToInt(tmp[1])

            for(i in start until end) {
                times[i]++
            }
        }

        var sum = 0L
        for(i in 0 until advTime) {
            sum += times[i]
        }

        var max = sum
        var record = 0
        for(i in 1 .. playTime-advTime) {
            sum = sum-times[i-1] +times[i+advTime-1]
            if(sum > max) {
                max = sum
                record = i
            }
        }

        return intToString(record)
    }

    fun strToInt(str: String): Int {
        var tmp = str.split(":")
        var h = tmp[0].toInt()*3600
        var m = tmp[1].toInt()*60
        var s = tmp[2].toInt()
        return h+m+s
    }

    fun intToString(num: Int): String {
        var tmp = num
        var h = tmp / 3600
        tmp = tmp % 3600
        var m = tmp / 60
        var s = tmp % 60
        return String.format("%02d:%02d:%02d", h, m, s)
    }
*/
