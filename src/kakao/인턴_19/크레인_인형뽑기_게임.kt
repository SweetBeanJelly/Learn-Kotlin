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