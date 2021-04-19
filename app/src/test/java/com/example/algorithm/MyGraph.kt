package com.example.algorithm

import org.junit.Test

/**
 * 浙江集商优选电子商务有限公司
 * @author zenglw
 * @date   4/10/21 1:41 AM
 */
class MyGraph(val verticesSize:Int) {

    constructor() : this(0)

    private val isVisited = BooleanArray(verticesSize){ false}

    val matrixs = Array(verticesSize) { IntArray(verticesSize) }

    private val vertices = IntArray(verticesSize)


    init {
        for ((index, _) in vertices.withIndex()) {
            vertices[index] = index

        }
    }

    /**
     * 获取入度
     */
    fun getInDegree(v : Int): Int {
        var count = 0
        for (e in vertices) {
            if (matrixs[e][v] != 0 && matrixs[e][v] != MAX_WEIGHT) {
                count++
            }
        }
        return count

    }

    /**
     * 获取出度
     */
    fun getOutDegree(v: Int): Int {
        var count = 0
        for (e in vertices) {
            if (matrixs[v][e] != 0 && matrixs[v][e] != MAX_WEIGHT) {
                count++
            }
        }
        return count

    }

    fun getFirstNeighbor(v: Int): Int {

        for (i in 0 until verticesSize) {
            if (matrixs[v][i] != 0 && matrixs[v][i] != MAX_WEIGHT) {
                return i
            }
        }
        return -1
    }

    fun getNextNeighbor (v : Int, index : Int): Int {
        for (i in (index + 1) until verticesSize) {
            if (matrixs[v][i] != 0 && matrixs[v][i] != MAX_WEIGHT) {
                return i
            }
        }
        return -1

    }

    @Test
    fun test() {

    }

    fun dfs(v: Int) {
        isVisited[v] = true
        var firstNeighbor = getFirstNeighbor(v)
        while (firstNeighbor != -1) {

            if (!isVisited[firstNeighbor]) {
                print("$firstNeighbor ")
                dfs(firstNeighbor)
            }

            firstNeighbor = getNextNeighbor(v, firstNeighbor)
        }


    }

    companion object {

        const val MAX_WEIGHT = Int.MAX_VALUE
    }

}