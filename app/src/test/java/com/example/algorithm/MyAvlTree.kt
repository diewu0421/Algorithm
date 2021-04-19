package com.example.algorithm

import org.junit.Test
import kotlin.math.abs

/**
 * 浙江集商优选电子商务有限公司
 * @author zenglw
 * @date   4/8/21 1:01 AM
 */
class MyAvlTree<T : Comparable<T>> {
    var root: TreeNode<T>? = null

    fun leftRotate(x: TreeNode<T>?) {
        x ?: return
        // 将y上的左孩子上的东西赋值给x的右孩子
        var y = x.right
        x.right = y?.left
        y?.left?.parent = x

        // 将y指定一个parent 有可能是parent的right 也有可能是parent的left
        when {
            x.parent?.left == x -> {
                x.parent?.left = y
            }
            //

            x.parent?.right == x -> {
                x.parent?.right = y
            }

            x.parent == null -> {
                root = y
            }
        }

        // 将y的parent修改为x
        y?.left = x
        x.parent = y

    }

    @Test
    fun test() {
        val myAvlTree = MyAvlTree<Int>()
//        myAvlTree.root = TreeNode(data = 3).apply {
//            left = TreeNode(data = 2, parent = this).apply {
//                left = TreeNode(data = 1, parent = this).apply {
//
//                }
//            }
//        }


//        Integer[] nums = {5, 8, 3, 1, 2, 0};
        // RL型
        val nums = arrayOf(10, 8, 15, 18, 13, 12)

        nums.forEach {
            myAvlTree.insert(it)
        }


//        myAvlTree.rightRotate(myAvlTree.root)

        myAvlTree.showAvlTree(myAvlTree.root)
    }

    fun showAvlTree(root: TreeNode<T>?) {
        TreeOperation.show(root)
    }

    fun rightRotate(y: TreeNode<T>?) {
        y ?: return
        // 将y上的左孩子上的东西赋值给x的右孩子
        var x = y.left
        y.left = x?.right
        x?.right?.parent = y

        // 将y指定一个parent 有可能是parent的right 也有可能是parent的left
        when {
            y.parent?.left == y -> {
                y.parent?.left = x
            }

            y.parent?.right == y -> {
                y.parent?.right = x
            }

            y.parent == null -> {
                root = x
            }
        }

        // 将y的parent修改为x
        x?.right = y
        y.parent = x

    }

    /**
     * @param root 失衡节点
     */
    fun leftBalance(t: TreeNode<T>?) {
        val tl = t?.left
        when (tl?.balance) {
            LH -> {
                // 直接对root节点进行右旋操作即可达到平衡
                rightRotate(t)
                t.balance = EH
                tl.balance = EH
            }
            RH -> {
                val tlr = tl.right
                when (tlr?.balance) {

                    LH -> {
                        t.balance = RH
                        tl.balance = EH
                        tlr.balance = EH
                    }

                    RH -> {
                        t.balance = EH
                        tl.balance = LH
                        tlr.balance = EH
                    }
                }
                leftRotate(tl)
                rightRotate(t)
            }
        }
    }

    fun rightBalance(t: TreeNode<T>?) {
        val tr = t?.right
        when (tr?.balance) {
            RH -> {
                // 直接对root节点进行右旋操作即可达到平衡
                leftRotate(t)
                t.balance = EH
                tr.balance = EH
            }
            LH -> {
                val trl = tr.left
                when (trl?.balance) {

                    LH -> {
                        t.balance = EH
                        tr.balance = RH
                        trl.balance = EH
                    }

                    RH -> {
                        t.balance = LH
                        tr.balance = EH
                        trl.balance = EH

                    }

                }
                rightRotate(tr)
                leftRotate(t)
            }
        }
    }

    fun insert(data: T): Boolean {
        if (root == null) {
            root = TreeNode(data = data)
            return true
        }

        var cmp = 0
        val tempData = data as Comparable<T>
        var parent: TreeNode<T>? = null
        var pointer = root
        while (pointer != null) {
            parent = pointer
            cmp = tempData.compareTo(parent.data!!)
            when {
                cmp > 0 -> {
                    pointer = pointer.right
                }

                cmp == 0 -> {
                    // 如果相等 则不进行插入
                    return false
                }

                cmp < 0 -> {
                    pointer = pointer.left
                }
            }
        }
        // 此时pointer为null 而parent即为要插入的元素的父节点
        val newNode = TreeNode(data = data, parent = parent, balance = 0)
        if (cmp > 0) {
            parent?.right = newNode
        } else if (cmp < 0) {
            parent?.left = newNode

        }
        // 此时新的节点已经插入到树中，回溯到失衡节点
        // 开始回溯
        while(parent != null) {
            cmp = parent.data?.let { tempData.compareTo(it) } ?: 0
            if (cmp > 0) {
                parent.balance--
            } else if (cmp < 0) {
                parent.balance++
            }
            if (parent.balance == 0) {
                break
            }
            if (abs(parent.balance) != 2) {
                parent = parent.parent
            } else {
                balance(parent)
                break
            }
        }

        size ++
        return true
    }

    private fun balance(notBalanceNode: TreeNode<T>) {

        if (notBalanceNode.balance == 2) {
            leftBalance(notBalanceNode)
        }

        if (notBalanceNode.balance == -2) {
            rightBalance(notBalanceNode)
        }

    }

    private var size = 0


    companion object {
        const val LH = 1
        const val EH = 0
        const val RH = -1
    }
}

