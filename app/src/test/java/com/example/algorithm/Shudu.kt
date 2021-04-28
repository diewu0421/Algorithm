package com.example.algorithm

import org.junit.Test

/**
 * 浙江集商优选电子商务有限公司
 * @author zenglw
 * @date   4/22/21 11:43 AM
 */
class Shudu {

    @Test
    fun test() {

        shudu(0, 0)

    }

    private fun shudu(row: Int, col: Int) {
        var row = row

        var col = col
        if (row == 8 && col == 9) {
            printResult()
            return
        }
        if (col == 9) {
            row++
            col = 0
        }
        if (array[row][col] == 0) {
            for (k in 1..9) {
                if (judge(row, col, k)) {
                    array[row][col] = k
                    shudu(row, col + 1)
                    array[row][col] = 0

                }
            }
        } else {

            shudu(row, col + 1)

        }
    }

    private fun printResult() {
        for (i in array.indices) {
            for (j in array.indices) {
                print("${array[i][j]} ")
            }
            println()
        }
    }

    private fun judge(row: Int, col: Int, x: Int): Boolean {
        // 行和列不重复
        for (i in array.indices) {
            for (j in array.indices) {
                if (array[i][col] == x || array[row][j] == x) {
                    return false
                }
            }

        }
        val leftRow = row - row % 3
        val leftCol = col - col % 3
        for (i in 0 until 3) {
            for (j in 0 until 3) {
                if (array[i + leftRow][j + leftCol] == x) {
                    return false
                }
            }
        }
        return true
        // 0 1 2   3 4 5   6 7 8
    }

    var array = arrayOf(
        intArrayOf(8, 0, 0, 0, 0, 0, 0, 0, 0),
        intArrayOf(0, 0, 3, 6, 0, 0, 0, 0, 0),
        intArrayOf(0, 7, 0, 0, 9, 0, 2, 0, 0),
        intArrayOf(0, 5, 0, 0, 0, 7, 0, 0, 0),
        intArrayOf(0, 0, 0, 0, 4, 5, 7, 0, 0),
        intArrayOf(0, 0, 0, 1, 0, 0, 0, 3, 0),
        intArrayOf(0, 0, 1, 0, 0, 0, 0, 6, 8),
        intArrayOf(0, 0, 8, 5, 0, 0, 0, 1, 0),
        intArrayOf(0, 9, 0, 0, 0, 0, 4, 0, 0)
    )
}