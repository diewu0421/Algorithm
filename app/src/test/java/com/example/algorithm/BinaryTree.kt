package com.example.algorithm

import org.junit.Test
import java.util.*
import java.util.LinkedList
import java.util.concurrent.atomic.AtomicInteger
import kotlin.collections.ArrayList
import kotlin.math.abs
import kotlin.math.max
import kotlin.math.min

/**
 * 浙江集商优选电子商务有限公司
 * @author zenglw
 * @date   4/6/21 2:28 PM
 */
class BinaryTree {

    var root: TreeNode<Int>? = null


    fun createTree(): TreeNode<Int> {

//        root = TreeNode(data = 3).apply {
//            left = TreeNode(data = 9)
//
//            right = TreeNode(data = 20).apply {
//                left = TreeNode(data = 15).apply {
////                    left = TreeNode(-1).apply {
////                        left = TreeNode(-2)
////                    }
//                }
//
//                right = TreeNode(data = 7).apply {
////                    right =TreeNode(data = 4).apply {
////                        left = TreeNode(77)
////                    }
//                }
//            }
//
//        }
//        return root


//        return TreeNode(
//            data = 1,
//            right = TreeNode(
//                data = 2,
//                left = TreeNode(
//                    data = 7,
//                    right = TreeNode(data = 8)
//                ),
//                right = TreeNode(
//                    data = 3,
//                    right = TreeNode(
//                        data = 4,
//                        right = TreeNode(data = 5)
//
//                    )
//                )
//            )
//        )


        return TreeNode(
            data = 1,
            left = TreeNode(
                data = 10,
                right = TreeNode(data = 3)
            ),
            right = TreeNode(
                data = 2,
//                left = TreeNode(
//                    data = 7,
//                    right = TreeNode(data = 8),
//                    left = TreeNode(data = 9)

//                ),
//                right = TreeNode(
//                    data = 3,
//                    right = TreeNode(
//                        data = 4,
//                        right = TreeNode(data = 5)
//
//                    )
//                )
            )
        )
    }


    @Test
    fun buildTree() {

        createTree()?.apply {
            getInorder(this)
            buildBLR(0, list.size - 1).show()

        }
    }

    private val list: ArrayList<TreeNode<Int>> = ArrayList()


    fun getInorder(root: TreeNode<Int>?) {
        root?: return
        if (root.left != null) {
            getInorder(root.left)
        }
        list.add(root)

        if (root.right != null) {
            getInorder(root.right)
        }
    }

    fun buildBLR(l: Int, r: Int) : TreeNode<Int> {

        val mid = (l + r).shr(1)
        val newTreeNode = TreeNode(data = list[mid].data)
        if (l <= mid - 1) {

            newTreeNode.left = buildBLR(0, mid - 1)

        }

        if (r >= mid + 1) {
            newTreeNode.right = buildBLR(mid + 1, r)

        }
        return newTreeNode

    }

    fun printTree(root: TreeNode<Int>?) {

        if (root == null) {

        } else {
            printTree(root.left)
            print("${root.data} ")
            printTree(root.right)
        }


    }

    fun printTree2(root: TreeNode<Int>?) {
        val list = LinkedList<TreeNode<Int>>()
        list.offer(root)

        while (list.isNotEmpty()) {
            val item = list.pop()
            print("${item.`val`} ")
            if (item.left != null) {
                list.offer(item.left)

            }
            if (item.right != null) {
                list.offer(item.right)
            }
        }
    }

    @Test
    fun test(){
        println("test")

        createTree()
//        printTree2(root)
        TreeOperation.show(root)
        val auto = AtomicInteger()
//        println("\n" + height(root))
        println("\n" + isBalance2(root) + "  ${aoto.get()}")

//        println()
//        createMirrorTree(root)
//        mirrorTree(root)
//        printTree(root)

    }
    private val aoto = AtomicInteger()

    fun isBalance(root: TreeNode<Int>?): Boolean {
        if (root == null) {
            return true
        }

        if (abs(height(root.left) - height(root.right)) > 1) {
            return false
        }

        return isBalance(root.left) && isBalance(root.right)
    }

    private fun isBalance2(root: TreeNode<Int>?): Boolean {
        return height2(root) >=0
    }

    private fun height2(root:TreeNode<Int>?) : Int {
        aoto.incrementAndGet()
        if (root== null) {
            return 0
        }
        val leftHeight = height2(root.left)
        if (leftHeight == -1) {
            return -1
        }

        val rightHeight = height2(root.right)
        if (rightHeight == -1) {
            return -1
        }
        if (abs(leftHeight - rightHeight) > 1) {
            return -1
        }
        return max(leftHeight, rightHeight) + 1
    }

    private fun height(root: TreeNode<Int>?): Int {
        aoto.incrementAndGet()
        root ?: return 0
        return max(height(root.left), height(root.right)) + 1
    }

    fun dfs(root: TreeNode<Int>?, auto: AtomicInteger): Int {

        if (root == null) return 0


        val result = auto.incrementAndGet()

        return dfs(root.left, auto) + 1

    }

    private fun createMirrorTree(root: TreeNode<Int>?) {
        if (root != null) {
            createMirrorTree(root.left)
            createMirrorTree(root.right)
            val temp = root.left
            root.left = root.right
            root.right = temp
        }

    }

    private fun mirrorTree(root: TreeNode<Int>?) {

//        var TreeNode1 = root
        val stack = Stack<TreeNode<Int>>()

        stack.push(root)
        while (stack.isNotEmpty()) {

            val TreeNode = stack.pop()

//            if (TreeNode.left != null) {
//                stack.push(TreeNode.left)
//            }
            val temp = TreeNode.left
            TreeNode.left = TreeNode.right
            TreeNode.right = temp

            if (TreeNode.left != null) {
                stack.push(TreeNode.left)

            }
            if (TreeNode.right != null) {
                stack.push(TreeNode.right)
            }

        }

    }

    @Test
    fun test111() {
        println("minhIehgt = ${minHeight(createTree())}")
    }
    fun minHeight(root: TreeNode<Int>?): Int {
        root ?: return 0

        var minHeight = Int.MAX_VALUE

        if (root.left == null && root.right == null) {
            return 1

        }
        if (root.left != null) {
            minHeight = min(minHeight, minHeight(root.left))

        }

        if (root.right != null ) {
            minHeight = min(minHeight, (minHeight(root.right)))

        }

        return minHeight + 1

    }

}
fun <T : Comparable<T>> TreeNode<T>.show() {
    TreeOperation.show(this)
}
