package com.example.algorithm

import org.junit.Test

/**
 * 浙江集商优选电子商务有限公司
 * @author zenglw
 * @date   4/22/21 9:27 AM
 */
class JiuGongGe {
    @Test
    fun test() {

        fun jiugongge(array: Array<IntArray>, n: Int) {
            var x = 1
            var col = n / 2
            var row = 0
            array[row][col] = x

            while (x < n * n) {
                x++
                val tempRow = row
                val tempCol = col
                row--
                if (row < 0) {
                    row = n - 1
                }

                col++
                if (col == n) {
                    col = 0
                }
                if (array[row][col] == 0) {
                    array[row][col] = x

                } else {
                    row = tempRow
                    col = tempCol
                    row++
                    array[row][col] = x
                }
            }
        }

        val array = Array(3) { IntArray(3) { 0} }


        jiugongge(array, 3)
        array.forEach {
            it.forEach {
                print("$it ")
            }
            println()
        }
    }
}