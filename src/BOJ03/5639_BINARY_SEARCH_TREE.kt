package BOJ03

/*
fun main() {
    class BinaryTree(var data: Int) {
        var left: BinaryTree? = null
        var right: BinaryTree? = null
        fun addTree(tree: BinaryTree?, value: Int): BinaryTree {
            var curTree: BinaryTree? = null
            if (tree == null) return BinaryTree(value)
            if (tree.data > value) {
                curTree = addTree(tree.left, value)
                tree.left = curTree
            } else if (tree.data < value) {
                curTree = addTree(tree.right, value)
                tree.right = curTree
            }
            return tree
        }
    }
    var tree = BinaryTree(readLine()!!.toInt())
    var s = ""
    while (readLine().also { if (it != null) s = it } != null && s.isNotEmpty()) {
        tree = tree.addTree(tree, s.toInt())
    }
    val sb = StringBuilder()
    fun postorder(tree: BinaryTree?) {
        if (tree!!.left != null) postorder(tree.left)
        if (tree.right != null) postorder(tree.right)
        sb.append("${tree.data}\n")
    }
    postorder(tree)
    print(sb)
}
*/

/*
fun main() {
    var tree: Node? = null
    while (true) {
        val line = readLine() ?: break
        val num = line.trim().toInt()
        tree = insertNode(tree, num)
    }
    postOrder(tree)
}

private fun insertNode(tree: Node?, item: Int): Node {
    if (tree == null) {
        return Node(null, item, null)
    } else {
        if (item < tree.item) {
            tree.left = insertNode(tree.left, item)
        }
        if (item > tree.item) {
            tree.right = insertNode(tree.right, item)
        }
        return tree
    }
}

private fun postOrder(tree: Node?) {
    if (tree == null) return
    postOrder(tree.left)
    postOrder(tree.right)
    println(tree.item)
}

data class Node(var left: Node?, var item: Int, var right: Node?)
*/
