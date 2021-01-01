//// 스택
//
//class Solution {
//
//    fun solution(board: Array<IntArray>, moves: IntArray): Int {
//        val stack = Stack<Any>()
//
//        moves.forEach { j ->
//            for(i in board.indices) {
//                if(board[i][j-1] == 0) continue
//
//                stack.push(board[i][j-1])
//                board[i][j-1] = 0
//                break
//            }
//        }
//
//        return stack.remove
//    }
//
//
//    class Stack<T> {
//        val stack = Stack<Int>()
//        var remove = 0
//
//        fun push(value: Int) {
//            when {
//                stack.isEmpty() -> stack.push(value)
//                stack.peek() == value -> {
//                    stack.pop()
//                    remove += 2
//                }
//                else -> stack.push(value)
//            }
//        }
//    }
//}