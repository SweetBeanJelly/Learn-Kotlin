package kakao.practice_level1

fun main() {
    /*
    fun solution(strings: Array<String>, n: Int): Array<String> {
        return strings.sortedWith(Comparator<String> { a, b ->
            if(a[n] == (b[n])) a.compareTo(b)
            else a[n].compareTo(b[n])
        }).toTypedArray()
    }
    */
    fun solution(strings: Array<String>, n: Int): Array<String> {
        return strings.also {
            it.sort()
            it.sortBy { it[n] }
        }
        /*
        return strings.sortedWith(compareBy( { it[n] }, { it } ) ).toTypedArray()
        */
    }
}