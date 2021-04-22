package BOJ_2021_04월

fun main() {
    class go(var n1: Int, var n2: Int) {
        fun gcd(): Int {
            while(n2 > 0) {
                val temp = n2
                n2 = n1 % n2
                n1 = temp
            }
            return n1
        }
        fun lcm(): Int = (n1 * n2) /  gcd()
    }
    val (n1, n2) = readLine()!!.split(" ").map { it.toInt() }
    println("${go(n1, n2).gcd()}\n${go(n1, n2).lcm()}")
}