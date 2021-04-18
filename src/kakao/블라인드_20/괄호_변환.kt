fun main() {
    fun check(c: String): Boolean {
        return c[0] == '(' && c[c.length - 1] == ')'
    }
    fun solution(p: String): String {
        var answer = ""
        var (u, v) = "" to ""
        var (open, close) = 0 to 0

        for(i in p.indices) {
            if(p[i] == '(') open++ else close++
            if(open == close) {
                u = p.substring(0, i + 1)
                v = p.substring(i + 1)
                break
            }
        }

        if("" != v) v = solution(v)
        if(!check(u)) {
            answer += "($v)"
            for(i in 1 until u.length - 1) {
                answer += if(u[i] == '(') ')' else '('
            }
        } else answer += "$u$v"

        return answer
    }
    print(solution(readLine()!!))
}