package com.example.algorithm

import java.util.*

/**
 * 浙江集商优选电子商务有限公司
 * @author zenglw
 * @date   4/19/21 12:16 AM
 */

class Kruskal(val verticeSize: Int) {


    var edgeSize = 0

    private lateinit var edges: Array<Edge>

    private var matrix: Array<IntArray> = Array(verticeSize) { IntArray(verticeSize) }

    data class Edge(var start: Int, var end: Int, var weight: Int) : Comparable<Edge> {
        override fun compareTo(other: Edge): Int {
            return if (weight > other.weight) {
                1
            } else {
                -1
            }
        }
    }


    init {


        val v0 = intArrayOf(0, 50, 60, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT)
        val v1 = intArrayOf(50, 0, MAX_WEIGHT, 65, 40, MAX_WEIGHT, MAX_WEIGHT)
        val v2 = intArrayOf(60, MAX_WEIGHT, 0, 52, MAX_WEIGHT, MAX_WEIGHT, 45)
        val v3 = intArrayOf(MAX_WEIGHT, 65, 52, 0, 50, 30, 42)
        val v4 = intArrayOf(MAX_WEIGHT, 40, MAX_WEIGHT, 50, 0, 70, MAX_WEIGHT)
        val v5 = intArrayOf(MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, 30, 70, 0, MAX_WEIGHT)
        val v6 = intArrayOf(MAX_WEIGHT, MAX_WEIGHT, 45, 42, MAX_WEIGHT, MAX_WEIGHT, 0)
        matrix[0] = v0
        matrix[1] = v1
        matrix[2] = v2
        matrix[3] = v3
        matrix[4] = v4
        matrix[5] = v5
        matrix[6] = v6
    }

    fun test() {

        selectSort2(intArrayOf(9, 2, 3, 7, 1, 0))
        getEdges()
//        for (i in edges) {
//            println(i)
//        }
//        sortEdge(edges, verticeSize)
        val cur_edge = edges
        val rets = Array<Edge>(edgeSize) { Edge(-1, -1, -1)}
        Arrays.sort(edges)

        val edge_temp = IntArray(edgeSize)
        var index =0
        for (i in 0 until edgeSize) {

            val p1 = cur_edge[i].start
            val p2 = cur_edge[i].end

            var m = getEnd(edge_temp, p1)
            var n = getEnd(edge_temp, p2)

            if (m !=n){
                rets[index++] = cur_edge[i]
                if (m > n) {
                    val temp =m
                    m = n
                    n = temp
                }
                edge_temp[m] = n
            }
        }

        var length =0
        for (i in 0 until index ){
            length += rets[i].weight
        }

        println("最小生成树的权重之和$length")
        val chars = CharArray(verticeSize)
        chars[0] = 'A'
        chars[1] = 'B'
        chars[2] = 'C'
        chars[3] = 'D'
        chars[4] = 'E'
        chars[5] = 'F'
        chars[6] = 'G'

        for (i in 0 until index) {
            System.out.printf(
                "(%s, %s)---> %d \n",
                chars[rets[i].start], chars[rets[i].end], matrix[rets[i].start][rets[i].end]
            )
        }



//        println("-----------------------------_")
//        for (i in edges) {
//            println(i)
//        }

    }

    private fun getEnd(edge_temp: IntArray, p: Int): Int {

        var i = p
        while (edge_temp[i] != 0) {
            i = edge_temp[i]
        }
        return i
    }

    private fun sortEdge(cur_edge: Array<Edge>, size: Int) {
        for (i in 0 until size) {
            for (j in i + 1 until size) {
                if (edges[i].weight > edges[j].weight) {
                    val tmp: Edge = edges[i]
                    edges[i] = edges[j]
                    edges[j] = tmp
                }
            }
        }
    }

    fun sortEdge() {
        for (i in 0 until verticeSize - 1) {
            var k = i
            for (j in i + 1 until verticeSize) {
                if (edges[k].weight > edges[j].weight) {
                    k = j
                }
            }
            if (k != i) {
                val temp = edges[i]
                edges[i] = edges[k]
                edges[k] = temp
            }

        }
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
            }
        }
        for (i in array) {
            print("$i ")
        }
    }

    fun getEdges() {
        var index = 0
        edges = Array(verticeSize * verticeSize) { Edge(-1, -1, MAX_WEIGHT) }

        for (i in 0 until verticeSize) {
            for (j in 0 until verticeSize) {
                if (matrix[i][j] != 0 && matrix[i][j] != MAX_WEIGHT) {
//                    edges[index] = Edge(i, j, matrix[i][j])
                    edges[index].apply {
                        start = i
                        end = j
                        weight = matrix[i][j]
                    }
                    index++
                }
            }
        }
        edgeSize = index
    }

    companion object {
        const val MAX_WEIGHT = 0xFFF8
    }

}