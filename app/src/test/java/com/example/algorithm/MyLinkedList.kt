package com.example.algorithm

/**
 * 浙江集商优选电子商务有限公司
 * @author zenglw
 * @date   3/30/21 12:27 AM
 */
class MyLinkedList<E> {
    class Node<E>(var prev: Node<E>?, var value: E, var next: Node<E>?)

    var size = 0
    var first: Node<E>? = null
    var last: Node<E>? = null
    fun add(e: E) {
        linkLast(e)
    }

    private fun linkLast(e: E) {
        val newNode: Node<E> = Node<E>(last, e, null)
        val l = last
        last = newNode
        if (l == null) {
            first = newNode
        } else {
            l.next = newNode
        }
        size++
    }

    operator fun get(index: Int): E? {
        require(!(index < 0 || index >= size)) { "asdfadf" }
        val node = node(index)
        return node?.value
    }

    private fun ensureScope(index: Int) {
        require(!(index < 0 || index >= size)) { "asdfadf" }
    }

    private fun node(index: Int): Node<E>? {
        require(!(index < 0 || index >= size)) { "asdfadf" }
        return if (index < (size shr 1)) {
            var node: Node<E>? = first

            for (i in 0 until index) {
                node = node?.next
            }
            node
        } else {
            var node:Node<E>? = last
            for (i in (size - 1) downTo (index + 1)) {

                node = node?.prev
            }
//                for (i in size - 1 downTo index) {
//                    node = node?.prev
//                }
            node
        }
    }

    fun add(index: Int, e: E) {
        if (index == size) {
            linkLast(e)
        } else {
            val target: Node<E>? = node(index)
            val prev = target!!.prev
            val newNode: Node<E> = Node(prev, e, target)
            if (prev == null) {
                first = newNode
                target.prev = newNode
            } else {
                prev.next = newNode
                target.prev = newNode
            }
            size++
        }
    }
}
