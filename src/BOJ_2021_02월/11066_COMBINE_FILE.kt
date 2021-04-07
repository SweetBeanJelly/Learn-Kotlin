package BOJ_2021_02월

import kotlin.math.min

/*
 소설을 여러 장(chapter)으로 나누어 쓴다. 각 장은 각각 다른 파일에 저장.
 소설의 모든 장을 쓰고 나서는 각 장이 쓰여진 파일을 합쳐서 최종적으로 소설의 완성본이 들어있는 한 개의 파일을 만든다.
 이 과정에서 두 개의 파일을 합쳐서 하나의 임시파일을 만들고, 이 임시파일이나 원래의 파일을 계속 두 개씩 합쳐서 소설의 여러 장들이 연속이 되도록 파일을 합쳐나가고, 최종적으로는 하나의 파일로 합친다.
 두 개의 파일을 합칠 때 필요한 비용(시간 등)이 두 파일 크기의 합이라고 가정할 때, 최종적인 한 개의 파일을 완성하는데 필요한 비용의 총 합을 계산하시오.
*/

fun main() {
    repeat(readLine()!!.toInt()) {
        val N = readLine()!!.toInt()
        val array = readLine()!!.split(" ").map { it.toInt() }.toIntArray()
        val dp = Array(N) { IntArray(N) }

        val result = IntArray(N)
        result[0] = array[0]

        for(i in 1 until N) result[i] = result[i - 1] + array[i]
        for(i in 1 until N)
            for(j in i - 1 downTo 0) {
                dp[j][i] = 987654321
                for(k in j until i) dp[j][i]= min(dp[j][i], dp[j][k] + dp[k + 1][i])
                if(j != 0) dp[j][i] += result[i] - result[j - 1]
                else dp[j][i] += result[i]
            }
        println(dp[0][N - 1])
    }
}