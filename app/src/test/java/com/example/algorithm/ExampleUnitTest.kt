package com.example.algorithm

import org.junit.Test
import java.io.File
import java.io.FileOutputStream
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashSet
import kotlin.math.max
import kotlin.math.min
import kotlin.system.measureTimeMillis

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {

    @Test
    fun testAlgorithm() {

        val nums = intArrayOf(1, 2, 5, 8, 3, 9, 4, 6, 7)
        // bubbleSort(nums);
        // bubbleSort(nums);
//        selectSort2(nums)
        selectSort(nums)

        println(nums.contentToString())

    }

    fun selectSort(array: IntArray) {
        var count = 0
        for (i in 0 until array.size - 1) {
            var index = i
            for (j in i + 1 until array.size) {
                count++
                if (array[j] < array[index]) {
                    index = j
                }

            }
            if (index != i) {
                val temp = array[i]
                array[i] = array[index]
                array[index] = temp
            }

        }
        println("count = $count")

    }

    fun selectSort2(array: IntArray) {
        var count = 0
        for (i in 0 until array.size - 1) {
            var index = i
            for (j in i + 1 until array.size) {
                count++
                if (array[j] < array[index]) {
                    index = j
                }
            }
            //{1,2,5,8,3,9,4,6,7};
            if (index != i) { //如果已经是最小的，就不需要交换
                val temp = array[index]
                array[index] = array[i]
                array[i] = temp
            } else {
//                break;
            }
        }
        println("count = $count")
    }

    @Test
    fun testLinkedList() {

        val linkedList = LinkedList<Int>()
        linkedList.add(0, 4)
        linkedList.add(0, 1)
//        linkedList.add(0, 2)
//        linkedList.add(0, 3) //43  66 12
//
//        linkedList.add(0, 66)
//        linkedList.add(0, 88)
        //0:66    1:4    2:3    3:1    4:2
//        linkedList.remove(0);

        //0:66    1:4    2:3    3:1    4:2
//        linkedList.remove(0);
        for (i in 0 until linkedList.size) {
            print(i.toString() + ":" + linkedList[i] + "    ")
        }

    }

    @Test
    fun testMyLinkedList() {


        // int[] nums = new int[]{1, 2, 5, 8, 3, 9, 4, 6, 7};
        // bubbleSort(nums);
        // selectSort(nums);

        // System.out.println(Arrays.toString(nums));
        // testBytecode();
        //
        // LinkedList<Mahjong> list=new LinkedList<Mahjong>();
        // list.add(new Mahjong(3,1));
        // list.add(new Mahjong(2,3));
        // list.add(new Mahjong(3,7));
        // list.add(new Mahjong(1,1));
        // list.add(new Mahjong(3,8));
        // list.add(new Mahjong(2,2));
        // list.add(new Mahjong(3,2));
        // list.add(new Mahjong(1,3));
        // list.add(new Mahjong(3,9));
        // System.out.println(list);
        // radixSort(list);
        // System.out.println(list);
        val linkedList: MyLinkedList<Int> = MyLinkedList()
        linkedList.add(0, 4)
        linkedList.add(0, 1)
        linkedList.add(0, 2)
        linkedList.add(0, 3) //43  66 12

        linkedList.add(0, 66)
        linkedList.add(0, 88)
        //0:66    1:4    2:3    3:1    4:2
//        linkedList.remove(0);

        //0:66    1:4    2:3    3:1    4:2
//        linkedList.remove(0);
        for (i in 0 until linkedList.size) {
            print(i.toString() + ":" + linkedList[i] + "    ")

        }


    }

    @Test
    fun mirrorBinaryTree() {


    }

    @Test
    fun test() {
        val graph = MyGraph(5)
        val v0 = intArrayOf(0, 1, 1, Graph.MAX_WEIGHT, Graph.MAX_WEIGHT)
        val v1 = intArrayOf(Graph.MAX_WEIGHT, 0, Graph.MAX_WEIGHT, 1, Graph.MAX_WEIGHT)
        val v2 =
            intArrayOf(Graph.MAX_WEIGHT, Graph.MAX_WEIGHT, 0, Graph.MAX_WEIGHT, Graph.MAX_WEIGHT)
        val v3 = intArrayOf(1, Graph.MAX_WEIGHT, 1, 0, 1)
        val v4 = intArrayOf(Graph.MAX_WEIGHT, Graph.MAX_WEIGHT, 1, Graph.MAX_WEIGHT, 0)
        graph.matrixs[0] = v0
        graph.matrixs[1] = v1
        graph.matrixs[2] = v2
        graph.matrixs[3] = v3
        graph.matrixs[4] = v4
        graph.dfs(0)
    }

    @Test
    fun intConverse() {
        var rect = 0
        val x = 123

        while (x != 0) {
            val p = x % 10

        }
    }

    @Test
    fun danDiaoDiZeng() {

        val array = intArrayOf(3, 4, 2, 3)

        println("count = ${test665(array)}")

    }

    fun test665(intArray: IntArray): Boolean {


        var count = 0
        for (i in 1 until intArray.size) {

            if (intArray[i] < intArray[i - 1]) {
                count++

                if (count >= 2) {
                    return false
                }
                // 出现拐点
                if (i - 2 >= 0 && intArray[i - 2] > intArray[i]) {

                    intArray[i] = intArray[i - 1]
                } else {

                    intArray[i - 1] = intArray[i]

                }
            }
        }
        return count < 2

    }

    fun test111(root: TreeNode<Int>) {

    }

    @Test
    fun test3() {

        println(test3_("pwwkew"))  // 3
        println(test3_("abcabcbb")) //3
        println(test3_("abcabcbbefgh")) //5

    }

    fun test3_(str: String): Int {
        val map = HashSet<Char>()
        var rk = -1
        var length = 0

        for ((index, c) in str.withIndex()) {
            if (index != 0) {
                map.remove(str[index - 1])
            }

            while (rk + 1 < str.length && !map.contains(str[rk + 1])) {
                map.add(str[rk + 1])
                rk++
            }

            length = Math.max(length, rk - index + 1)

        }
        return length

    }

    @Test
    fun test9() {
        // 121
        fun isPalindrome(x: Int): Boolean {

            if (x < 0) {
                return false
            }
            if (x / 10 == 0) {
                return true
            }
            val list = arrayListOf<Int>()

            var temp = x
            while (temp != 0) {
                val mod = temp % 10
                list.add(mod)
                temp /= 10
            }
            println(list)
            var k = list.size - 1

            for ((index, value) in list.withIndex()) {

                if (index > k) {
                    return true
                }
                if (value != list[k]) {
                    return false
                } else {
                    k--
                }
            }
            return true
        }

        fun isPalindrome2(x: Int): Boolean {

            if ((x % 10 == 0 && x != 0) || x < 0) {
                return false
            }

            var reverseNumber = 0
            var tempX = x
            while (tempX > reverseNumber) {
                reverseNumber = reverseNumber * 10 + tempX % 10

                tempX /= 10
            }
            return tempX == reverseNumber / 10 || tempX == reverseNumber

        }
        println(isPalindrome2(1000021))
        println(isPalindrome2(0))
        println(isPalindrome2(121))

    }

    @Test
    fun test13() {
        fun romanToInt(s: String): Int {
            var i = 0
            val n = s.length
            var sum = 0

            while (i < n) {
                val c = s[i]
                sum += when (c) {
                    'I' -> {
                        // 看右边是否有V或者X
                        if (i + 1 < n && (s[i + 1] == 'V' || s[i + 1] == 'X')) {
                            -1
                        } else {
                            1
                        }
                    }
                    'X' -> {
                        //判断右边有没有 L C
                        if (i + 1 < n && (s[i + 1] == 'L' || s[i + 1] == 'C')) {
                            -10
                        } else {
                            10
                        }
                    }
                    'C' -> {

                        if (i + 1 < n && (s[i + 1] == 'D' || s[i + 1] == 'M')) {
                            -100
                        } else {
                            100
                        }
                    }
                    'L' -> 50
                    'D' -> 500
                    'M' -> 1000
                    'V' -> 5
                    else -> 0
                }
                i++
            }

            return sum
        }
        println(romanToInt("MCMXCIV"))

    }

    @Test
    fun test14() {
        fun longestCommonPrefix(strs: Array<String?>?): String {

            if (strs == null || strs?.isEmpty()) {
                return ""
            }
            strs.sort()
            val start = strs.first()
            start ?: return ""
            val end = strs.last()
            end ?: return ""
            val num = Math.min(strs.first()?.length ?: 0, strs.last()?.length ?: 0)

            var i = 0

            while (i < num && start[i] == end[i]) {
                i++
            }
            return start.substring(0, i)
        }
        println(longestCommonPrefix(arrayOf("flower", "flow", "flight")))
    }

    @Test
    fun test20() {
        fun isValid(s: String): Boolean {
            val stack = Stack<Char>()
            for (c in s) {
                if (stack.size > 0 && (c == ')' && '(' == stack.peek()
                            || c == ']' && '[' == stack.peek()
                            || c == '}' && '{' == stack.peek()
                            )
                ) {
                    stack.pop()
                } else {
                    stack.push(c)
                }
            }
            return stack.isEmpty()
        }
        println(isValid("([])"))
        println(isValid("(]"))
        println(isValid("(]{(})"))
    }

    @Test
    fun test26() {

        fun removeDuplicates(nums: IntArray): Int {
            // 1,1,2
            // 0,0,1,1,1,2,2,3,3,4
            if (nums.size < 2) {
                return nums.size
            }
            var k = 0

            for (i in 1 until nums.size) {
                if (nums[i] != nums[k]) {
                    k++
                    nums[k] = nums[i]
                }
            }
            return k + 1

        }

        println(removeDuplicates(intArrayOf(0, 0, 1, 1, 1, 2, 2, 3, 3, 4)))
    }

    @Test
    fun test5() {
        fun longestPalindrome(s: String): String {
            return ""
        }
        println(longestPalindrome(""))
    }


    @Test
    fun test102() {
        fun levelOrder(root: TreeNode<Int>?): List<List<Int>> {

            if (root == null) {
                return arrayListOf()
            }
            val list = arrayListOf<ArrayList<Int>>()
            val linkedList = java.util.LinkedList<TreeNode<Int>>()
            linkedList.offer(root)

            while (linkedList.isNotEmpty()) {

                val nodeList = arrayListOf<Int>()
                val size = linkedList.size
                for (i in 0 until size) {
                    val node = linkedList.pop()

                    nodeList.add(node.`val`)
                    node.left?.let {
                        linkedList.offer(node.left)
                    }
                    node.right?.let {
                        linkedList.offer(node.right)
                    }
                }
                list.add(nodeList)

            }
            return list
        }


        val createTree = BinaryTree().createTree()
        createTree.show()
//        println()
        BinaryTree().printTree(createTree)

        println(levelOrder(BinaryTree().createTree()))
    }

    @Test
    fun testFeibo() {
        val n = 70
        val array = LongArray(n)
        array[0] = 1
        array[1] = 1
        for (i in 2 until n) {
            array[i] = array[i - 1] + array[i - 2]
        }
        println(array[n - 1])

    }


    @Test
    fun test21() {
        /**
         * //输入：l1 = [2,4,5], l2 = [1,6,7]
         * //输入：l1 = [1,2,4], l2 = [1,3,4]
        //输出：[1,1,2,3,4,4]
         */
        fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode? {
            l1 ?: return l2
            l2 ?: return l1
            var tempL1 = l1
            var result = l1
            var tempL2 = l2
            while (tempL1 != null) {
                var val1 = tempL1.`val`
                var isEnd = false
                while (tempL2 != null) {
                    val val2 = tempL2.`val`

                    if (val1 <= val2) {
                        if (tempL1?.next == null) {
//                            tempL2.next = tempL1.next
                            tempL1?.next = tempL2
                            isEnd = true
                            break
                        } else if (tempL1?.next!!.`val` >= tempL2.`val`) {
                            val l2Next = tempL2.next
                            tempL2.next = tempL1?.next
                            tempL1?.next = tempL2
                            tempL2 = l2Next
//                            break
                        } else {
                            break
                        }
                    } else {
                        // 插在l2取出来一个插在l1的队首
                        val l2Next = tempL2.next
//                        tempL2 = tempL2.next
                        tempL2.next = tempL1
                        result = tempL2
                        tempL1 = tempL2
                        val1 = tempL1.`val`
                        tempL2 = l2Next
                    }
//                    tempL2 = tempL2.next
                }
                if (tempL2 == null || isEnd) {
                    break
                }
                tempL1 = tempL1?.next
            }
            return result

        }

        fun mergeTwoLists2(l1: ListNode?, l2: ListNode?): ListNode? {
            when {
                l1 == null -> {
                    return l2
                }
                l2 == null -> {
                    return l1
                }
                l1.`val` < l2.`val` -> {

                    l1.next = mergeTwoLists2(l1.next, l2)

                    return l1

                }
                else -> {

                    l2.next = mergeTwoLists2(l1, l2.next)
                    return l2
                }
            }
        }

        fun mergeTwoLists3(l1: ListNode?, l2: ListNode?): ListNode? {
            val preHead = ListNode(-1)

            var l1 = l1
            var l2 = l2
            var pre: ListNode? = preHead
            while (l1 != null && l2 != null) {
                if (l1.`val` <= l2.`val`) {
                    pre?.next = l1
                    l1 = l1.next
                } else {
                    pre?.next = l2
                    l2 = l2.next
                }
                pre = pre?.next
            }
            pre?.next = l1 ?: l2
            return preHead.next
        }
        println(
            mergeTwoLists3(
//                ListNode(5).apply {
////                    next = ListNode(4).apply {
////                        next = ListNode(5)
////                    }
//                },
//
//                ListNode(1).apply {
//                    next = ListNode(2).apply {
//                        next = ListNode(4)
//                    }
//                },

                ListNode(1).apply {
                    next = ListNode(2).apply {
                        next = ListNode(4)
                    }
                },

                ListNode(1).apply {
                    next = ListNode(3).apply {
                        next = ListNode(4)
                    }
                },
            )
        )

    }


    @Test
    fun test27() {
        fun removeElement(nums: IntArray, `val`: Int): Int {

            var k = -1
            for (i in 0 until nums.size) {
                if (`val` != nums[i]) {
                    k++
                    nums[k] = nums[i]
                } else {
//                    k++
                }
            }
            return k + 1
        }

        println(removeElement(intArrayOf(3, 2, 2, 3), 3))

    }

    fun strStr(haystack: String, needle: String): Int {
        if (needle.isEmpty()) {
            return 0
        }
        val needleLength = needle.length
        if (haystack.length < needleLength) {
            return -1
        }

        var i = 0
        var count = 0
        while (i < haystack.length) {
            if (haystack[i] != needle[0]) {
                i++
            } else {
                val res = i
                var isMatch = true
                var tempI = -1
                for (j in 1 until needleLength) {
                    count++
                    i++
                    if (i >= haystack.length) {
                        println("count = $count")

                        return -1
                    }
                    if (tempI == -1 && needle[0] == haystack[i]) {
                        // 记录一下这个首字符相同的
                        tempI = i
                    }
                    if (needle[j] != haystack[i]) {
                        isMatch = false
                        break
                    }
                }
                i = if (tempI != -1) tempI else i
                if (isMatch) {
                    println("count = $count")

                    return res
                }
            }
        }
        println("count = $count")

        return -1
    }

    fun strStr2(haystack: String, needle: String): Int {
        val hayStackLength = haystack.length

        val needleLength = needle.length

        if (needleLength == 0) return 0
        var count = 0
        for (i in 0..(hayStackLength - needleLength)) {
            for (j in 0 until needleLength) {
                count++

                if (needle[j] != haystack[i + j]) {
                    break
                }
                if (j == needleLength - 1) {
                    println("count = $count")
                    return i
                }
            }
        }
        println("count = $count")

        return -1

    }

    @Test
    fun test28() {


//        println(strStr("a", "a"))// 1
//        println(strStr("hello", "ll"))// 2
        println(strStr("mississippi", "issipi"))// - 1
        println(strStr2("mississippi", "issipi"))// - 1
//        println(strStr("aabaaabaaac", "aabaaac")) // 4

    }

    @Test
    fun test35() {
        fun searchInsert(nums: IntArray, target: Int): Int {

            var start = 0
            var end = nums.size - 1

            var mid: Int
            while (start <= end) {
                mid = (end + start) / 2
                if (nums[mid] > target) {
                    end = mid - 1
                } else if (nums[mid] < target) {

                    start = mid + 1
                } else {
                    return mid
                }
            }

            return end + 1
        }
        println(searchInsert(intArrayOf(1, 3, 5, 6), 2))

    }

    @Test
    fun test58() {
        fun lengthOfLastWord(s: String): Int {
            val strs = s.split(" ")
            var length = 0
            for (str in strs) {

                if (str.isNotEmpty()) {
                    length = str.length
                }
            }
            return length

        }

        fun lengthOfLastWord2(s: String): Int {
            val length = s.length
            var i = 0
            var start = 0
            var end = 0
            while (i < length) {
                if (s[i] != ' ') {
                    if ((i > 0 && s[i - 1] == ' ') || i == 0) {

                        start = i
                    }
                    if (i == length - 1) {
                        end = i + 1
                    }

                } else {

                    if (i > 0 && s[i - 1] != ' ') {
                        end = i
                    }
                }

                i++
            }


            return end - start

        }

        fun lengthOfLastWord3(s: String): Int {

            var count = 0
            for (i in s.length - 1 downTo 0) {
                if (s[i] == ' ') {

                    if (count == 0) {
                        continue
                    }
                    break
                }
                count++
            }
            return count


        }

        println(lengthOfLastWord3("Hello Worlddff  fdfssd"))
        println(lengthOfLastWord3(" "))
        println(lengthOfLastWord3("a "))
        println(lengthOfLastWord3(" ac  "))
    }

    @Test
    fun test19() {

        fun traversalNode(head: ListNode?) {
            if (head == null)
                return

            println(head.`val`)
            traversalNode(head.next)
        }

        fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {

//            traversalNode(head)
            val list = arrayListOf<ListNode>()
            var temp = head

            while (temp != null) {
                list.add(temp)
                temp = temp.next
            }
            if (list.size == 1 && n == 1) {
                return null
            }

            if (n == list.size) {
                val next = list[0].next
                list[0].next = null
                return next
            }

            var node: ListNode? = list[list.size - n - 1]
            node?.next = node?.next?.next
            traversalNode(head)
            return head
        }

        fun removeNthFromEnd2(head: ListNode?, n: Int): ListNode? {
            val dummy = ListNode(0)
            dummy.next = head

            val deque = java.util.LinkedList<ListNode>()
            var head = head

            while (head != null) {
                deque.push(head)
                head = head.next
            }
            for (i in 0 until n) {
                deque.pop()
            }

            val top = deque.peek()
            if (top != null) {
                top.next = top.next?.next
            }

            return dummy.next

        }

        fun removeNthFromEnd3(head: ListNode?, n: Int): ListNode? {
            val dummy = ListNode(0).also { it.next = head }
            var first = head
            var second: ListNode? = dummy

            for (i in 0 until n) {
                first = first?.next
            }
            while (first != null) {
                first = first.next
                second = second?.next
            }

            second?.next = second?.next?.next
            return dummy.next
        }

        fun removeNthFromEnd4(head: ListNode?, n: Int): ListNode? {
            val dummy = ListNode(0).also { it.next = head }
            var first = head
            var second: ListNode? = dummy
            var count = 0

            while (first != null) {
                first = first?.next
                if (count++ >= n) {
                    second = second?.next
                }
            }

            second?.next = second?.next?.next
            return dummy.next
        }

        fun testLinkedList() {
            val list = java.util.LinkedList<Int>()
//            list.push(1)
//            list.push(3)
//            list.push(5)
            list.add(1)
            list.add(3)
            list.add(5)

            for (i in 0 until list.size) {
                println("peek =${list.peek()}")
                list.remove()
            }
        }

//        testLinkedList()

        removeNthFromEnd4(
            ListNode(1).apply {
                next = ListNode(2).apply {

                    next = ListNode(3).apply {

                        next = ListNode(4).apply {

                            next = ListNode(5).apply {

                            }
                        }
                    }
                }
            },
            2
        )
    }


    @Test
    fun test70() {

        // 爬楼梯
        fun climbStairs(n: Int): Int {

            // 动态规划
            if (n <= 2) {
                return n
            }
            var a = 1
            var b = 2

            for (i in 2 until n) {
                val temp = b
                b += a
                a = temp
            }
            return b

        }

        println(climbStairs(4))
    }

    @Test
    fun testDongTaiGuiHua() {

        fun LCS(str1: String, str2: String): String {
            val arr = Array(str1.length + 1) { IntArray(str2.length + 1) }
            for (i in arr[0].indices) {
                arr[0][i] = 0
            }

            for (i in arr.indices) {
                arr[i][0] = 0
            }
            for (i in 1 until arr.size) {
                for (j in 1 until arr[i].size) {
                    if (str1[i - 1] == str2[j - 1]) {
                        // 左上角加1
                        arr[i][j] = arr[i - 1][j - 1] + 1
                    } else {
                        arr[i][j] = max(arr[i - 1][j], arr[i][j - 1])
                    }
                }
            }
            for (i in arr.indices) {
                for (element in arr[i]) {
                    print("${element} ")
                }
                println()
            }
            var i = str1.length - 1
            var j = str2.length - 1

            val stack = Stack<Char>()
            while (i >= 0 && j >= 0) {
                if (str1[i] == str2[j]) {
                    stack.push(str1[i])
                    i--
                    j--
                } else {

                    if (arr[i + 1][j + 1 - 1] > arr[i + 1 - 1][j + 1]) {
                        // 上面比左边要大
                        j--
                    } else {
                        i--
                    }
                }
            }

            var res = ""

            while (stack.isNotEmpty()) {
                res += stack.pop()
            }

            return res
        }

        println(LCS("ABCBDAB", "BDCABA"))
    }

    @Test
    fun test66() {
        TestJava().test11()

        fun plusOne(digits: IntArray): IntArray {
            val length = digits.size
            var carry = 0
            for (i in (length - 1) downTo 0) {
                if (i == length - 1) {
                    if (digits[i] + 1 > 9) {
                        digits[i] = (digits[i] + 1) % 10
                        carry = 1
                    } else {
                        digits[i] = digits[i] + 1
                        return digits
                    }
                } else {
                    val num = digits[i] + carry
                    digits[i] = num % 10
                    carry = if (num > 9) 1 else 0
                    if (carry == 0) {
                        return digits
                    }
                }
            }

            if (carry == 1) {
                // 需要进位
                val newArray = IntArray(digits.size + 1)
                digits.copyInto(newArray, 1, 0, digits.size - 1)
                newArray[0] = 1
                return newArray
            }
            return digits
        }

        println(plusOne(intArrayOf(8, 9, 9, 9)))
    }


    @Test
    fun test67() {
        val a = "10101"
        val b = "10111"
//        101100
        var i: Int = a.length - 1
        var j: Int = b.length - 1
        var carry = 0
        val builder = StringBuilder()
//        TestJava().test11()

        //循环相加两个字符串相同长度的低位数部分
        //循环相加两个字符串相同长度的低位数部分
        while (i >= 0 && j >= 0) {
            var sum = carry
            sum += a[i--] - '0'
            sum += b[j--] - '0'
            carry = sum / 2
            builder.append(sum % 2)
        }
        // 如果 a 还没遍历完成（a串比b串长），则继续遍历添加 a 的剩余部分
        // 如果 a 还没遍历完成（a串比b串长），则继续遍历添加 a 的剩余部分
        while (i >= 0) {
            val sum = carry + a[i--].toString().toInt() - 0
            carry = sum / 2
            builder.append(sum % 2)
        }
        // 如果 b 还没遍历完成（b串比a串长），则继续遍历添加 b 的剩余部分
        // 如果 b 还没遍历完成（b串比a串长），则继续遍历添加 b 的剩余部分
        while (j >= 0) {
            val sum: Int = carry + b[j--].toString().toInt() - 0
            carry = sum / 2
            builder.append(sum % 2)
        }
        //如果 carry 不等于0 还有个进位数没加进去，需要补充
        //如果 carry 不等于0 还有个进位数没加进去，需要补充
        if (carry == 1) {
            builder.append(carry)
        }
        //反转字符串获得正常结果
        //反转字符串获得正常结果
        builder.reverse()
        println(builder.toString())

    }

    @Test
    fun testKMP() {

        fun kmpNext(dest: String): IntArray {

            val next = IntArray(dest.length)
            next[0] = 0

            var i = 1
            var j = 0
            while (i < dest.length) {
                while (j > 0 && dest[i] != dest[j]) {
                    j = next[j - 1]
                }

                if (dest[i] == dest[j]) {
                    j++
                }
                next[i] = j
                i++
            }
            return next

        }

        val str = "ababcabcbababcabacaba"
        val dest = "ababcaba"
        val next = kmpNext(dest)

        var i = 0
        var j = 0

        var res = -1
        run {

            var count = 0
            while (i < str.length) {
                count++
                while (j > 0 && str[i] != dest[j]) {
                    j = next[j - 1]
                }

                if (str[i] == dest[j]) {
                    j++
                }
                if (j == dest.length) {
                    println("end $count")
                    res = i - j + 1
                    return@run
                }

                i++
            }
        }

        println("res = $res")

        println(strStr(str, dest))
        println("---------------")
        println(strStr2(str, dest))

    }

    @Test
    fun testArrayFront0() {

        val arr = arrayOf(1, 0, 3, 0, 5, 2, 0, 1)

        var i = 1
        var k = 0
        while (i < arr.size) {
            if (arr[i] == 0) {
                for (j in i downTo k + 1) {
                    arr[j] = arr[j - 1]
                }
                arr[k] = 0
                k++
            }
            i++
        }

        arr.forEach {
            print("$it ")
        }

        for (i in arr.indices) {

        }
    }

    @Test
    fun testFirstMid() {
//        val arr = arrayOf(1, 4, 3, 5, 6, 9, 8, 7)
        val arr = arrayOf(3, 5, 4, 2, 1, 6, 8, 7)


        val res = ArrayList<Int>()


//        for (i in arr.indices) {
//            var j =  0
//            while (j < i) {
//                if (arr[i] < arr[j]) {
//                    break
//                }
//                j++
//            }
//
//            if (i != j) continue
//
//            var k = arr.size - 1
//            while (k >i) {
//                if (arr[i] > arr[k]) {
//                    break
//                }
//                k--
//            }
//            if (k != i)  {
//                continue
//            }
//            res.add(arr[i])
//        }
        res.forEach {
            print("$it ")
        }

    }

    val I = 100000

    //邻接距阵
    var d: Array<IntArray> = arrayOf(
        intArrayOf(0, 2, 1, 5),
        intArrayOf(2, 0, 4, I),
        intArrayOf(1, 4, 0, 3),
        intArrayOf(5, I, 3, 0)
    )
    var p = arrayOf(
        intArrayOf(0, 1, 2, 3),
        intArrayOf(0, 1, 2, 3),
        intArrayOf(0, 1, 2, 3),
        intArrayOf(0, 1, 2, 3)
    )

    private fun floyd() {
        for (i in d.indices) {
            for (j in d.indices) {
                for (k in d.indices) {
                    if (d[i][k] + d[k][j] < d[i][j]) {
                        d[i][j] = d[i][k] + d[k][j]
                        p[i][j] = p[i][k]
                    }

                }
            }
        }

    }

    private fun printShortPath() {

        for (i in d.indices) {
            for (j in d.indices) {
                var k = p[i][j]
                println(
                    "V" + i + "->V" + j + " weight:" + d[i][j] + " path:" + i
                )
                while (k != j) {
                    println(">> $k")
                    k = p[k][j]
                }
                println()
            }
        }
    }


    @Test
    fun testFloyde() {
        floyd()
        printShortPath()
    }

    @Test
    fun add() {


        val file = File("/Users/apple/Desktop/test.txt")
        val fos = FileOutputStream(file)

        for (i in 0 until 10001) {
//            file.appendText("Zlw love xixi $i 年\n\n")
            fos.run {

                fos.write("Zlw love xixi $i 年\n".toByteArray())
            }

        }
        fos.close()
    }

    var array = arrayOf(
        intArrayOf(0, 1, 5, I, I, I, I, I, I),
        intArrayOf(1, 0, 3, 7, 5, I, I, I, I),
        intArrayOf(5, 3, 0, I, 1, 7, I, I, I),
        intArrayOf(I, 7, I, 0, 2, I, 3, I, I),
        intArrayOf(I, 5, 1, 2, 0, 3, 6, I, I),
        intArrayOf(I, I, 7, I, 3, 0, I, 5, I),
        intArrayOf(I, I, I, 3, 6, I, 0, 2, 7),
        intArrayOf(I, I, I, I, 9, 5, 2, 0, 4),
        intArrayOf(I, I, I, I, I, I, 7, 4, 0)
    )

    @Test
    fun dijkstra() {

        var k = 0
        val path = IntArray(array.size)
        val weight = array[0]
        val flag = BooleanArray(array.size)

        flag[0] = true

        for (v in array.indices) {
            var min = Int.MAX_VALUE
            // 在能走的节点中选择最近的一个节点
            for (i in 1 until array.size) {
                if (!flag[i] && weight[i] < min) {
                    min = weight[i]
                    k = i
                }
            }
            flag[k] = true

            for (i in array.indices) {

                if (!flag[i] && (min + array[k][i]) < weight[i]) {
                    weight[i] = min + array[k][i]
                    path[i] = k
                }
            }

        }

        println()
        for (i in path) {
            print("$i ")
        }
        println()
        for (i in weight.indices) {
            print("${weight[i]} ")
        }
        println()

        for (i in flag) {
            print("$i")
        }
        println()

        var v = 8
        while (v != 0) {
            print("${path[v]} ")
            v = path[v]
        }


    }

    @Test
    fun fruskal() {
        Kruskal(7).test()
    }

    @Test
    fun test53() {
        fun maxSubArray(nums: IntArray): Int {

            /*
            int pre = 0, maxAns = nums[0];
        for (int x : nums) {
            pre = Math.max(pre + x, x);
            maxAns = Math.max(maxAns, pre);
        }
        return maxAns;
             */
            var pre = 0
            var maxRes = nums[0]

            for (x in nums) {
                pre = Math.max(pre + x, x)
                maxRes = Math.max(pre, maxRes)
            }
            return maxRes

        }

        fun maxSubArray2(nums: IntArray): Int {
//            if(nums.length == 1){
//                return nums[0];
//            }
//            int maxSubArray = nums[0];
//            int sum = nums[0];
//            for(int i = 1; i < nums.length; i++){
//                //sum要想有资格继续壮大 就必须大于 0 否则还不如恢复0
//                sum = Math.max(sum,0);
//                sum += nums[i];
//                //maxSubArray始终取最大值
//                maxSubArray = Math.max(sum,maxSubArray);
//            }
//            return maxSubArray;
//        }

            if (nums.size === 1) {
                return nums[0]
            }
            var maxSubArray = nums[0]
            var sum = nums[0]
            for (i in 1 until nums.size) {
                //sum要想有资格继续壮大 就必须大于 0 否则还不如恢复0
                sum = Math.max(sum, 0)
                sum += nums[i]
                //maxSubArray始终取最大值
                maxSubArray = Math.max(sum, maxSubArray)
            }
            return maxSubArray
        }
        println(maxSubArray2(intArrayOf(-2, 1, -3, 4, -1, 2, 1, -5, 4)))
    }

    @Test
    fun testAvlTree() {
        val tree = AVLTree2<Int>()

        for (i in 1 until 15) {
            tree.insertElement(i)
        }
        tree.root.show()

    }

    @Test
    fun testt() {
        Testt.main(null)
    }

    @Test
    fun testTreeZhiJing() {

        fun height(node: TreeNode<Int>?): Int {
            if (node == null) return 0

            val lHeight = height(node.left)
            val rHeight = height(node.right)
//            if (lHeight== 0 || rHeight == 0) return lHeight + rHeight + 1
            return min(lHeight, rHeight) + 1

        }

        fun getZhi(node: TreeNode<Int>?): Int {
//            val leftHeight = height(node?.left)
//            val rightHeight = height(node?.right)
//            println("left $leftHeight right $rightHeight")
//            return leftHeight + rightHeight
            println(height(node))

            return height(node)
        }

        BinaryTree().createTree().apply {
            show()

//            println(height(this))
            getZhi(this)

        }
    }

    @Test
    fun testOffer53() {
        fun search(nums: IntArray, target: Int): Int {
//            var i = 0
//            var j = nums.size - 1
//            var right = -1
//
//            while (i <= j) {
//
//                val mid = (i + j) / 2
//
//                if (nums[mid] <= target) {
//                    i = mid + 1
//                } else {
//                    j = mid - 1
//                }
//            }
//
//
//            right = i
//            if (nums[j] != target) return 0
//
//            i = 0
//            while (i <= j) {
//
//                val mid = (i + j) / 2
//
//                if (nums[mid] < target) {
//                    i = mid + 1
//                } else {
//                    j = mid - 1
//                }
//            }
//
//            val left = j
//
//            return right - left - 1

            fun search(target: Int): Int {
                var i = 0
                var j = nums.size - 1
                while (i <= j) {
                    val mid = (i + j) / 2
                    if (nums[mid] <= target) {
                        i = mid + 1
                    } else {
                        j = mid - 1
                    }
                }
                return i
            }
            return search(target) - search(target - 1)

        }
        println(search(intArrayOf(5, 6, 6, 8, 8, 8, 10), 8))

    }

    @Test
    fun testDump() {
        val array = intArrayOf(45, 36, 18, 53, 72, 30, 48, 93, 15, 35)

        //把list中的a,b位置的值互换
        fun swap(heap: IntArray, a: Int, b: Int) {
            //临时存储child位置的值

            //把index的值赋给child的位置
//            heap[a] = heap[b]

            //把原来的child位置的数值赋值给index位置
//            heap[b] = heap[a]

            val temp = heap[a]

            heap[a] = heap[b]
            heap[b] = temp
        }

        /**
         * 调整堆，使其满足堆得定义
         *
         *
        93
        /  \
        72   53
        /  \  /  \
        35 40 48  36
        / \
        15 18
         * @param i
         * @param n
         */
        fun adjust(heap: IntArray, i: Int, n: Int) {
            var i = i
            var child: Int
            while (i <= n / 2) {
                child = i * 2
                if (child + 1 <= n && heap[child] < heap[child + 1]) child += 1 /*使child指向值较大的孩子*/
                i = if (heap[i] < heap[child]) {
                    swap(heap, i, child)
                    /*交换后，以child为根的子树不一定满足堆定义，所以从child处开始调整*/child
                } else break
            }
        }

        /*根据树的性质建堆，树节点前一半一定是分支节点，即有孩子的，所以我们从这里开始调整出初始堆*/
        fun adjust(heap: IntArray) {
            for (i in heap.size / 2 downTo 1) adjust(heap, i, heap.size - 1)
            println("=================================================")
            println("调整后的初始堆：")
            print(heap)
        }


        adjust(array)
        array.forEach {
            print("$it ")
        }


    }

    @Test
    fun test121() {
        fun maxProfit(prices: IntArray): Int {
            var pre = 0

            for (i in 0 until prices.size - 1) {
                for (j in i + 1 until prices.size) {

                    if (prices[j] > prices[i]) {
                        pre = Math.max(prices[j] - prices[i], pre)
                    }

                }
            }

            return pre
        }

        fun maxProfit2(prices: IntArray): Int {
            var minPrice = Int.MAX_VALUE

            var res = 0
            for (i in prices.indices) {

                if (prices[i] < minPrice && prices[i] - minPrice < res){
                    minPrice = prices[i]

                } else {
                    res = Math.max(prices[i] - minPrice, res)

                }
            }

            return res
        }
        /*
        在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
     注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。

         */


//        println(maxProfit2(intArrayOf(1,2)))
        println(maxProfit2(intArrayOf(7, 1, 5, 3, 6, 4)))
//        println(maxProfit2(intArrayOf(7, 6, 5, 3, 2, 1)))

//        val time = measureTimeMillis {
//            maxProfit(
//                intArrayOf(886,729,539,474,5,653,588,198,313,111,38,808,848,364,819,747,520,568,583,253,605,442,779,903,217,284,927,33,859,75,418,612,174,316,167,40,945,740,174,279,985,133,38,919,528,844,101,291,673,561,244,827,602,58,777,625,95,563,102,400,921,988,472,629,781,215,7,131,220,147,841,511,201,558,435,802,995,514,83,618,399,542,352,34,943,983,498,20,235,156,768,237,828,41,205,188,229,307,514,548,827,369,381,202,498,27,948,118,696,355,929,148,348,383,472,125,916,639,801,775,285,38,70,117,725,35,162,586,329,540,482,148,113,317,732,115,715,119,891,161,338,939,412,615,304,511,604,969,912,729,331,352,533,981,831,949,134,85,927,750,564,77,464,261,576,702,354,330,974,570,575,548,503,275,957,856,463,286,918,626,295,501,21,251,561,261,485,116,761,506,412,671,249,880,63,359,297,84,241,697,496,291,238,86,342,240,409,893,733,162,867,726,965,111,442,265,870,32,369,991,515,120,333,354,521,914,969,771,80,990,562,936,571,330,768,213,699,199,96,971,511,393,203,435,591,228,224,549,479,467,570,448,766,338,426,222,177,232,749,82,514,344,798,951,389,844,491,129,499,19,666,384,243,546,516,513,945,961,19,126,239,378,832,300,112,748,378,232,556,235,635,129,23,573,112,509,448,428,126,169,892,276,231,215,165,642,965,604,28,73,732,340,990,889,800,644,209,275,729,840,71,3,513,255,744,259,609,173,359,445,704,6,862,768,254,633,957,131,101,556,670,446,162,685,83,565,496,587,357,19,311,684,361,189,712,261,719,917,842,313,522,563,293,355,853,675,460,832,798,322,139,960,633,670,213,289,957,648,571,35,445,418,38,760,715,540,727,13,491,828,281,32,974,517,401,845,523,564,581,335,907,452,23,763,459,158,679,983,954,466,357,534,550,967,207,788,39,873,170,591,428,605,458,105,930,462,949,446,260,418,984,67,539,919,716,509,236,221,832,497,628,228,588,849,364,112,808,732,691,540,623,579,181,580,60,277,577,198,231,169,399,90,1,389,367,417,56,780,628,133,326,331,174,243,2,484,189,728,273,601,7,726,720,226,822,185,348,512,629,626,887,389,613,800,884,588,898,656,561,727,970,389,381,21,977,919,195,330,66,829,684,494,523,393,473,423,505,799,172,610,41,847,431,367,808,794,913,55,819,615,478,226,398,24,663,83,589,300,691,759,940,514,649,16,493,56,236,479,825,616,473,87,51,340,428,346,35,22,592,791,733,470,294,688,803,431,491,198,689,29,458,741,115,888,359,811,747,78,510,632,623,778,551,107,157,541,760,43,724,954,686,703,391,883,756,357,48,426,267,260,443,496,562,361,504,888,463,219,814,901,220,433,654,843,709,323,748,790,399,701,890,106,201,237,865,11,259,535,871,839,51,697,418,432,852,208,837,20,499,917,906,298,733,672,739,410,655,80,3,497,781,727,673,533,524,918,286,384,218,904,357,834,980,150,905,405,273,712,622,842,710,937,90,191,548,815,533,274,923,610,581,473,195,282,418,424,248,727,196,210,955,234,163,196,420,102,367,53,559,6,531,369,736,392,363,199,602,29,489,313,668,704,76,949,455,235,106,197,754,92,357,681,936,369,445,489,924,925,455,587,257,951,192,536,60,410,966,593,832,71,543,568,612,799,717,46,358,715,122,139,605,782,500,126,871,497,798,533,903,884,172,714,689,43,910,322,232,75,589,14,728,516,795,309,307,618,152,495,39,986,930,167,866,530,439,700,995,42,211,362,190,596,91,183,987,590,404,644,365,606,678,234,51,463,877,519,323,276,429,263,810,478,206,448,512,197,875,424,25,131,677,65,607,401,224,834,58,745,396,411,937,229,910,43,559,439,958,499,787,352,352,738,297,285,247,273,307,730,320,477,610,671,209,23,14,198,502,704,13,804,454,218,922,545,491,546,439,580,318,24,743,580,230,811,713,592,763,532,798,374,172,200,131,299,576,484,296,522,605,92,421,317,873,942,831,496,547,606,750,714,125,384,105,716,716,562,257,296,123,246,64,624,354,982,295,301,830,493,512,88,593,704,361,634,258,370,238,588,548,846,421,247,515,553,178,645,496,5,738,187,153,468,152,860,164,681,99,153,174,98,307,873,56,732,928,671,101,909,377,800,306,321,313,308,117,958,615,328,573,475,940,884,328,206,664,874,447,966,752,39,91,367,472,376,273,418,854,600,648,808,877,40,79,306,227,181,689,556,401,644,758,204,777,187,49,330,649,793,490,507,946,440,776,207,987,243,40,796,631,835,432,18,83,930,877,132,708,90,854,541,789,164,58,191,911,971,104,38,379,174,410,554,31,655,44,163,943,590,735,264,651,848,858,997,691,943,205,448,263,194,718,669,327,303,357,246,745,484,908,457,889,902,585,308,224,549,707,372,463,235,496,259,214,761,710,176,8,96,713,771,705,693,53,293,714,877,289,902,165,725,471,518,762,700,30,403,970,587,293,674,991,651,288,151,426,554,318,21,88,276,831,681,498,381,369,160,933,48,610,733,74,317,438,387,195,179,417,955,758,936,732,365,740,820,307,622,903,211,284,564,6,409,684,374,902,617,54,399,631,729,4,756,47,725,798,960,647,177,859,312,457,23,903,712,592,656,394,918,995,582,464,837,815,639,753,613,780,584,752,998,870,399,825,520,15,597,994,7,85,592,487,65,884,410,957,59,550,862,982,409,226,161,53,236,355,353,947,630,789,220,464,767,922,725,961,965,685,246,611,222,898,137,462,999,715,617,522,829,477,871,431,976,821,364,79,598,819,916,826,357,541,947,133,495,220,958,518,771,519,544,734,16,105,391,406,498,112,105,28,812,113,131,386,635,810,739,567,338,780,718,90,301,875,606,995,582,786,454,232,358,639,850,356,774,55,842,209,808,781,436,180,166,400,838,763,363,388,822,144,978,45,28,442,928,658,674,54,88,370,758,826,737,801,433,74,691,584,163,742,833,261,740,756,979,525,796,314,368,379,779,37,162,830,394,956,56,938,226,954,173,657,78,682,848,893,153,472,217,592,680,237,695,813,173,36,136,167,186,248,351,820,530,200,358,660,245,618,783,666,755,789,772,709,439,94,738,139,526,521,493,505,478,686,459,979,189,280,952,694,581,634,739,621,100,601,44,873,562,945,6,730,630,661,193,567,889,76,732,143,752,320,722,297,624,624,778,748,181,445,409,482,345,742,919,883,403,147,531,917,399,453,915,161,606,67,804,222,700,989,688,569,595,566,522,499,685,656,462,429,720,953,827,301,480,833,696,829,552,433,700,739,57,630,92,445,565,616,760,539,849,787,68,300,744,189,440,402,763,741,186,145,628,797,728,215,956,8,218,91,131,152,789,563,931,959,707,713,523,302,778,5,733,549,569,818,578,67,610,112,514,221,696,901,611,413,919,9,115,766,126,188,114,712,846,163,678,386,195,421,922,455,735,592,87,650,947,723,671,616,348,191,136,645,445,11,205,623,271,809,576,670,344,40,573,967,206,567,466,597,504,310,559,978,378,445,505,90,799,394,911,184,25,328,578,323,51,801,346,698,371,766,155,925,669,154,390,396,408,859,751,19,422,61,744,192,281,681,259,461,581,768,435,354,535,681,539,270,509,339,457,714,504,711,623,202,848,764,674,624,286,428,921,154,614,773,412,427,400,946,834,765,205,824,663,310,565,950,244,620,232,821,621,890,40,637,851,577,822,909,809,179,287,801,570,18,903,529,849,417,124,112,706,314,947,943,251,276,244,794,820,661,310,150,394,358,821,385,322,252,883,4,873,549,286,690,977,430,226,331,899,399,191,847,349,999,144,678,966,663,711,434,289,682,30,890,120,900,276,881,674,7,103,182,736,509,295,866,272,473,210,664,535,279,589,541,587,591,134,824,899,949,86,840,24,792,125,747,811,749,36,973,719,77,674,803,838,685,365,443,800,594,749,518,484,385,138,169,587,88,872,686,554,668,426,852,76,545,194,468,902,56,266,787,184,337,377,985,204,467,272,576,433,793,629,126,596,648,760,358,750,656,359,676,273,943,798,575,703,561,647,462,250,588,407,57,942,833,669,56,773,600,439,576,184,921,337,91,372,611,951,223,67,676,594,50,551,303,26,907,836,792,623,960,292,698,810,597,906,430,957,130,567,369,931,972,22,83,862,602,481,59,238,332,227,725,675,541,886,189,503,279,314,403,582,504,653,115,278,342,520,742,463,141,591,153,161,128,621,24,90,411,646,302,574,321,364,829,134,742,74,205,650,666,297,149,344,52,268,988,416,583,266,287,655,304,21,418,609,293,861,362,439,770,621,206,466,334,720,890,27,751,395,115,277,223,909,927,641,148,665,553,417,100,34,137,301,839,25,779,121,666,671,267,55,60,496,832,854,356,550,307,219,650,728,501,139,299,900,190,985,636,189,843,470,32,275,600,152,373,118,653,367,40,14,167,56,757,963,668,861,705,300,917,541,635,341,919,675,222,352,772,680,271,492,674,300,536,444,221,635,443,484,491,126,77,790,205,777,171,778,672,483,447,988,788,903,973,295,687,30,972,933,328,947,459,334,286,616,517,577,886,9,781,828,908,647,414,779,969,399,277,264,900,832,976,71,830,627,341,497,512,923,777,387,379,654,403,335,646,392,501,616,494,374,410,659,676,582,628,11,848,805,766,731,578,240,96,821,308,746,148,139,710,652,245,822,958,397,599,349,413,766,386,154,995,430,478,512,903,325,976,639,402,738,6,254,272,830,10,200,450,624,393,101,891,663,390,662,640,343,942,186,490,803,174,997,327,780,863,220,984,813,184,822,677,151,308,783,40,437,123,532,889,555,720,411,946,953,813,645,376,560,463,916,238,171,65,174,953,824,382,861,542,132,199,620,365,59,427,90,571,479,373,482,198,727,707,191,537,568,290,828,751,845,482,459,532,760,702,79,779,831,847,746,74,371,611,404,172,655,499,877,660,241,812,33,52,653,128,544,764,151,685,427,773,6,154,996,462,297,6,673,324,802,852,318,320,313,614,661,389,363,235,198,429,926,441,412,244,809,828,505,8,915,205,413,531,160,318,702,550,811,919,431,444,617,183,561,510,929,434,528,651,144,224,597,27,878,221,635,551,954,18,358,974,73,698,15,47,515,430,718,35,938,562,968,705,706,769,441,296,845,647,130,814,191,121,891,715,546,449,432,838,416,377,481,321,822,35,932,211,546,120,931,542,387,276,740,420,282,531,750,466,295,503,36,362,83,578,524,812,645,821,74,505,65,519,181,598,121,710,45,311,56,824,334,252,169,426,179,122,689,244,872,549,138,770,624,142,456,940,123,971,308,847,691,59,572,617,755,760,815,114,280,706,780,647,750,519,742,539,433,527,790,925,531,244,963,498,644,163,14,328,594,440,920,15,619,0,77,901,73,117,416,697,505,79,694,870,486,92,269,266,501,176,54,71,144,794,355,465,479,585,82,842,544,797,662,664,99,46,988,480,832,429,243,956,722,569,306,758,893,535,119,178,20,877,357,259,180,382,199,963,395,505,603,645,838,55,513,58,353,426,388,699,622,433,901,0,933,153,667,112,158,143,932,537,342,537,958,33,365,853,872,288,822,723,42,867,846,193,488,750,693,408,73,40,469,691,447,3,246,976,920,63,155,807,904,715,618,809,189,569,778,625,451,831,33,209,474,347,243,806,50,673,106,687,270,433,681,23,484,787,632,151,732,10,563,873,391,463,914,190,238,5,402,506,218,514,811,821,411,360,59))
//        }

//        println("time = $time")
    }

    @Test
    fun testEightQueen() {

        fun judge(array: IntArray, row: Int): Boolean {

            for (i in 0 until row) {

                if (array[i] == array[row]  // 在同一列
                    || row - i == Math.abs(array[i] - array[row])
                ) {
                    return false
                }
            }
            return true
        }

        fun printEightQueen(array: IntArray) {

            array.forEach {
                print("$it ")
            }
            println("_________________________________________-")
        }

        var count = 0
        fun eightQueen(array: IntArray?, row: Int) {
            var array = array
            if (array == null) {
                array = IntArray(4)
            }

            if (row == 4) {
                printEightQueen(array)
                return
            }

            for (col in array.indices) {
                count++
                array[row] = col
                if (judge(array, row)) {
                    eightQueen(array, row + 1)
                }
            }


        }

        val time = measureTimeMillis {

            eightQueen(null, 0)
        }
        println("count = $count $time")
    }

    @Test
    fun test57() {

        fun solveNQueens(n: Int): List<List<String>> {
            val list = ArrayList<ArrayList<String>>()

            fun judge(array: IntArray, row: Int): Boolean {

                for (i in 0 until row) {
                    if (array[i] == array[row] || row - i == Math.abs(array[row] - array[i])) {
                        return false
                    }
                }
                return true
            }

            fun queen(array: IntArray?, row: Int) {
                var array = array
                if (array == null) {
                    array = IntArray(n)
                }

                if (row == n) {
                    // 已经得到一次结果
                    val newList = ArrayList<String>()
                    array.forEach { col ->
                        newList.add(buildString {
                            for (i in 0 until n) {
                                append(if (i == col) 'Q' else '.')
                            }
                        })
                    }
                    list.add(newList)
                    return
                }

                for (col in 0 until n) {

                    array[row] = col
                    if (judge(array, row)) {
                        queen(array, row + 1)
                    }
                }

            }

            queen(null, 0)
            return list
        }

        solveNQueens(4)
    }

    @Test
    fun test52() {

        fun totalNQueens(n: Int): Int {
            var res = 0
            fun judge(array: IntArray, row: Int): Boolean {

                for (i in 0 until row) {
                    if (array[i] == array[row] || row - i == Math.abs(array[row] - array[i])) {
                        return false
                    }
                }
                return true
            }

            fun queen(array: IntArray?, row: Int) {
                var array = array
                if (array == null) {
                    array = IntArray(n)
                }

                if (row == n) {
                    // 已经得到一次结果
                    res++
                    return
                }

                for (col in 0 until n) {

                    array[row] = col
                    if (judge(array, row)) {
                        queen(array, row + 1)
                    }
                }

            }
            queen(null, 0)
            return res
        }
        println("totalNQueens = ${totalNQueens(8)}")

    }

    @Test
    fun test155() {

        val minStack = MinStack()
        /**
         * //MinStack minStack = new MinStack();
        //minStack.push(-2);
        //minStack.push(0);
        //minStack.push(-3);
        //minStack.getMin();   --> 返回 -3.
        //minStack.pop();
        //minStack.top();      --> 返回 0.
        //minStack.getMin();   --> 返回 -2.]
         */
        minStack.push(-2)
        minStack.push(0)
        minStack.push(-3)
        minStack.getMin().print()
        minStack.pop()
        minStack.top().print()
        minStack.getMin().print()

        println("-----------")
        val deque = java.util.LinkedList<Int>()
        deque.peek().print()
    }

    @Test
    fun test232() {

        val deque = MyQueue()
        deque.push(1)
        deque.push(2)
        deque.peek().print()
        deque.pop().print()
        deque.empty().print()
    }

    @Test
    fun test844() {

        fun backspaceCompare(s: String, t: String): Boolean {
            val stack = Stack<Char>()
            val stack2 = Stack<Char>()
            for (i in s) {
                if (i == '#') {
                    if (stack.size > 0) {
                        stack.pop()
                    }
                } else {
                    stack.push(i)
                }
            }
            for (i in t) {
                if (i == '#') {
                    if (stack2.size > 0) {
                        stack2.pop()
                    }
                } else {
                    stack2.push(i)
                }

            }
            if (stack.size == stack2.size && stack.containsAll(stack2)) {

                var i = 0


                while (i < stack.size) {
                    if (stack[i] != stack2[i]) {

                        return false
                    }
                    i++
                }
                return true
            }
            return false

        }

        fun backspaceCompare2(s: String, t: String): Boolean {

            val sLength = s.length
            val tLength = t.length
            var i =sLength- 1
            var j = tLength - 1
            var skipS = 0
            var skipT = 0
            while (i >= 0 || j >= 0) {

                while (i >= 0) {
                    if (s[i] == '#') {
                        skipS++
                        i--

                    } else if (skipS > 0) {
                        skipS--
                        i--
                    } else {
                        break
                    }
                }

                while (j >= 0) {
                    if (t[j] == '#') {
                        skipT++
                        j--

                    } else if (skipT > 0) {
                        skipT--
                        j--
                    } else {
                        break
                    }

                }
                if (i >=0 && j >= 0) {
                    if (s[i] != t[j]) {
                        return false
                    }

                } else {
                    if (i >= 0 || j >= 0) {
                        return false
                    }
                }
                i--
                j--
            }
            return true
        }
//        backspaceCompare2("a#c", "b").print()
//        backspaceCompare2("a##c", "#a#c").print()
//        backspaceCompare2("xywrrmp", "xywrrm#p").print()
//        backspaceCompare2("abc#", "bac#").print()
        backspaceCompare2("bxj##tw", "bxj###tw").print()
    }

    @Test
    fun testQuickSort(){
        val array = intArrayOf(2, 9, 7, 4, 0, 8, 5, 3, 1, 6)


        quickSort(array, 0, array.size - 1)
        array.forEach {
            print("$it ")
        }
    }

    @Test
    fun testLRD() {

        BinaryTree().run {
            val root = createTree()
            root.show()
//            this.LRD(root)
//            posOrderUnRecur2(root)
            inorderWithRec(root)
            println()
            inorder(root)
            println()
            printTree2(root)
        }
    }

    @Test
    fun testShellSort() {
        fun shellSort(array: IntArray) {

        }

        val array = intArrayOf(3, 4, 9, 1, 2, 8, 7, 5, 6, 0)
        shellSort(array)

    }
    @Test
    fun testSelectSort() {
        fun selectSort(array: IntArray) {
            for (i in 1 until array.size) {
                var j = i
                val target = array[i]

                while (j > 0 && array[j - 1] > target) {

                    array[j] = array[j-1]
                    j--
                }
                array[j] = target
            }

        }

        val array = intArrayOf(3, 4, 9, 1, 2, 8, 7, 5, 6, 0)
        selectSort(array)

    }

    @Test
    fun testInOrderTree(){
        val binaryTree = BinaryTree()
        val createTree = binaryTree.createTree()
        createTree.show()
        binaryTree.postOrder(createTree)

    }

    @Test
    fun testPreOrder() {

        val binaryTree = BinaryTree()
        val createTree = binaryTree.createTree()
        createTree.show()
        binaryTree.preOrder(createTree)
        println()
        binaryTree.getInorder(createTree)
        println()
        binaryTree.postOrder(createTree)
        println()
    }

}

