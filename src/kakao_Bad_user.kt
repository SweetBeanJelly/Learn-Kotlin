/*
사용자 리스트와 불량 사용자 리스트가 주어지면 제제 아이디 리스트의 경우의 수 구하는 문제.
불량 사용자 아이디는 * 가 1개 이상
정규식 사용을 위해 별표는 replace 함수 사용하여 . 으로 변경
. 은 정규식에서 모든 문자 하나를 의미
DFS 를 사용하여 제제 아이디 리스트 목록 구한 후 set 사용하여 중복 제거
*/

class Bad_user {
    fun solution (user_id:Array<String>, banned_id:Array<String>):Int {
        val bannedRegex = banned_id.map { it.replace("*",".") }
        val checked = BooleanArray(user_id.size)

        fun dfs (index:Int, set:MutableSet<Int>, add:(MutableSet<Int>) -> Unit ) {
            if (index == banned_id.size) {
                add(set)
                return
            }

            user_id.forEachIndexed { index, user ->
                if (Regex(bannedRegex[index]).matches(user) && !checked[index]) {
                    checked[index] = true
                    set.add(index)

                    dfs(index + 1, set.copy(), add)
                    checked[index] = false
                    set.remove(index)
                }
            }
        }

        val set = mutableSetOf<MutableSet<Int>>()
        dfs(0, mutableSetOf()) {
            set.add(it)
        }
        return set.size
    }

    private fun MutableSet<Int>.copy(): MutableSet<Int> {
        val result = mutableSetOf<Int>()
        result.addAll(this)
        return result
    }
}