package tree

fun main() {
    class Node(val data: Char, val left: Node? = null, val right: Node? = null)

    fun inorder(root: Node?): List<Char> = root?.let {
        inorder(root.left) + root.data + inorder(root.right)
    } ?: listOf()
    fun postorder(root: Node?): List<Char> = root?.let {
        postorder(root.left) + postorder(root.right) + root.data
    } ?: listOf()

    val test = Node('A',Node('B',Node('D'),Node('E')),Node('C',Node('F'),Node('G')))

    println(inorder(test))
    println(postorder(test))
}