fun quickSort(array: IntArray, begin: Int, end: Int) {
    if (end - begin <= 0) return
    val x = array[begin]
    var low = begin //0
    var high = end //5
    var direction = true
    L1@ while (low < high) {
        if (direction) {
            for (i in high downTo low + 1) {
                if (array[i] <= x) {
                    array[low++] = array[i]
                    high = i
                    direction = !direction
                    continue@L1
                }
            }
            high = low
        } else {
            for (i in low until high) {
                if (array[i] >= x) {
                    array[high--] = array[i]
                    low = i
                    direction = !direction
                    continue@L1
                }
            }
            low = high
        }
    }
    //把最后找到的值 放入中间位置
    array[low] = x
    //开始完成左右两边的操作
    quickSort(array, begin, low - 1)
    quickSort(array, low + 1, end)
}
fun Any?.print() {
    println(this)
}

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

class MinStack() {


    /** initialize your data structure here. */
    private val deque = java.util.LinkedList<Int>()
    private val minDeque = java.util.LinkedList<Int>()

    private var minValue = Int.MAX_VALUE

    fun push(`val`: Int) {
        minDeque.push(Math.min(`val`, minDeque.peek() ?: Int.MAX_VALUE))

        deque.push(`val`)
//
//        if (deque.size > 0){
//            val pre = deque.peek()
//            if (pre < `val`) {
//                deque.pop()
//                deque.push(pre)
//                deque.push(`val`)
//            } else {
//                deque.push(`val`)
//            }
//        } else {
//            deque.push(`val`)
//        }
    }

    fun pop() {
        deque.pop()
        minDeque.pop()
    }

    fun top(): Int {
        return deque.peek()
    }

    fun getMin(): Int {
        return minDeque.peek()
    }

}
class MyQueue() {

    /** Initialize your data structure here. */
    val list = java.util.LinkedList<Int>()


    /** Push element x to the back of queue. */
    fun push(x: Int) {
        list.offer(x)
    }

    /** Removes the element from in front of queue and returns that element. */
    fun pop(): Int {
        return list.pop()
    }

    /** Get the front element. */
    fun peek(): Int {
        return list.peek()
    }

    /** Returns whether the queue is empty. */
    fun empty(): Boolean {

        return list.isEmpty()
    }

}