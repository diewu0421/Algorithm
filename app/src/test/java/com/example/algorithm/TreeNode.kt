package com.example.algorithm

/**
 * 浙江集商优选电子商务有限公司
 * @author zenglw
 * @date   4/7/21 1:53 PM
 */
class TreeNode<T : Comparable<T>>(
    @JvmField
    var left: TreeNode<T>? = null,
    @JvmField
    var right: TreeNode<T>? = null,
    @JvmField
    var data: T? = null,
    @JvmField
    var parent: TreeNode<T>? = null,
    @JvmField
    var `val`: Int = 0,
    @JvmField
    var balance: Int = 0// r
) {

    constructor(data: T?) : this(null, null, data, null)

}