package com.example.algorithm

import org.junit.Test
import java.io.File
import java.io.FileOutputStream
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashSet
import kotlin.math.max
import kotlin.math.min

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
                var i =0
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
}

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}
