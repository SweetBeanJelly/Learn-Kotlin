package kakao.kit

import java.util.*

fun main() {
    fun solution(tickets: Array<Array<String>>): Array<String> {
        var check = booleanArrayOf()
        val stack = Stack<String>()
        val list = mutableListOf<String>()

        fun go(array: Array<Array<String>>, depth: Int) {
            if(depth == array.size) list.add(stack.joinToString(","))
            else {
                val next = stack.peek()
                for(i in array.indices) {
                    if(check[i]) continue
                    if(array[i][0] == next) {
                        check[i] = true
                        stack.add(array[i][1])
                        go(array, depth + 1)
                        stack.pop()
                        check[i] = false
                    }
                }
            }
        }

        for(i in tickets.indices) {
            if(tickets[i][0] == "ICN") {
                check = BooleanArray(tickets.size) { false }
                check[i] = true
                stack.push("ICN")
                stack.push(tickets[i][1])
                go(tickets, 1)
                stack.pop()
                stack.pop()
            }
        }

        return list.sorted()[0].split(",").toTypedArray()
    }
    print(solution(arrayOf(arrayOf("ICN", "JFK"), arrayOf("HND", "IAD"), arrayOf("JFK", "HND"))))
}

/*
fun solution(tickets: Array<Array<String>>): Array<String> {

        var stack = java.util.Stack<String>()
        var answer = ArrayList<String>()
        var map = tickets.groupBy { it[0]}
            .map {
                it.key to it.value.sortedBy { it[1] }.map { it[1] }
            }.toMap() as HashMap<String, List<String>>
        stack.push("ICN")

        while (stack.isNotEmpty()){
            val top = stack.peek()

            val first = map[top]

            if(first == null || first!!.isEmpty()){
                answer.add(stack.pop())
            }else{
                stack.push(first.first())
                map[top] = first.drop(1)
            }
        }

        return answer.reversed().toTypedArray()
    }
*/

/*
fun solution(tickets: Array<Array<String>>): Array<String> {
        val ticketList = arrayListOf<Array<String>>().apply { addAll(tickets) }
        return getRoute("ICN", ticketList, arrayListOf("ICN"))!!.toTypedArray()
    }

    private fun getRoute(start: String, tickets: ArrayList<Array<String>>, result: ArrayList<String>): ArrayList<String>? {
        if (tickets.isEmpty()) return result
        val validTickets = arrayListOf<Pair<Int, String>>()
        tickets.forEachIndexed { index, ticket -> if (ticket[0] == start) validTickets.add(Pair(index, ticket[1])) }
        validTickets.sortedBy { it.second }.forEach {
            val tempTickets = tickets.clone() as ArrayList<Array<String>>
            val tempResult = result.clone() as ArrayList<String>
            tempTickets.removeAt(it.first)
            tempResult.add(it.second)
            val response = getRoute(it.second, tempTickets, tempResult)
            if (response != null) return response
        }
        return null
    }
*/