package BOJ_2021_02월

/*
 비활성화 문제를 스마트하게 해결하기 위한 프로그램을 작성
*/

// 2차
fun main() {
    val (N, M) = readLine()!!.split(" ").map { it.toInt() }
    val memory = readLine()!!.split(" ").map { it.toInt() }
    val cost = readLine()!!.split(" ").map { it.toInt() }

    val dp = IntArray(10001)
    val sum = cost.sum()

    for(i in 0 until N)
        for (j in sum downTo cost[i])
            dp[j] = dp[j].coerceAtLeast(dp[j - cost[i]] + memory[i])

    for(i in 0..sum)
        if(dp[i] >= M) {
            print(i)
            break
        }
}

/* 1차
import java.util.*
fun main() {
    val (N, M) = readLine()!!.split(" ").map { it.toInt() }
    val memory = readLine()!!.split(" ").map { it.toInt() }
    val cost = readLine()!!.split(" ").map { it.toInt() }

    val dp = IntArray(10001)
    Arrays.fill(dp, -1)

    for(i in 0 until N) {
        for (j in dp.size - 1 downTo cost[i]) {
            val temp = dp[j - cost[i]]
            if (temp != -1) if (temp + memory[i] > dp[j]) dp[j] = temp + memory[i]
        }
        if (dp[cost[i]] < memory[i]) dp[cost[i]] = memory[i]
    }

    for(i in dp.indices)
        if(dp[i] >= M) {
            print(i)
            break
        }
}
*/

/*
for (i in 0..n-1) {
		for (j in sum-1 downTo 0) {
			if (j - v[i] >= 0) {
				dp[j] = max(dp[j], dp[j-v[i]] + arr[i]);
			}
		}
	}

	var i: Int = 0;
	while (true) {
		i += 1;
		if (i > sum-1 || dp[i] >= m) {
			break;
		}
	}
	println(i);
*/