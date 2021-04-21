package kakao.kit

import java.util.*

fun main() {
    fun solution(begin: String, target: String, words: Array<String>): Int {
        var answer = 0
        if(!words.contains(target)) return 0
        val q = LinkedList<String>()
        words.forEach {
            q.add(it)
        }

        var (begin, qp) = begin to q.poll()

        while(begin != target) {
            var count = 0
            for(i in begin.indices)
                if(begin[i] != target[i]) count++
            if(count == 1) {
                begin = qp
                return answer + 1
            }
            count = 0
            for(i in begin.indices)
                if(begin[i] != qp[i]) count++
            if(count == 1) {
                begin = qp
                answer++
            }

            if(!q.isEmpty()) qp = q.poll()
        }

        return answer
    }
    print(solution("hit", "cog", arrayOf("hot", "dot", "dog", "lot", "log", "cog")))
}