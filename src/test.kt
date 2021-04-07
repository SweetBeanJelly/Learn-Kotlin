fun main() {
    /*
    fun solution(gift_cards: IntArray, wants: IntArray): Int {
        val check = mutableSetOf(wants.size)

        for (i in wants.indices)
            for (j in gift_cards.indices)
                if (wants[i] == gift_cards[j]) {
                    check.add(gift_cards[j])
                }

        return wants.size - check.size
    }

    val test1 = intArrayOf(4,5,3,2,1)
    val test2 = intArrayOf(2,4,4,5,1)
    print(solution(test1, test2))

    */
    /*
    fun solution(needs: Array<IntArray>, r: Int): Int {
        var answer = 0

        answer = when(r) {
            0 -> return 0
            1 -> return 1
            2 -> {
                var count = 0
                for(i in needs.indices)
                    if(needs[i][2] == 1) count++
                needs.size - count
            }
            else -> needs.size
        }

        return answer
    }
    val test = arrayOf(intArrayOf(1,0,0), intArrayOf(1,1,0), intArrayOf(1,1,0), intArrayOf(1,0,1), intArrayOf(1,1,0), intArrayOf(0,1,1))
    print(solution(test, 3))
    */
    fun solution(n: Int, passenger: IntArray, train: Array<IntArray>): IntArray {
        var answer: IntArray = intArrayOf()

        return answer
    }
    val test1 = intArrayOf(2,1,2,2)
    val test2 = arrayOf(intArrayOf(1,2), intArrayOf(1,3), intArrayOf(2,4))
    print(solution(4, test1, test2))
}