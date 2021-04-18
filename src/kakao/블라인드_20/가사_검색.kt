import java.util.HashMap

/*
class Solution {
    class TrieNode() {
        val children: HashMap<Char, TrieNode> = hashMapOf()
        var childCount = 0
        fun insert(word: String) {
            var trieNode = this
            word.forEach { char ->
                var child = trieNode.children[char] ?: {
                    val newTrieNode = TrieNode()
                    trieNode.children[char] = newTrieNode
                    newTrieNode
                }()
                trieNode.childCount++
                trieNode = child
            }
        }
        fun search(query: String): Int {
            val trieNode = this
            if (query.isEmpty()) {
                if (trieNode.children.isEmpty()) {
                    return 1
                }
                return 0
            }
            val char = query.first()
            if (char == '?') {
                return trieNode.childCount
            }
            return trieNode.children[char]?.search(query.substring(1)) ?: 0
        }
    }


    fun solution(words: Array<String>, queries: Array<String>): IntArray {
        val trieMap: HashMap<Int, TrieNode> = hashMapOf()
        val reverseTrieMap: HashMap<Int, TrieNode> = hashMapOf()

        words.forEach {
            val length = it.length
            if (length !in trieMap.keys) {
                trieMap[length] = TrieNode()
                reverseTrieMap[length] = TrieNode()
            }
            trieMap[length]?.insert(it)
            reverseTrieMap[length]?.insert(it.reversed())
        }
        return queries.map {
            val length = it.length
            if (it.first() == '?') {
                reverseTrieMap[length]?.search(it.reversed()) ?: 0
            } else {
                trieMap[length]?.search(it) ?: 0
            }
        }.toIntArray()
    }

}
*/

/*
class Trie(var count: Int, val child: MutableMap<Char, Trie>? = mutableMapOf())

class Solution {
    fun solution(words: Array<String>, queries: Array<String>): IntArray {
        val wordMap: MutableMap<Int, Trie> = mutableMapOf()
        val wordMapReverse: MutableMap<Int, Trie> = mutableMapOf()

        for (word in words) {
            getMap(wordMap, word)
            getMap(wordMapReverse, word.reversed())
        }

        val answer: MutableList<Int> = mutableListOf()
        for (query in queries) {
            if (query.endsWith('?')) answer.add(searchMap(wordMap, query))
            else answer.add(searchMap(wordMapReverse, query.reversed()))
        }
        return answer.toIntArray()
    }

    private fun getMap(map: MutableMap<Int, Trie>, word: String) {
        val n: Int = word.length
        if (!map.containsKey(n)) map[n] = Trie(count = 0)

        var node: Trie = map[n]!!
        node.count++
        for (c in word) {
            if (!node.child!!.containsKey(c)) node.child!![c] = Trie(count = 0)
            node.child!![c]!!.count++
            node = node.child!![c]!!
        }
    }

    private fun searchMap(map: MutableMap<Int, Trie>, query: String): Int {
        val n: Int = query.length
        if (!map.containsKey(n)) return 0

        var node: Trie = map[n]!!
        for (c in query){
            when{
                c == '?' -> return node.count
                !node.child!!.containsKey(c) -> return 0
            }
            node = node.child!![c]!!
        }
        return 0
    }
}
*/

fun main() {
    /*
    class Trie {
        var next = HashMap<Char, Trie>()
        var wordLen = HashMap<Int, Int>()

        fun insert(word: String, len: Int, idx: Int, flag: Int) {
            if (word.length == idx || idx < 0) return
            if (word[idx] == '?') return

            wordLen[len] = wordLen.getOrDefault(len, 0) + 1

            val ch = word[idx]

            if (!next.containsKey(ch)) next[ch] = Trie()
            if (flag == 0) next[ch]!!.insert(word, len, idx + 1, 0) else next[ch]!!.insert(word, len, idx - 1, 1)
        }

        fun find(query: String, len: Int, idx: Int, flag: Int): Int {
            if (query.length == idx || idx < 0) return 0
            if (query[idx] == '?') return wordLen.getOrDefault(len, 0)

            val ch = query[idx]

            if (!next.containsKey(ch)) return 0

            return if (flag == 0) next[ch]!!.find(query, len, idx + 1, 0) else next[ch]!!.find(query, len, idx - 1, 1)
        }
    }

    fun solution(words: Array<String>, queries: Array<String>): IntArray {
        val answer = IntArray(queries.size)
        val root = Trie() //문자열을 앞
        val tail = Trie() //문자열을 뒤

        for (word in words) {
            root.insert(word, word.length, 0, 0)
            tail.insert(word, word.length, word.length - 1, 1)
        }

        var idx = 0
        for (query in queries) {
            if (query[0] != '?') answer[idx++] = root.find(query, query.length, 0, 0)
            else answer[idx++] = tail.find(query, query.length, query.length - 1, 1)
        }
        return answer
    }
    */
}
/*
fun main() {
    class TrieNode {
        val child = mutableMapOf<Char, TrieNode>()
        var count = 1
    }
    class Trie {
        val root =TrieNode()
        init {
            this.root.count = 0
        }

        fun add(n: String) {
            var temp = this.root
            root.count++

            for(c in n) {
                val temp2 = temp.child[c]
                temp = temp2?.apply { count++ } ?: temp.child.computeIfAbsent(c)
            }
        }

        fun get(n: String): TrieNode? {
            var temp = this.root
            for((i, j) in n.withIndex()) {
                val node = temp.child[j] ?: return null
                temp = node
            }
            return temp
        }
    }
    fun solution(words: Array<String>, queries: Array<String>): IntArray {
        val answer = IntArray(queries.size) {0}
        val tries = mutableMapOf<Int, Trie>()
        val reverseTries = mutableMapOf<Int, Trie>()

        for (word in words) {
            val wordLength = word.length
            tries[wordLength]?.add(word) ?: tries.put(wordLength, Trie().also { it.add(word) })
        }

        for (word in words) {
            val wordLength = word.length
            reverseTries[wordLength]?.add(word.reversed()) ?: reverseTries.put(wordLength, Trie().also { it.add(word.reversed()) })
        }

        for ( (index, query) in queries.withIndex() ) {
            val queryWithNoWildCard = query.replace("?", "")
            val queryLength = query.length

            when {
                queryWithNoWildCard.isEmpty() -> {
                    answer[index] = tries[queryLength]?.root?.count ?: 0
                }
                query.startsWith('?') -> {
                    answer[index] = reverseTries[queryLength]?.let { it.get(queryWithNoWildCard.reversed())?.count ?: 0 } ?: 0
                }
                else -> {
                    answer[index] = tries[queryLength]?.let { it.get(queryWithNoWildCard)?.count ?: 0 } ?: 0
                }
            }

        }

        return answer
    }
}
*/
