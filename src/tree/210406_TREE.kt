package tree

/*
// 트리
fun main() {
    class Node(val data: Int, var left: Node? = null, var right: Node? = null)
    class Tree(val root: Node)

    val tree = Tree(Node(5))
    tree.root.left = Node(3, null, Node(4))
    tree.root.right = Node(7)
}
*/

// 순회
fun main() {
    class Node(val data: Char, val left: Node? = null, val right: Node? = null)
    class Tree(val root: Node){
        //preorder
        fun preorder(){
            fun preorderInternal(node:Node){
                print("${node.data} ")
                if(node.left!=null) preorderInternal(node.left)
                if(node.right!=null) preorderInternal(node.right)
            }
            preorderInternal(root)
            println()
        }
        //inorder
        fun inorder(){
            fun inorderInternal(node:Node){
                if(node.left!=null) inorderInternal(node.left)
                print("${node.data} ")
                if(node.right!=null) inorderInternal(node.right)
            }
            inorderInternal(root)
            println()
        }
        //postorder
        fun postorder(){
            fun postorderInternal(node:Node){
                if(node.left!=null) postorderInternal(node.left)
                if(node.right!=null) postorderInternal(node.right)
                print("${node.data} ")
            }
            postorderInternal(root)
            println()
        }
    }

    val tree = Tree(Node('A',Node('B',Node('D'),Node('E')),Node('C',Node('F'),Node('G'))))
    print("preorder result : ")
    tree.preorder()
    print("inorder result : ")
    tree.inorder()
    print("postorder result : ")
    tree.postorder()
}
