package kakao.인턴_19

// https://programmers.co.kr/learn/courses/30/lessons/64061

fun main() {
    fun solution(board: Array<IntArray>, moves: IntArray): Int {
        val answer = mutableListOf<Int>()
        val r = mutableListOf<Int>()
        for (m in moves)
            for (i in board.indices) {
                if (board[i][m - 1] != 0) {
                    r.add(board[i][m - 1])
                    board[i][m - 1] = 0
                    if (r.size >= 2)
                        if (r[r.size - 2] == r[r.size - 1]) {
                            answer.add(r[r.size - 1])
                            r.removeAt(r.size - 1)
                            r.removeAt(r.size - 1)
                        }
                    break
                }
            }
        return (answer.size) * 2
    }

    println(solution(arrayOf(intArrayOf(0, 0, 0, 0, 0), intArrayOf(0, 0, 1, 0, 3), intArrayOf(0, 2, 5, 0, 1), intArrayOf(4, 2, 4, 4, 2), intArrayOf(3, 5, 1, 3, 1)),intArrayOf(1,5,3,5,1,2,1,4)))
}

/*
fun solution(board: Array<IntArray>, moves: IntArray): Int {
        var answer = 0
        val stack = Stack<Int>()

        moves.forEach {
            for (i in board.indices) {
                if (board[i][it - 1] != 0) {
                    if (stack.isNotEmpty() && stack.peek() == board[i][it - 1]) {
                        answer += 2
                        stack.pop()
                    } else {
                        stack.push(board[i][it - 1])
                    }
                    board[i][it - 1] = 0

                    break
                }
            }
        }
        return answer
    }
*/