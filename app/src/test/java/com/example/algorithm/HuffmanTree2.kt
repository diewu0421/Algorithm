package com.example.algorithm

import android.graphics.drawable.LevelListDrawable
import org.junit.Test
import java.util.LinkedList

/**
 * 浙江集商优选电子商务有限公司
 * @author zenglw
 * @date   4/6/21 1:20 AM
 */
class HuffmanTree2 {

    @Test
    fun test() {
        val huffmanTree2 = HuffmanTree2()

        val list = arrayListOf(
            TreeNode("goo1111d", 50),
            TreeNode("morning", 10),
            TreeNode("afternoon", 20),
            TreeNode("hell", 110),
            TreeNode("hi", 200)
        )

        huffmanTree2.createHuffmanTree(list)

        huffmanTree2.showHuffmanTree(huffmanTree2.root)

    }


    fun <T> showHuffmanTree(root: TreeNode<T>?) {
        val linkedList = LinkedList<TreeNode<T>?>()
        linkedList.offer(root)

        while (linkedList.isNotEmpty()) {
            val ele = linkedList.poll()
            println(ele?.data)
            if (ele?.left != null) {
                linkedList.offer(ele.left)

            }
            if (ele?.right != null) {
                linkedList.offer(ele.right)
            }

        }


    }

    fun createHuffmanTree(list: ArrayList<TreeNode<String>>): TreeNode<String>? {
        while (list.size > 1) {
            list.sort()
            val left = list[list.size - 1]
            val right = list[list.size - 2]
            val parent = TreeNode("p", left.weight + right.weight)
            parent.left = left
            parent.right = right
            left.parent = parent
            right.parent = parent
            list.remove(left)
            list.remove(right)
            list.add(parent)
        }

        root = list.last()
        return root
    }

    private var root: TreeNode<String>? = null

    inner class TreeNode<T>(
        var data: T,
        var weight: Int
    ) : Comparable<TreeNode<T>> {

        var left: TreeNode<T>? = null
        var right: TreeNode<T>? = null
        var parent: TreeNode<T>? = null

        override fun compareTo(other: TreeNode<T>): Int {
            if (weight < other.weight) {
                return -1
            } else if (weight > other.weight) {
                return 1
            }
            return 0
        }

    }
}