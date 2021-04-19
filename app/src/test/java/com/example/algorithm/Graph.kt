package com.example.algorithm

import org.junit.Test
import java.util.LinkedList

/**
 * 浙江集商优选电子商务有限公司
 *
 * @author zenglw
 * @date 4/9/21 4:15 PM
 */
/**
 * Created by Jett on 2018/12/21.
 */
class Graph(var verticesSize: Int) {
    /**
     * 获取顶点
     */
    var vertices //顶点集
            : IntArray
    var matrix //图的边的信息
            : Array<IntArray>
    var isVisited: BooleanArray
    @Test
    fun test() {

//        graph.bfs();
    }

    /**
     * 计算v1到v2的权重(路径长度)
     */
    fun getWeight(v1: Int, v2: Int): Int {
        val weight = matrix[v1][v2]
        return if (weight == 0) 0 else if (weight == MAX_WEIGHT) -1 else weight
    }

    /**
     * 获取出度
     */
    fun getOutDegree(v: Int): Int {
        var count = 0
        for (i in 0 until verticesSize) {
            if (matrix[v][i] != 0 && matrix[v][i] != MAX_WEIGHT) {
                count++
            }
        }
        return count
    }

    /**
     * 获取入度
     */
    fun getInDegree(v: Int): Int {
        var count = 0
        for (i in 0 until verticesSize) {
            if (matrix[i][v] != 0 && matrix[i][v] != MAX_WEIGHT) {
                count++
            }
        }
        return count
    }

    /**
     * 获取第一个邻接点
     */
    fun getFirstNeightBor(v: Int): Int {
        for (i in 0 until verticesSize) {
            if (matrix[v][i] > 0 && matrix[v][i] != MAX_WEIGHT) {
                return i
            }
        }
        return -1
    }

    /**
     * 获取到顶点v的邻接点index的下一个邻接点
     */
    fun getNextNeightBor(v: Int, index: Int): Int {
        for (i in index + 1 until verticesSize) {
            if (matrix[v][i] > 0 && matrix[v][i] != MAX_WEIGHT) {
                return i
            }
        }
        return -1
    }

    /**
     * 深度优先(很象二叉树的前序)
     */
    fun dfs() {
        for (i in 0 until verticesSize) {
            if (!isVisited[i]) {
                println("viested vertice $i")
                dfs(i)
            }
        }
    }

    fun dfs(i: Int) {
        isVisited[i] = true
        var v = getFirstNeightBor(i)
        while (v != -1) {
            if (!isVisited[v]) {
                println("visted vertice $v")
                dfs(v)
            }
            v = getNextNeightBor(i, v)
        }
    }

    /**
     * 广度优先
     */
    fun bfs() {
        for (i in 0 until verticesSize) {
            isVisited[i] = false
        }
        for (i in 0 until verticesSize) {
            if (!isVisited[i]) {
                isVisited[i] = true
                println("visited vertice:$i")
                bfs(i)
            }
        }
    }

    fun bfs(i: Int) {
        val queue = LinkedList<Int>()
        //找第一个邻接点
        val fn = getFirstNeightBor(i)
        if (fn == -1) {
            return
        }
        if (!isVisited[fn]) {
            isVisited[fn] = true
            println("visted vertice:$fn")
            queue.offer(fn)
        }
        //开始把后面的邻接点都入队
        var next = getNextNeightBor(i, fn)
        while (next != -1) {
            if (!isVisited[next]) {
                isVisited[next] = true
                println("visted vertice:$next")
                queue.offer(next)
            }
            next = getNextNeightBor(i, next)
        }
        //从队列中取出来一个，重复之前的操作
        while (!queue.isEmpty()) {
            val point = queue.poll() //v1  v2
            bfs(point)
        }
    }

    companion object {
        const val MAX_WEIGHT = Int.MAX_VALUE
    }

    init {
        vertices = IntArray(verticesSize)
        matrix = Array(verticesSize) { IntArray(verticesSize) }
        isVisited = BooleanArray(verticesSize)
        for (i in 0 until verticesSize) {
            vertices[i] = i
        }
    }
}