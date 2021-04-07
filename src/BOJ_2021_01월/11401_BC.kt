package BOJ_2021_01월

import java.util.*

/*
 이항 계수 3
 자연수 N, 정수 K 1,000,000,007로 나눈 나머지 구하기 (페르마의 소정리, 확장 유클리드 호제법)
*/

fun main() = with(Scanner(System.`in`)) {
    val n = nextInt()
    val k = nextInt()
    val p: Long = 1000000007

    val f = LongArray(n + 1)
    f[0] = 1
    f[1] = 1
    for (i in 2..n) f[i] = f[i - 1] * i % p
    val a = f[n] // a : n!
    var b = f[k] * f[n - k] % p // b : k!*(n-k)!

    var e = p - 2 // 지수( exponent )

    var b_pow_e: Long = 1 // b의 e 제곱 ( pow )

    while (e > 0) {
        if (e % 2 == 1L) b_pow_e = b_pow_e * b % p // b_pow_e *= b;  b_pow_e %= p;
        b = b * b % p
        e /= 2
    }

    println(a % p * (b_pow_e % p) % p)
}

