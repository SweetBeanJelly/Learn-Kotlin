package LeetCode

/*
 트리의 height 구하기
*/

class TreeNode(val data: Int, val left: TreeNode? = null, val right: TreeNode? = null)

fun main() {
    print(maxDepth(TreeNode(3,TreeNode(9),TreeNode(20, TreeNode(15),TreeNode(7)))))
}

fun maxDepth(root: TreeNode?): Int {
    return goDepth(root, 0)
}

fun goDepth(node: TreeNode?, depth: Int): Int {
    node ?: return depth
    return maxOf(goDepth(node.left, depth + 1), goDepth(node.right, depth + 1))
}